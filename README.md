# Simple ERP Flow Simulator

This is a personal Java 21 project I built to practice Object-Oriented Programming (OOP) and handle a classic backend problem: dealing with raw, messy data inputs without letting the application crash.

I wanted to simulate how a basic Enterprise Resource Planning (ERP) system takes user choices, processes them, and stores them safely.

---

## What the app does (Current Flow)

Right now, the application runs entirely in the console and follows a simple 4-step pipeline:

1. User Selection: The ClothingApp (CLI) asks you to pick a clothing type, a size, and a color using numbers.
2. Price Calculation: A PriceCalculator service computes the final price by adding up base prices and surcharges for larger sizes or special colors.
3. Data Export (Serialization): The app bundles everything into a raw CSV-style string line separated by semicolons (e.g., ART-999;JEANS;BLUE;L;44.0).

---

## Code Philosophy and What I focused on

Since I'm building this to learn and improve my coding habits, I focused heavily on Clean Code fundamentals rather than hiding behind huge frameworks like Spring:

* Separation of Concerns: I split the code into three basic packages (userinterface, service, model) so that the business logic doesn't mix with the console inputs.
* Crash Prevention: At first, my Article constructor would easily crash with an ArrayIndexOutOfBoundsException or a NumberFormatException if the CSV string was missing a semicolon or had a typo. I added validation checks and try-catch blocks so that if the data stream is corrupted, the app falls back to safe default values instead of just blowing up.
* JUnit 5 Testing: I wrote unit tests for the PriceCalculator to make sure my switch statements return the correct math. It gave me a lot of confidence to refactor things without breaking the core logic.

---

## How to Run and Test

### Prerequisites
* Java 21 installed on your machine.

### Running the App
Execute the main method in ClothingApp from your IDE or run:
```bash
java com.core.erp.userinterface.ClothingApp