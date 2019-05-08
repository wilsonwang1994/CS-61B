public class Animal {
  public String name;
  public String type;
  public String sound;
  public int numLegs;
  public static final String INTRO = "H!!";

  public Animal() {
    name = "unknown";
    type = "unknown";
    sound = "...";
    numLegs = 0;
  }

  public void say(){
  }
  public void talk(){
    System.out.println("Super");
  }
}
