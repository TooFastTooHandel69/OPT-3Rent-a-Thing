package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class LoginDemo {
    private JFrame loginFrame;
    private JTextField loginVeld;
    private JPasswordField wachtwoordVeld;
    private JButton loginKnop;
    String gebruikersnaam = "admin";
    String wachtwoord = "wachtwoord";

    public LoginDemo() {
        maakGUIKlaar();
    }

    public static void main(String[] args) {
        LoginDemo loginDemo = new LoginDemo();
    }

    private void maakGUIKlaar() {
        loginFrame = new JFrame("Inlogvenster");
        loginFrame.setSize(400, 200);
        loginFrame.setLayout(new FlowLayout());

        JLabel gebruikerLabel = new JLabel("Gebruikersnaam: ");
        loginFrame.add(gebruikerLabel);

        loginVeld = new JTextField(20);
        loginFrame.add(loginVeld);

        JLabel wachtwoordLabel = new JLabel("Wachtwoord: ");
        loginFrame.add(wachtwoordLabel);

        wachtwoordVeld = new JPasswordField(20);
        loginFrame.add(wachtwoordVeld);

        loginKnop = new JButton("Inloggen");
        loginKnop.addActionListener(new ButtonKlikListener());
        loginFrame.add(loginKnop);

        loginFrame.setVisible(true);
    }

    private class ButtonKlikListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<Product> producten = new ArrayList<>();
            producten.add(new Auto("Volvo", "Luxe grote familie wagen", true, "Volvo", 2000, 2.50));
            String ingevoerdGebruikersnaam = loginVeld.getText();
            String ingevoerdWachtwoord = new String(wachtwoordVeld.getPassword());

            if (gebruikersnaam.equals(ingevoerdGebruikersnaam) && wachtwoord.equals(ingevoerdWachtwoord)) {
                JOptionPane.showMessageDialog(null, "Welkom, " + ingevoerdGebruikersnaam);
                MenuVenster menuVenster = new MenuVenster(producten);
                menuVenster.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Ongeldige inloggegevens");
            }
        }
    }
}
