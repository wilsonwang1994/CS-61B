public interface Say{
  public static final String INTRO = "Hello!!";
  /*
   * Suppose a subclass inherits a "public static final" constant from a
   * superclass, and implements a Java interface that contains a
   * "public static final" constant with the same name.
   *
   * public static final String introduction = "Hi!!";
   *
   * Can compile, there is not issue, doesn't matter whether they have
   * the same value or not
  /*
   * If the method declaration in the interface has a different return
   * type?
   *
   * public int say();
   *
   * Compile-time error: return type void is not compatible with int
  */
  public void say();

  /*
   * if the method declaration in the interface has the same return type,
   * but a signature with a different parameter type?
   *
   * public void say(int i);
   *
   * Compile-time error: does not override abstract method
  */

  /*
   * if the method declaration in the interface has the same return type,
   * and the same number of parameters and parameter types, but those
   * parameters have different names?
   *
   * public void say(int t);
   *
   * Valid
  */

  /* We must implement the "interface" method. No need to
   * override the method from Super class.
   */
}
