package com.academy.third.country.gui;

import com.academy.third.country.persistence.Country;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class CountryFrame extends JFrame {

    private final Consumer<Country> countryConsumer;
    private Country country;
    private CountryFormPanel countryFormPanel;

    public CountryFrame(Consumer<Country> countryConsumer) {
        this(new Country(), countryConsumer);
    }

    public CountryFrame(Country country, Consumer<Country> countryConsumer) {
        this.countryConsumer = countryConsumer;
        this.country = country;
        setTitle(country.getCountryId() != null ? "Edit Country" : "Create Country");
        createFormUI(country);
    }

    private void createFormUI(Country country) {
        setSize(500, 300);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(this::onSaveButtonClick);
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        countryFormPanel = new CountryFormPanel(country);
        add(countryFormPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void onSaveButtonClick(ActionEvent actionEvent) {
        country.setCountry(countryFormPanel.getCountry());
        countryConsumer.accept(country);
        this.dispose();
    }
}
