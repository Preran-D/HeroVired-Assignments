public class MenuItem {
    private final int menuId;
    private final String name;
    private final double price;
    private int quantity;

    public MenuItem(int menuId, String name, double price) {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public int getMenuId() {
        return menuId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "menuId=" + menuId +
                " | name='" + name + '\'' +
                " | price=" + price +
                " | quantity=" + quantity +
                '}';
    }
}
