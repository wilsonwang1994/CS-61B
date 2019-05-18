/* Homework6Test.java */

import dict.*;

/**
 *  Initializes a hash table, then stocks it with random SimpleBoards.
 **/

public class Homework6Test {

  /**
   *  Generates a random 8 x 8 SimpleBoard.
   **/

  private static SimpleBoard randomBoard() {
    SimpleBoard board = new SimpleBoard();
    for (int y = 0; y < 8; y++) {
      for (int x = 0; x < 8; x++) {
	double fval = Math.random() * 12;
	int value = (int) fval;
	board.setElementAt(x, y, value);
      }
    }
    return board;
  }

  /**
   *  Empties the given table, then inserts "numBoards" boards into the table.
   *  @param table is the hash table to be initialized.
   *  @param numBoards is the number of random boards to place in the table.
   **/

  public static void initTable(HashTableChained table, int numBoards) {
    table.makeEmpty();
    for (int i = 0; i < numBoards; i++) {
      table.insert(randomBoard(), new Integer(i));
    }
  }

  /**
   *  Creates a hash table and stores a certain number of SimpleBoards in it.
   *  The number is 100 by default, but you can specify any number at the
   *  command line.  For example:
   *
   *    java Homework6Test 12000
   **/

  public static void main(String[] args) {
    int numBoards;

    if (args.length == 0) {
      numBoards = 100;
    } else {
      numBoards = Integer.parseInt(args[0]);
    }
    HashTableChained table = new HashTableChained(numBoards);
    initTable(table, numBoards);

    // To test your hash function, add a method to your HashTableChained class
    // that counts the number of collisions--or better yet, also prints
    // a histograph of the number of entries in each bucket.  Call this method
    // from here.


    System.out.println("=====================size, isEmpty=========================");
    HashTableChained table1 = new HashTableChained(25);
    System.out.println("table1's size is: " + table1.size());
    System.out.println("table1 is Empty: " + table1.isEmpty());

    System.out.println("=====================insert================================");
    table1.insert("1", "The first one");
    table1.insert("2", "The second one");
    table1.insert("3", "The third one");
    table1.insert("3", "The third one");
    table1.insert("3", "The third one");
    table1.insert("3", "The third one");
    table1.insert("3", "The third one");
    table1.insert("what", "nani?");
    table1.insert("the","Eh-heng");
    table1.insert("hell!","impolite");
    System.out.println(table1);
    // System.out.println("table's size is: " + table.size());
    // System.out.println("table is Empty: " + table.isEmpty());
    // String [] output = table.String();
    // for(String s : output){
    //   if(s != null) {
    //     System.out.println(s);
    //   }
    // }


    System.out.println("====================find, remove===========================");
    Entry e1 = table1.find("6");
    if(e1 != null){
      System.out.println("The item found is: [ " + e1.toString() + " ]");
    } else{
      System.out.println("The is no such item in the table to be found.");
    }
    Entry e2 = table1.remove("hell!");
    if(e2 != null){
      System.out.println("The item deleted is: [ " + e2.toString() + " ]");
    } else{
      System.out.println("The is no such item in the table to be deleted.");
    }
    System.out.println(table1);
    // output = table1.String();
    // for(String s : output){
    //   if(s != null) {
    //     System.out.println(s);
    //   }
    // }

    System.out.println("=====================makeEmpty=============================");
    table1.makeEmpty();
    System.out.println(table1);
    // output = table.String();
    // for(String s : output){
    //   if(s != null) {
    //     System.out.println(s);
    //   }
    // }
  }

}
