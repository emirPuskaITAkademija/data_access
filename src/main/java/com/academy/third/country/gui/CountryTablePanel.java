package com.academy.third.country.gui;

import com.academy.third.country.gui.action.ActionCellEditor;
import com.academy.third.country.gui.action.ActionCellRenderer;
import com.academy.third.country.persistence.Country;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * <li>1. Kontejner - CountryTablePanel - 2 kontejnera (buttonPanel, countryPanel)</li>
 * <li>2. Kontrole - JButton(addCountryButton), JTable</li>
 *
 * JTable <-> CountryTableModel <-> CountryDao
 */
public class CountryTablePanel extends JPanel {

    private final CountryTableModel countryTableModel;

    public CountryTablePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(15, 15, 15, 15));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        JButton addCountryButton = new JButton("Add Country");
        addCountryButton.addActionListener(this::onAddCountryButtonClicked);
        buttonPanel.add(addCountryButton);

        JPanel countryPanel = new JPanel();
        countryPanel.setLayout(new BorderLayout());
        //JTable <-> CountryTableModel <-> DAO/Country
        this.countryTableModel = new CountryTableModel();
        JTable countryTable = new JTable(countryTableModel);
        countryTable.setRowHeight(40);
        countryTable.setDefaultRenderer(Country.class, new ActionCellRenderer());
        countryTable.setDefaultEditor(Country.class, new ActionCellEditor());


        JScrollPane countryScrollPane = new JScrollPane(countryTable);
        countryPanel.add(countryScrollPane, BorderLayout.CENTER);
        countryPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        add(buttonPanel);
        add(countryPanel);
    }

    private void onAddCountryButtonClicked(ActionEvent actionEvent) {
        CountryFrame countryFrame = new CountryFrame(countryTableModel::addCountry);
        countryFrame.setVisible(true);
    }
}
