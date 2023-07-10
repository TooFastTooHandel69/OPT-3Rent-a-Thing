package com.company;

import java.util.ArrayList;
import java.util.List;

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
