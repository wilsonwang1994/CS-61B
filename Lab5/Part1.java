public class Part1 {

  public static void main(String[] args) {

    Animal ani1 = new Animal();
    Dog dog1 = new Dog();
    // dog1 = ani1; // Compile-time error
    // dog1 = (Dog)ani1; // Run-time error
    // ani1 = dog1; // Valid
    // dog1 = (Dog)ani1; // Valid
    ani1.say();
    dog1.say();

    Dog dog2 = new Dog();
    ((Animal)dog2).talk();
    // Jave still calls subclass method becuase dynamic method lookup

    // Animal ani2 = new Animal();
    // ((Dog)ani2).talk();
    // Causes a run-time error because we can't cast the superclass
    // variable to the subclass.

    // Suppose you have an object whose class is the subclass.  Can you figure
    // out a way to call the superclass method on that object without having to
    // go through the subclass method of the same name?
    Dog dog3 = new Dog();
    Animal ani3 = dog3;
    ani3.talk();
    // Still calls subclass method
    // There is no way to call superclass method for subclass object no matter
    // how we cast

    // What about arrays of objects?

    Animal[] aniAry1 = new Animal[3];
    Dog[] dogAry1 = new Dog[3];
    // dogAry1 = aniAry1; // Compile-time error
    // dogAry1 = (Dog[])aniAry1; // Run-time error
    // aniAry1 = dogAry1; // Valid
    // dogAry1 = (Dog[])aniAry1; // Valid
    // System.out.println(Dog.INTRO);
  }
}
