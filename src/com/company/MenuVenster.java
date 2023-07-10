package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MenuVenster extends JFrame {
    JButton overzichtKnop;
    JButton beheerKnop;
    JButton uitloggenKnop;
    List<Product> producten;

    public MenuVenster(List<Product> producten) {
        this.producten = producten;

        overzichtKnop = new JButton("Overzicht");
        beheerKnop = new JButton("Beheer");
        uitloggenKnop = new JButton("Uitloggen");

        JPanel paneel = new JPanel();
        paneel.add(overzichtKnop);
        paneel.add(beheerKnop);
        paneel.add(uitloggenKnop);

        add(paneel);

        setSize(300, 200);
        setTitle("Menu");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        overzichtKnop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                OverzichtVenster overzichtVenster = new OverzichtVenster(producten);
                overzichtVenster.setVisible(true);
            }
        });

        beheerKnop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BeheerVenster beheerVenster = new BeheerVenster();
                beheerVenster.setVisible(true);
            }
        });

        uitloggenKnop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Uitloggen knop geklikt");
                dispose();
            }
        });
    }
}

