package com.company;

interface ProductFabriek {
    Product maakProduct(String naam, String omschrijving, boolean inVoorraad, String merk, double specificatie1, double specificatie2);
}
