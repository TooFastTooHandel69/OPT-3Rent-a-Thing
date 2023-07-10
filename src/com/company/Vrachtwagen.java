package com.company;

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
