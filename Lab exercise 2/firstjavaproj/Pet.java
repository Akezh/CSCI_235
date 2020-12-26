package firstjavaproj;

public class Pet {
  private String name;

  public Pet(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void eat() {
    System.out.println("Om nom nom");
  }

  public String toString() {
    return "Animal named " + name;
  }

  public static void test() {
    System.out.println("Testing: Pet...");

    {
      Pet a = new Pet("Alan");
      System.out.println(a);
      a.eat();
    }
  }
}