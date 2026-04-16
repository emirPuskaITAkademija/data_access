package com.academy.third.country.gui;

import com.academy.third.country.persistence.Country;
import com.academy.third.country.persistence.CountryDao;

import javax.swing.table.AbstractTableModel;
import java.sql.Timestamp;
import java.util.List;

// JTable <-> CountryTableModel <-> CountryDao ORM Hibernate without JPA
public class CountryTableModel extends AbstractTableModel {
    private final CountryDao countryDao = new CountryDao();

    private final List<String> columnNames;
    private final List<Country> countries;

    public CountryTableModel() {
        this.columnNames = List.of("Country ID", "Country Name", "Last Update");
        this.countries = countryDao.findAll();
    }

    @Override
    public int getRowCount() {
        return countries.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Country country = countries.get(rowIndex);
        String columnName = columnNames.get(columnIndex);
        return switch (columnName){
            case "Country ID" -> country.getCountryId();
            case "Country Name" -> country.getCountry();
            case "Last Update" -> country.getLastUpdate();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames.get(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        String columnName = columnNames.get(columnIndex);
        return switch (columnName){
            case "Country ID" -> Country.class;
            case "Country Name" -> String.class;
            case "Last Update" -> Timestamp.class;
            default -> null;
        };
    }

    public Country getCountry(int countryId) {
        return countryDao.findById(countryId);
    }

    public void updateCountry(Country country) {
        this.countryDao.update(country);
        for(int i = 0; i < countries.size(); i++){
            Country countryElement = countries.get(i);
            if(countryElement.getCountryId() == country.getCountryId()){
                countries.set(i, country);
                fireTableRowsUpdated(i, i);
                return;
            }
        }
    }

    public void deleteCountry(Country country) {
        this.countries.remove(country);
        this.countryDao.delete(country);
        fireTableDataChanged();
    }

    public void addCountry(Country country) {
        country =  countryDao.save(country);
        this.countries.add(country);
        fireTableDataChanged();
    }
}
