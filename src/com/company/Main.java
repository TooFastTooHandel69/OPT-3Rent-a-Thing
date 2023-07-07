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



abstract class Product {
    private List<Observer> observers = new ArrayList<>();
    private String naam;
    private String omschrijving;
    private boolean inVoorraad;

    public Product(String naam, String omschrijving, boolean inVoorraad) {
        this.naam = naam;
        this.omschrijving = omschrijving;
        this.inVoorraad = inVoorraad;
    }

    public final double berekenPrijs() {
        double basisPrijs = getBasisPrijs();
        double verzekeringKosten = berekenVerzekeringKosten();
        return basisPrijs + verzekeringKosten;
    }

    protected abstract double getBasisPrijs();

    protected abstract double berekenVerzekeringKosten();

    public void registreerObserver(Observer observer) {
        observers.add(observer);
    }

    public void verwijderObserver(Observer observer) {
        observers.remove(observer);
    }

    public void zetBeschikbaarheid(boolean inVoorraad) {
        this.inVoorraad = inVoorraad;
        notificeerObservers();
    }

    public void notificeerObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public String getNaam() {
        return naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public boolean isInVoorraad() {
        return inVoorraad;
    }
}

interface  Observer {
    void update(Product product);
}

class Auto extends Product {
    private String merk;
    private double gewicht;
    private double motorGrootte;

    public Auto(String naam, String omschrijving, boolean inVoorraad, String merk, double gewicht, double motorGrootte) {
        super(naam, omschrijving, inVoorraad);
        this.merk = merk;
        this.gewicht = gewicht;
        this.motorGrootte = motorGrootte;
    }

    @Override
    protected double getBasisPrijs() {
        return 50;
    }

    @Override
    protected double berekenVerzekeringKosten() {
        return 0.01 * this.motorGrootte;
    }
}

class Vrachtwagen extends Product {
    private double laadvermogen;
    private double motorGrootte;

    public Vrachtwagen(String naam, String omschrijving, boolean inVoorraad, double laadvermogen, double motorGrootte) {
        super(naam, omschrijving, inVoorraad);
        this.laadvermogen = laadvermogen;
        this.motorGrootte = motorGrootte;
    }

    @Override
    protected double getBasisPrijs() {
        return 0.10 * this.laadvermogen;
    }

    @Override
    protected double berekenVerzekeringKosten() {
        return 0.01 * this.motorGrootte;
    }
}

class Boor extends Product {
    private String merk;
    private String type;

    public Boor(String naam, String omschrijving, boolean inVoorraad, String merk, String type) {
        super(naam, omschrijving, inVoorraad);
        this.merk = merk;
        this.type = type;
    }

    @Override
    protected double getBasisPrijs() {
        return 5;
    }

    @Override
    protected double berekenVerzekeringKosten() {
        return 1;
    }
}

interface ProductFabriek {
    Product maakProduct(String naam, String omschrijving, boolean inVoorraad, String merk, double specificatie1, double specificatie2);
}

class AutoFabriek implements ProductFabriek {
    @Override
    public Product maakProduct(String naam, String omschrijving, boolean inVoorraad, String merk, double gewicht, double motorGrootte) {
        return new Auto(naam, omschrijving, inVoorraad, merk, gewicht, motorGrootte);
    }
}

class VrachtwagenFabriek implements ProductFabriek {
    @Override
    public Product maakProduct(String naam, String omschrijving, boolean inVoorraad, String merk, double laadvermogen, double motorGrootte) {
        return new Vrachtwagen(naam, omschrijving, inVoorraad, laadvermogen, motorGrootte);
    }
}

class BoorFabriek implements ProductFabriek {
    @Override
    public Product maakProduct(String naam, String omschrijving, boolean inVoorraad, String merk, double typeCode, double genegeerd) {
        return new Boor(naam, omschrijving, inVoorraad, merk, String.valueOf(typeCode));
    }
}

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
