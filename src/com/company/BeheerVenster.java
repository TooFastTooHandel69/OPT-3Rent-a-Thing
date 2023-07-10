package com.company;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class BeheerVenster extends JFrame {
    public enum ProductType {
        AUTO, VRACHTWAGEN, BOOR
    }

    JList<ProductType> productTypeLijst;

    public BeheerVenster() {
        productTypeLijst = new JList<>(ProductType.values());
        productTypeLijst.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    ProductType geselecteerdProductType = productTypeLijst.getSelectedValue();
                    ToevoegenVenster toevoegenVenster = new ToevoegenVenster(geselecteerdProductType.name());
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



