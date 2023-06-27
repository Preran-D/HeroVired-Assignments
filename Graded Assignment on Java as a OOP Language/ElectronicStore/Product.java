package ElectronicStore;

public class Product {

  private String Name;
  private String Specification;
  private double cost;
  private int count;

  public Product(String Name, String Specification, double cost, int count) {
    this.Name = Name;
    this.Specification = Specification;
    this.cost = cost;
    this.count = count;
  }

  public String getName() {
    return this.Name;
  }

  public void setName(String Name) {
    this.Name = Name;
  }

  public String getSpecification() {
    return this.Specification;
  }

  public void setSpecification(String Specification) {
    this.Specification = Specification;
  }

  public double getCost() {
    return this.cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public int getCount() {
    return this.count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
