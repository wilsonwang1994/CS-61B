public class DList{
  protected DListNode head;
  protected DListNode tail;
  protected long size;

  public DList(){
    head = null;
    tail = null;
    size = 0;
  }

  public void insertEnd(int num, int red, int green, int blue){
    if(size==0){
      head = new DListNode(num, red, green, blue);
      tail = head;
    } else{
      tail.next = new DListNode(num, red, green, blue);
      tail.next.prev = tail;
      tail = tail.next;
    }
    size++;
  }
}
