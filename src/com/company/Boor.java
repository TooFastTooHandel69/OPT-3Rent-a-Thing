package com.company;

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
