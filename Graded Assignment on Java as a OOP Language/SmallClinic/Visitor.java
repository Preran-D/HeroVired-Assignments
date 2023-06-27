package SmallClinic;

public class Visitor {

  private String name;
  private String contactNumber;

  public Visitor(String name, String contactNumber) {
    this.name = name;
    this.contactNumber = contactNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }
}
