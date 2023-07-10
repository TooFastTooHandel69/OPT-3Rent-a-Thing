package com.company;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;

class Main {
    public static void main(String[] args) {
        List<Product> producten = new ArrayList<>();
        producten.add(new Auto("Auto 1", "Een leuke auto", true, "Toyota", 1500, 1.6));
        producten.add(new Vrachtwagen("Vrachtwagen 1", "Een grote vrachtwagen", false, 5000, 12.7));
        producten.add(new Boor("Boor 1", "Een sterke boor", true, "Merk A", "Type X"));

        MenuVenster menuWindow = new MenuVenster(producten);
        menuWindow.setVisible(true);
    }
}