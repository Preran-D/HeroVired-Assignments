public record CollectionReport(String date, double totalCollection) {
    @Override
    public String toString() {
        return "Date: " + date + ", Total Collection: ₹" + totalCollection;
    }
}
