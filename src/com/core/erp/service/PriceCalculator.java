package com.core.erp.service;

public class PriceCalculator {

    public double calculateBasePrice(int type) {
        double result = 0.0;
        switch (type) {
            case 1:
                result = 15.0;  // TSHIRT
                break;
            case 2:
                result = 40.0;  // JEANS
                break;
            case 3:
                result = 8.0;   // UNDERWEAR
                break;
            case 4:
                result = 50.0;  // HOODIE
                break;
            case 5:
                result = 80.0;  // JACKET
                break;
            default:
                result = 15.0;  // Default TSHIRT
                break;
        }
        return result;
    }

    public double calculateSizeSurcharge(int size) {
        double result = 0.0;
        switch (size) {
            case 3:
                result = 1.0;  // M
                break;
            case 4:
                result = 3.0;  // L
                break;
            case 5:
                result = 5.0;  // XL
                break;
            case 6:
                result = 7.0;  // XXL
                break;
            default:
                result = 0.0;  // XS, S ou invalide
                break;
        }
        return result;
    }

    public double calculateColorSurcharge(int color) {
        double result = 0.0;
        switch (color) {
            case 1:
            case 2:
                result = 2.0; // BLACK, WHITE , ORANGE
                break;
            case 3:
            case 4:
                result = 1.0; // BLUE, RED
                break;
            case 5:
                result = 5.0; // SPECIAL
                break;
            default:
                result = 0.0;
                break;
        }
        return result;
    }

    public double calculateTotal(int type, int size, int color) {
        return calculateBasePrice(type) + calculateSizeSurcharge(size) + calculateColorSurcharge(color);
    }
}