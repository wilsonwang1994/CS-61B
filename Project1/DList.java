public class DList{
  protected DListNode head;
  protected DListNode tail;
  protected long size;

  public DList(){
    head = new DListNode(-1, -1, -1, -1);
    tail = null;
    size = 0;
  }

  public void insertEnd(int num, int red, int green, int blue){
    if(size==0){
      head.next = new DListNode(num, red, green, blue);
      head.prev = head.next;
      head.next.next = head;
      head.next.prev = head;
    } else{
      head.prev.next = new DListNode(num, red, green, blue);
      head.prev.next.prev = head.prev;
      head.prev.next.next = head;
      head.prev = head.prev.next;
    }
    size++;
  }

  protected void insertAfter(int num, int r, int g, int b, DListNode node){
    node.next.prev = new DListNode(num, r, g, b);
    node.next.prev.prev = node;
    node.next.prev.next = node.next;
    node.next = node.next.prev;
    size++;
  }

  protected void insertBefore(int num, int r, int g, int b, DListNode node){
    node.prev.next = new DListNode(num, r, g, b);
    node.prev.next.next = node;
    node.prev.next.prev = node.prev;
    node.prev = node.prev.next;
    size++;
  }

  protected void remove(DListNode node){
    node.prev.next = node.next;
    node.next.prev = node.prev;
    size--;
  }

  public DListNode front(){
    return head.next;
  }

}
