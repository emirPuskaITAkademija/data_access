package com.academy.third.country.gui.action;

import com.academy.third.country.gui.CountryFrame;
import com.academy.third.country.gui.CountryTableModel;
import com.academy.third.country.gui.CountryTablePanel;
import com.academy.third.country.persistence.Country;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class ActionCellEditor extends AbstractCellEditor implements TableCellEditor {

    private Country country;

    @Override
    public Component getTableCellEditorComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 int row, int column) {

        Integer countryId = (Integer) value;
        CountryTableModel countryTableModel = (CountryTableModel) table.getModel();
        country = countryTableModel.getCountry(countryId);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> onDeleteButtonClick(country, countryTableModel));

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(e -> onEditButtonClick(country, countryTableModel));

        JPanel panel = new JPanel();
        panel.add(deleteButton);
        panel.add(editButton);
        return panel;
    }

    private void onEditButtonClick(Country country, CountryTableModel countryTableModel) {
        CountryFrame countryFrame = new CountryFrame(country, countryTableModel::updateCountry);
        countryFrame.setVisible(true);
    }

    private void onDeleteButtonClick(Country country, CountryTableModel countryTableModel) {
        String confirmationText = "Are you sure you want to delete country '%s'?".formatted(country.getCountry());
        int response  = JOptionPane.showConfirmDialog(null,
                confirmationText,
                "Delete Country",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            countryTableModel.deleteCountry(country);
        }
    }


    @Override
    public Object getCellEditorValue() {
        return country;
    }
}
