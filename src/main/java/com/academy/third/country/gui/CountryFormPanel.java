package com.academy.third.country.gui;

import com.academy.third.country.persistence.Country;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * <li>1. Kontejner - JPanel u kojem će biti polja za unos države</li>
 * <li>2. Kontrola -  JTextField</li>
 * <li>2. LayoutManager - GridLayout</li>
 */
public class CountryFormPanel extends JPanel {
    private final JTextField countryNameTextField = new JTextField();

    public CountryFormPanel() {
        this(new Country());
    }

    public CountryFormPanel(Country country) {
        createFormGUI();
        countryNameTextField.setText(country.getCountryId() != null ? country.getCountry() : "");
    }

    private void createFormGUI() {
        setLayout(new GridLayout(6, 2, 10, 10));

        //Dodati padding oko cijelog panela
        setBorder(new EmptyBorder(15, 15, 15, 15));

        //Labela
        JLabel countryNameLabel = new JLabel("Country:");
        add(countryNameLabel);
        add(countryNameTextField);
    }

    public String getCountry() {
        return this.countryNameTextField.getText();
    }
}
