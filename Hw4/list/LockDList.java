/* LockDList.java */

package list;


public class LockDList extends DList{

  public LockDList() {
    //  Your solution here.
    head = new LockDListNode(null, null, null);
    head.next = head;
    head.prev = head;
    size = 0;
  }
  protected DListNode newNode(Object item, DListNode prev, DListNode next) {
    return (DListNode)(new LockDListNode(item, prev, next));
  }

  public void lockNode(DListNode node){
    ((LockDListNode)node).locked = true;
  }

  public void remove(DListNode node) {
    // Your solution here.
    if(((LockDListNode)node).locked != false){
      super.remove(node);
    }
  }
}
