package firstjavaproj;

public class Cat extends Pet {

  public Cat(String name) {
    super(name);
  }

  public void meow() {
    System.out.println("meow, meow");
  }

  public void eat() {
    System.out.println("drinks milk");
  }

  public String toString() {
    return "Cat named " + getName();
  }

  public static void test() {
    System.out.println("Testing: Cat...");

    {
      Cat a = new Cat("Kotya");
      System.out.println(a);
      a.eat();
      a.meow();
    }

    {
      Pet a = new Cat("KotyaPet");
      System.out.println(a);
      a.eat();
    }
  }
}