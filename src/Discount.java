// Sub klass till "ShopInventory"
public class Discount extends ShopInventory {
    private final double discount;

    public Discount(String product, double price, int quantity, double discount) {
        super(product, price, quantity); // Ärver från "ShopInventory"
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return super.getPrice() * (1 - discount);
    }
}