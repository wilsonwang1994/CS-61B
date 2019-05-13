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

  protected void insertAfter(int num, int r, int g, int b, DListNode node){
    if(node.next == null){
      node.next = new DListNode(num, r, g, b);
      node.next.prev = node;
      tail = node.next;
    } else{
      node.next.prev = new DListNode(num, r, g, b);
      node.next.prev.next = node.next;
      node.next.prev.prev = node;
      node.next = node.next.prev;
    }
    size++;
  }

}
