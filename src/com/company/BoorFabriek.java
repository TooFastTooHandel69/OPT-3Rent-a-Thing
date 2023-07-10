package com.company;

class BoorFabriek implements ProductFabriek {
    @Override
    public Product maakProduct(String naam, String omschrijving, boolean inVoorraad, String merk, double typeCode, double genegeerd) {
        return new Boor(naam, omschrijving, inVoorraad, merk, String.valueOf(typeCode));
    }
}
