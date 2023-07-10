package com.company;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class DetailVenster extends JFrame {
    public DetailVenster(Product product) {
        JLabel naamLabel = new JLabel("Naam: " + product.getNaam());
        JLabel beschrijvingLabel = new JLabel("Beschrijving: " + product.getOmschrijving());
        JLabel prijsLabel = new JLabel("Prijs: " + product.berekenPrijs());
        JLabel opVoorraadLabel = new JLabel("Op voorraad: " + (product.isInVoorraad() ? "Ja" : "Nee"));

        JPanel paneel = new JPanel();
        paneel.add(naamLabel);
        paneel.add(beschrijvingLabel);
        paneel.add(prijsLabel);
        paneel.add(opVoorraadLabel);

        add(paneel);

        setSize(300, 200);
        setTitle("Details");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

