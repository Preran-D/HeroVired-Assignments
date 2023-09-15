import java.util.List;

public record Order(int orderId, String date, double totalAmount, String status, List<MenuItem> orderedItems) {

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", date='" + date + '\'' +
                ", totalAmount=" + totalAmount +
                ", orderedItems=" + orderedItems +
                ", status='" + status + '\'' +
                '}';
    }
}
