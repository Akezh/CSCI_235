package firstjavaproj;

public class Dog extends Pet {
  private boolean isBig;

  public Dog(String name, boolean big) {
    super(name);
    isBig = big;
  }

  public void bark() {
    if (isBig) {
      System.out.println("WOOOOF!");
    } else {
      System.out.println("guf");
    }
  }

  public void eat() {
    if (isBig) {
      System.out.println("FRESH MEAT!");
    } else {
      System.out.println("puppy om nom nom");
    }
  }

  public String toString() {
    return "Dog named " + getName();
  }

  public static void test() {
    System.out.println("Testing: Dog...");

    {
      Dog a = new Dog("Barsik", false);
      System.out.println(a);
      a.eat();
      a.bark();
    }

    {
      Pet a = new Dog("BarsikPet", false);
      System.out.println(a);
      a.eat();
    }
  }
}