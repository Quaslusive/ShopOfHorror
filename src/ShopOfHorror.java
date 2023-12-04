import java.math.BigDecimal;
import java.util.Scanner;

/*
Skriven av Carl Sundberg

Komplettering #1
2023-11-21
 */

public class ShopOfHorror {
    static Scanner sc = new Scanner(System.in); // Skanner
    static int selection; // Meny

    public static void main(String[] args) {

        ShoppingCart shoppingCart = new ShoppingCart();
        ShopInventory[] products = {  // Lägger till objekts i array
                new ShopInventory("1. Mask", 235.50, 14),
                new ShopInventory("2. Plastic knife", 45.50, 3),
                new Discount("3. Fake blood", 89.10, 44, 0.1)
        };

        while (true) { // printar ut innehåll
            for (ShopInventory x : products) {
                System.out.println(x.getProduct() + ", " + x.getPrice() + " SEK, " + x.getQuantity() + " left");

            }
            System.out.println("4. Quite ");
            System.out.print("Choose your option: ");

            // Jag har försökt att snygga till error meddelanden, men jag lyckades inte få det att se bra ut
            try {
                selection = sc.nextInt();
            } catch (Exception e) {
                System.err.println("Only Numbers Allowed. Please Try Again ");
            }
            sc.nextLine();

            // Jag har haft lite svårt med if-else satser. Jag ska försöka att bli bättre på dom
            if (selection < 0 || selection > 4) {  // Om användaren skriver över eller under gränsen
                System.err.println("Out of Bounds. Please Try Again");
            }
            if (selection == products.length + 1) { // När användaren trycker på "4. Quite" avslutas programmet.
                System.out.println("You purchased a total of " + shoppingCart.getTotalAmount() + " items. The total cost was " + shoppingCart.getTotalCost() + " SEK ");
                System.exit(0);
            } else if (selection > 0 && selection <= products.length) {
                ShopInventory product = products[selection - 1];
                if (product.getQuantity() > 0) {
                    product.setQuantity(product.getQuantity() - 1);
                    shoppingCart.setTotalAmount(shoppingCart.getTotalAmount() + 1);
                    shoppingCart.setTotalCost(shoppingCart.getTotalCost() + product.getPrice());
                } else {
                    System.err.println("Sorry, this item is out of stock.");
                }
            }
        }
    }
}
