package com.core.erp.userinterface;

import com.core.erp.model.Article;
import com.core.erp.service.PriceCalculator;
import java.util.Scanner;

public class ClothingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriceCalculator calculator = new PriceCalculator();

        System.out.println("=== CLOTHING CONFIGURATOR ===");

        // STEP 1: Capture selections
        System.out.println("\nChoose clothing type (1-Tshirt, 2-Jeans, 3-Underwear, 4-Hoodie, 5-Jacket):");
        int typeChoice = scanner.nextInt();

        System.out.println("\nChoose size (1-XS, 2-S, 3-M, 4-L, 5-XL, 6-XXL):");
        int sizeChoice = scanner.nextInt();

        System.out.println("\nChoose color (1-Black, 2-White, 3-Blue, 4-Red, 5-Special):");
        int colorChoice = scanner.nextInt();

        // STEP 2: Calculate price via our service layer
        double finalPrice = calculator.calculateTotal(typeChoice, sizeChoice, colorChoice);

        // STEP 3: Convert numeric choices to readable text names for storage
        String typeName = switch (typeChoice) {
            case 2 -> "JEANS";
            case 3 -> "UNDERWEAR";
            case 4 -> "HOODIE";
            case 5 -> "JACKET";
            default -> "TSHIRT";
        };

        String sizeName = switch (sizeChoice) {
            case 1 -> "XS";
            case 2 -> "S";
            case 3 -> "M";
            case 4 -> "L";
            case 5 -> "XL";
            case 6 -> "XXL";
            default -> "STANDARD_SIZE";
        };

        String colorName = switch (colorChoice) {
            case 1 -> "BLACK";
            case 2 -> "WHITE";
            case 3 -> "BLUE";
            case 4 -> "RED";
            case 5 -> "SPECIAL";
            default -> "STANDARD_COLOR";
        };

        // STEP 4: DATA SERIALIZATION (Creating the CSV raw string)
        // We pack all data into a single semicolon-separated text line.
        String rawCsvLine = "ART-999;" + typeName + ";" + colorName + ";" + sizeName + ";" + finalPrice;
        System.out.println("\n[ERP Factory] Generated raw CSV data: " + rawCsvLine);

        // STEP 5: DATA PARSING (Creating the real Article object from CSV)
        // We simulate the ERP receiving the data stream and reconstructing the object.
        Article createdArticle = new Article(rawCsvLine);

        System.out.println("ERP SUCCESSFULLY STORED YOUR ARTICLE:");
        System.out.println(createdArticle);
        scanner.close();
    }
}