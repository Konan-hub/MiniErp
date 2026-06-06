package com.core.erp.userinterface;
import com.core.erp.model.Article;
import com.core.erp.service.PriceCalculator;
import java.util.Scanner;

public class ClothingApp {
    public static void main(String[] args) {
        // Initialize Scanner for user input and the pricing service for business logic
        Scanner scanner = new Scanner(System.in);
        PriceCalculator calculator = new PriceCalculator();

        System.out.println("=== CLOTHING CONFIGURATOR ===");

        // Step 1: Capture user selections from the console interface
        System.out.println("\nChoose clothing type (1-Tshirt, 2-Jeans, 3-Underwear, 4-Hoodie, 5-Jacket):");
        int typeChoice = scanner.nextInt();

        System.out.println("\nChoose size (1-XS, 2-S, 3-M, 4-L, 5-XL, 6-XXL):");
        int sizeChoice = scanner.nextInt();

        System.out.println("\nChoose color (1-Black, 2-White, 3-Blue, 4-Red, 5-Special):");
        int colorChoice = scanner.nextInt();

        double finalPrice = calculator.calculateTotal(typeChoice, sizeChoice, colorChoice);

        System.out.println("CALCULATED PRICE: " + finalPrice + "€");

        scanner.close();
    }
}
