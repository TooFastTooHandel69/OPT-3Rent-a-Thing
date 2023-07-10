package com.company;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
                Product product = new Auto(naam, beschrijving, true, type, prijs, 8.5);
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

