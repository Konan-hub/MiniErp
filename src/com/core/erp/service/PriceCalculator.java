package com.core.erp.service;

public class PriceCalculator {

    public double calculateBasePrice(int type) {
        double result ;
        switch (type) {
            case 1 -> result = 15.0;  // TSHIRT
            case 2 -> result = 40.0;  // JEANS
            case 3 -> result = 8.0;   // UNDERWEAR
            case 4 -> result = 50.0;  // HOODIE
            case 5 -> result = 80.0;  // JACKET
            default -> result = 15.0;  // Default TSHIRT
        }
        return result;
    }

    public double calculateSizeSurcharge(int size) {
        double result;
        switch (size) {
            case 3 -> result = 1.0;  // M
            case 4 -> result = 3.0;  // L
            case 5 -> result = 5.0;  // XL
            case 6 -> result = 7.0;  // XXL
            default -> result = 0.0;  // XS, S ou invalide
        }
        return result;
    }

    public double calculateColorSurcharge(int color) {
        double result ;
        switch (color) {
            case 1, 2 -> result = 2.0; // BLACK, WHITE , ORANGE
            case 3, 4 -> result = 1.0; // BLUE, RED
            case 5 -> result = 5.0; // SPECIAL
            default -> result = 0.0;
        }
        return result;
    }

    public double calculateTotal(int type, int size, int color) {
        return calculateBasePrice(type) + calculateSizeSurcharge(size) + calculateColorSurcharge(color);
    }
}