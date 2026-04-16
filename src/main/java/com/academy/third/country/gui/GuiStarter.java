package com.academy.third.country.gui;

import javax.swing.*;

public class GuiStarter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GuiStarter::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Country");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setContentPane(new CountryTablePanel());
        frame.setVisible(true);
    }
}
