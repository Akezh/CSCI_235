package firstjavaproj;

public class Goose extends Bird {
  private float annoyancePercentage;

  public Goose(String name, float percentage) {
    super(name);
    percentage = Math.max(0.0f, Math.min(1.0f, percentage)); //clamp

    annoyancePercentage = percentage;
  }

  public void eat() {
    System.out.println("honk, honk, stolen human food is great");
  }

  public void sing() {
    System.out.println("am not Disney bird, am goose, honk, honk");
  }

  public void honk() {
    System.out.println("honk, honk");
  }

  public String toString() {
    return "Goose named " + getName() + ", my annoyance: " + annoyancePercentage*100f;
  }

  public static void test() {
    System.out.println("Testing: Goose...");

    {
      Goose a = new Goose("Untitled Goose Game", -0.8f);
      System.out.println(a);
      a.eat();
      a.sing();
      a.honk();
    }

    {
      Bird a = new Goose("Untitled Goose Game Bird", 0.8f);
      System.out.println(a);
      a.eat();
      a.sing();
    }
  }
}