package com.company;

class VrachtwagenFabriek implements ProductFabriek {
    @Override
    public Product maakProduct(String naam, String omschrijving, boolean inVoorraad, String merk, double laadvermogen, double motorGrootte) {
        return new Vrachtwagen(naam, omschrijving, inVoorraad, laadvermogen, motorGrootte);
    }
}
