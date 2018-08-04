package com.programowanie.smell.bar;

public enum IngridientUnit {

    GIN(80), GRENADINE(75), RUM(95), LIME_JUICE(25), WATER_TONIC(20), GREEN_STUFF(10);

    private int price;

    IngridientUnit(int price) {this.price = price;}
    public int getPrice() {return price;}

}
