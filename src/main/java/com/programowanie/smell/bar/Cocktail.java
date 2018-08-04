package com.programowanie.smell.bar;

public class Cocktail implements Beverage {

    private int price;

    @Override
    public int getPrice() {
        return price;
    }

    public Cocktail withIngredient(IngridientUnit ingredientUnit) {
        return withIngredient(ingredientUnit, 1);
    }

    public Cocktail withIngredient(IngridientUnit ingredientUnit, double amount) {
        price += (ingredientUnit.getPrice() * amount);
        return this;
    }
    @Override
    public boolean isAmountLimited() {
        return true;
    }

    @Override
    public boolean isEligbleForStudentDiscount() {
        return false;
    }
}

