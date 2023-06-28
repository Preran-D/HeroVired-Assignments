public class ObjectCounter {

  private static int counter = 0;

  public ObjectCounter() {
    counter++;
  }

  public static int getObjectCount() {
    return counter;
  }

  public static void main(String[] args) {
    ObjectCounter obj1 = new ObjectCounter();
    ObjectCounter obj2 = new ObjectCounter();
    ObjectCounter obj3 = new ObjectCounter();

    int count = ObjectCounter.getObjectCount();
    System.out.println("Total number of objects created: " + count);
  }
}
