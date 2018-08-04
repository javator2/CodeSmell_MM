package com.programowanie.smell.bar;

import java.util.HashMap;
import java.util.Map;

public class Pub {


    public static final String ONE_BEER = "hansa";
    public static final String ONE_CIDER = "grans";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";
    public static final int STUDENT_DISCOUNT = 10;
    public static final int MAX_NUMBER_OF_DRINKS = 2;
    private Map<String, Beverage> menu;

    public Pub() {
        menu = new HashMap<>();
        menu.put(ONE_BEER, new SimpleBeverage(74));
        menu.put(ONE_CIDER, new SimpleBeverage(103));
        menu.put(A_PROPER_CIDER, new SimpleBeverage(110));
        menu.put(GT, new Cocktail()
                .withIngredient(IngridientUnit.GIN)
                .withIngredient(IngridientUnit.GRENADINE)
                .withIngredient(IngridientUnit.LIME_JUICE));
        menu.put(BACARDI_SPECIAL, new Cocktail()
                .withIngredient(IngridientUnit.GIN)
                .withIngredient(IngridientUnit.RUM)
                .withIngredient(IngridientUnit.GRENADINE));

    }

    public int computeCost(String drink, boolean student, int amount) {
        if (!menu.containsKey(drink)) {
            throw new RuntimeException("no such drink exists");
        }

        final Beverage beverage = menu.get(drink);

        if (amount > MAX_NUMBER_OF_DRINKS && beverage.isAmountLimited()) {
            throw new RuntimeException("to many dirnks, max" + MAX_NUMBER_OF_DRINKS);
        }

        int price = beverage.getPrice();

        if (student && beverage.isEligbleForStudentDiscount()) {
            price = price - price / STUDENT_DISCOUNT;
        } return price;
    }
}

// old code witch was refactored

//        if (amount > 2 && (drink == GT || drink == BACARDI_SPECIAL)) {
//            throw new RuntimeException("Too many drinks, max 2.");
//        }
//        int price;
//        if (drink.equals(ONE_BEER)) {
//            price = 74;
//        } else if (drink.equals(ONE_CIDER)) {
//            price = 103;
//        } else if (drink.equals(A_PROPER_CIDER)) price = 110;
//        else if (drink.equals(GT)) {
//            price = ingredient6() + ingredient5() + ingredient4();
//        } else if (drink.equals(BACARDI_SPECIAL)) {
//            price = ingredient6() / 2 + ingredient1() + ingredient2() + ingredient3();
//        } else {
//            throw new RuntimeException("No such drink exists");
//        }
//        if (student && (drink == ONE_CIDER || drink == ONE_BEER || drink == A_PROPER_CIDER)) {
//            price = price - price / 10;
//        }
//        return price * amount;
//    }
//
//    //one unit of rum
//    private int ingredient1() {
//        return 65;
//    }
//
//    //one unit of grenadine
//    private int ingredient2() {
//        return 10;
//    }
//
//    //one unit of lime juice
//    private int ingredient3() {
//        return 10;
//    }
//
//    //one unit of green stuff
//    private int ingredient4() {
//        return 10;
//    }
//
//    //one unit of tonic water
//    private int ingredient5() {
//        return 20;
//    }
//
//    //one unit of gin
//    private int ingredient6() {
//        return 85;
//    }
//}







