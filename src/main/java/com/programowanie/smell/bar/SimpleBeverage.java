package com.programowanie.smell.bar;


public class SimpleBeverage implements Beverage{
        private int price;

        public SimpleBeverage(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean isAmountLimited() {
            return false;
        }
        @Override
        public boolean isEligbleForStudentDiscount() {
            return true;
        }
}
