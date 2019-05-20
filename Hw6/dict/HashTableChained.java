/* HashTableChained.java */

package dict;
import list.*;
/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
   List[] hashTable;
   int numOfEntries = 0;
   int numOfBuckets;


  /**
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

  public HashTableChained(int sizeEstimate) {
    // Your solution here.
    numOfBuckets = (int)(sizeEstimate/0.8);
    boolean isPrime = false;
    while(!isPrime){
      isPrime = true;
      for(int i=2; i<numOfBuckets; i++){
        if(numOfBuckets%i == 0){
          isPrime = false;
          break;
        }
      }
      if(isPrime == true){
        break;
      }
      numOfBuckets++;
    }
    hashTable = new List[numOfBuckets];
    for(int i=0; i<numOfBuckets; i++){
      hashTable[i] = new SList();
    }
  }

  /**
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
    // Your solution here.
    numOfBuckets = 101;
    hashTable = new List[numOfBuckets];
    for(int i=0; i<numOfBuckets; i++){
      hashTable[i] = new SList();
    }
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
    // Replace the following line with your solution.
    code = (233333 * code + 23333333) % 16908799;
    if (code < 0) {
      code = (code + 16908799)  % 16908799;
    }
    return code % numOfBuckets;
  }

  /**
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  public int size() {
    // Replace the following line with your solution.
    return numOfEntries;
  }

  /**
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  public boolean isEmpty() {
    // Replace the following line with your solution.
    return (numOfEntries == 0);
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  public Entry insert(Object key, Object value) {
    // Replace the following line with your solution.
    int bucket = compFunction(key.hashCode());
    Entry result = new Entry();
    result.key = key;
    result.value = value;
    hashTable[bucket].insertBack(result);
    numOfEntries++;
    return result;
  }

  /**
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  public Entry find(Object key) {
    // Replace the following line with your solution.
    int bucket = compFunction(key.hashCode());
    ListNode curNode = hashTable[bucket].front();
    Entry result = null;
    while(curNode.isValidNode()){
      try{
        if(((Entry)(curNode.item())).key().equals(key)){
          result = (Entry)(curNode.item());
          break;
        }
        curNode = curNode.next();
      } catch(InvalidNodeException e) {
        System.err.println("Find: " + e);
      }
    }
    return result;
  }

  /**
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  public Entry remove(Object key) {
    // Replace the following line with your solution.
    int bucket = compFunction(key.hashCode());
    ListNode curNode = hashTable[bucket].front();
    Entry result = null;
    while(curNode.isValidNode()){
      try{
        if(((Entry)(curNode.item())).key().equals(key)){
          result = (Entry)(curNode.item());
          curNode.remove();
          numOfEntries--;
          break;
        }
        curNode = curNode.next();
      } catch(InvalidNodeException e) {
        System.err.println("Remove: " + e);
      }
    }
    return result;
  }

  /**
   *  Remove all entries from the dictionary.
   */
  public void makeEmpty() {
    // Your solution here.
    hashTable = new SList[numOfBuckets];
    for (int i = 0; i < numOfBuckets; i++) {
      hashTable[i] = new SList();
    }
    numOfEntries = 0;
  }

  public String toString(){
    String result = "";
    for(int i=0; i<numOfBuckets; i++){
      ListNode curNode = hashTable[i].front();
      if(hashTable[i].length() == 0){
        continue;
      }
      try{
      result = result + i + " ------->[ ";
      while(curNode.isValidNode()){
        result = result + "(" +
                 ((Entry)(curNode.item())).key() +
                 " , " +
                 ((Entry)(curNode.item())).value() + ") ";
        curNode = curNode.next();
      }
      result = result + " ]\n";

      } catch(InvalidNodeException e) {
        System.err.println("Remove: " + e);
      }

    }
    return result;
  }


  public String[] String() {
    String[] res = new String[numOfBuckets / 10 + 1];
    String s = "";
    int index = 0;
    for (int i = 0; i < numOfBuckets; i++) {
      if (i % 10 == 0) {
        res[index] = s;
        index++;
        s = "";
      }
      s += "[" + Integer.toString(hashTable[i].length())+ "]";
    }
    return res;
  }

}
