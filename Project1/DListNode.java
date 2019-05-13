public class DListNode{
  public int[][] item = new int[2][];
  public DListNode prev;
  public DListNode next;

  DListNode(int num, int red, int green, int blue){
    item[0] = new int[]{num};
    item[1] = new int[]{red, green, blue};
    prev = null;
    next = null;
  }

  protected DListNode next(){
    return next;
  }

  protected DListNode prev(){
    return prev;
  }

}
