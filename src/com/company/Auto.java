package com.company;

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
