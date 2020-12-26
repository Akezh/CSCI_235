package firstjavaproj;

public class BengalCat extends Cat {
  private float leopardBloodPercentage;

  public BengalCat(String name, float percentage) {
    super(name);
    percentage = Math.max(0.0f, Math.min(1.0f, percentage)); //clamp

    leopardBloodPercentage = percentage;
  }

  public void meow() {
    System.out.println("am not cat, am leopard, aargh");
  }

  public void eat() {
    System.out.println("am not drink milk, am eat meat");
  }

  public String toString() {
    return "Bengal Cat named " + getName()
           + ", percentage of leopard blood: " + leopardBloodPercentage * 100f;
  }

  public static void test() {
    System.out.println("Testing: Bengal Cat...");

    {
      BengalCat a = new BengalCat("Leopard Jeopard", 80f);
      System.out.println(a);
      a.eat();
      a.meow();
    }

    {
      Cat a = new BengalCat("Leopard Jeopard Cat", 80f);
      System.out.println(a);
      a.eat();
      a.meow();
    }
  }
}