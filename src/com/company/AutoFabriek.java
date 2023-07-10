package com.company;

class AutoFabriek implements ProductFabriek {
    @Override
    public Product maakProduct(String naam, String omschrijving, boolean inVoorraad, String merk, double gewicht, double motorGrootte) {
        return new Auto(naam, omschrijving, inVoorraad, merk, gewicht, motorGrootte);
    }
}
