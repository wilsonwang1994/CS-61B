public class Dog extends Animal implements Say{
  public String owner;

  public Dog() {
    numLegs = 4;
    type = "dog";
    sound = "bark!!!";
    owner = "unknown";
  }
  // Part2
  // Suppose a subclass inherits a method implementation from a superclass, and
  // implements a Java interface (that's the "interface" keyword) that contains
  // a method with the same name and prototype.
  public void say(){
    System.out.println(sound);
  }
  // Java can still compile

  public void talk(){
    System.out.println("Sub");
  }

  public static void main(String[] args){
    System.out.println(Animal.INTRO);
    System.out.println(Say.INTRO);
  /*
   *  System.out.println(INTRO);
   * Does not work because INTRO is ambiguous. Even if INTRO
   * has the same value in the superclass and interface, this line
   * still will not compile.
   *
   * System.out.println("The value of INTRO is: " + INTRO);
  */

  }
}
