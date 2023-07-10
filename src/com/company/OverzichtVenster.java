package com.company;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;

class OverzichtVenster extends JFrame {
    JList<Product> productLijst;

    public OverzichtVenster(List<Product> producten) {
        productLijst = new JList<>(new DefaultListModel<>());
        for (Product product : producten) {
            ((DefaultListModel<Product>) productLijst.getModel()).addElement(product);
        }

        productLijst.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Product geselecteerdProduct = productLijst.getSelectedValue();
                    DetailVenster detailVenster = new DetailVenster(geselecteerdProduct);
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

