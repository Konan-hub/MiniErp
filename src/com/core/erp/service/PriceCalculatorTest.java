package com.core.erp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceCalculatorTest {

    @Test
    public void shouldReturn44_WhenCalculatingTotalForLargeBlueJeans() {
        // Arrange
        PriceCalculator calculator = new PriceCalculator();

        // Act (Type 2 = Jeans (40€), Size 4 = L (+3€), Color 3 = Blue (+1€))
        double actualPrice = calculator.calculateTotal(2, 4, 3);

        // Assert
        Assertions.assertEquals(44.0, actualPrice, "The price calculation for a Large Blue Jeans is wrong.");
    }

    @Test
    public void shouldReturn17_WhenCalculatingTotalForXsBlackTshirt() {
        // Arrange
        PriceCalculator calculator = new PriceCalculator();

        // Act (Type 1 = Tshirt (15€), Size 1 = XS (+0€), Color 1 = Black (+2€))
        double actualPrice = calculator.calculateTotal(1, 1, 1);

        // Assert
        Assertions.assertEquals(17.0, actualPrice, "The price calculation for an XS Black T-Shirt is wrong.");
    }

    @Test
    public void shouldReturnDefaultPrice_WhenInputsAreInvalid() {
        // Arrange
        PriceCalculator calculator = new PriceCalculator();

        // Act (Type 99 = Invalide, Size 99 = Invalide, Color 99 = Invalide)
        double actualPrice = calculator.calculateTotal(99, 99, 99);

        // Assert (Fallback 15€ + 0€ + 0€ = 15.0)
        Assertions.assertEquals(15.0, actualPrice, "The fallback mechanism for invalid inputs failed.");
    }
}