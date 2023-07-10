package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

class MenuVenster extends JFrame {
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
                OverviewWindow overzichtVenster = new OverviewWindow(producten);
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

    class OverviewWindow extends JFrame {
        JList<Product> productLijst;

        public OverviewWindow(List<Product> producten) {
            productLijst = new JList<>(new DefaultListModel<>());
            for (Product product : producten) {
                ((DefaultListModel<Product>) productLijst.getModel()).addElement(product);
            }

            productLijst.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        Product geselecteerdProduct = productLijst.getSelectedValue();
                        DetailWindow detailVenster = new DetailWindow(geselecteerdProduct);
                        detailVenster.setVisible(true);
                    }
                }
            });

            add(new JScrollPane(productLijst));

            setSize(400, 300);
            setTitle("Overzicht");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    class DetailWindow extends JFrame {
        public DetailWindow(Product product) {
            JLabel naamLabel = new JLabel("Naam: " + product.getNaam());
            JLabel beschrijvingLabel = new JLabel("Beschrijving: " + product.getOmschrijving());
            JLabel opVoorraadLabel = new JLabel("Op voorraad: " + (product.isInVoorraad() ? "Ja" : "Nee"));

            JPanel paneel = new JPanel();
            paneel.add(naamLabel);
            paneel.add(beschrijvingLabel);
            paneel.add(opVoorraadLabel);

            add(paneel);

            setSize(300, 200);
            setTitle("Details");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    class ToevoegenVenster extends JFrame {
        JTextField naamVeld;
        JTextField beschrijvingVeld;
        JTextField prijsVeld;
        JButton toevoegenKnop;

        public ToevoegenVenster(String type) {
            JPanel paneel = new JPanel(new GridLayout(0, 1));

            paneel.add(new JLabel("Naam: "));
            naamVeld = new JTextField(20);
            paneel.add(naamVeld);

            paneel.add(new JLabel("Beschrijving: "));
            beschrijvingVeld = new JTextField(20);
            paneel.add(beschrijvingVeld);

            paneel.add(new JLabel("Prijs: "));
            prijsVeld = new JTextField(20);
            paneel.add(prijsVeld);

            toevoegenKnop = new JButton("Toevoegen");
            toevoegenKnop.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String naam = naamVeld.getText();
                    String beschrijving = beschrijvingVeld.getText();
                    double prijs = Double.parseDouble(prijsVeld.getText());
                    Product product = new Auto("Blauw", "Super Auto", true, "Ferrari", 2000, 8.5);
                    System.out.println("Product toegevoegd: " + product);
                    dispose();
                }
            });
            paneel.add(toevoegenKnop);

            add(paneel);

            setSize(300, 200);
            setTitle("Toevoegen " + type);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    class BeheerVenster extends JFrame {
        JList<String> productTypeLijst;

        public BeheerVenster() {
            productTypeLijst = new JList<>(new String[]{"Auto", "Vrachtwagen", "Boor"});
            productTypeLijst.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        String geselecteerdProductType = productTypeLijst.getSelectedValue();
                        ToevoegenVenster toevoegenVenster = new ToevoegenVenster(geselecteerdProductType);
                        toevoegenVenster.setVisible(true);
                    }
                }
            });

            add(new JScrollPane(productTypeLijst));

            setSize(300, 200);
            setTitle("Beheer");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
}
