public class MinQueue {
  public QueueNode top = null;

  public MinQueue(){
  }

  public boolean isEmpty(){
    if (top == null) {
      return true;
    }
    return false;
  }

  public void insert(String element, int priority){
    QueueNode node = new QueueNode(element, priority);

    if (isEmpty()){
      top = node;
    } else if (goesBefore(node, top)) {
      node.next = top;
      top = node;
    } else {
      QueueNode current = top.next;
      QueueNode last = top;
      //while ((current != null) && (current.isEnd() != true)) {
      //  System.out.println(node.value + ": " + node.priority + " is less than " + current.value + ": " + current.priority);
      //}

      //while (current.isEnd() != true) {
      //  System.out.println(node.value + ": " + node.priority + " is less than " + current.value + ": " + current.priority);
      //}

      while ((current != null) && (goesBefore(node, current) == false)) {
        last = current;
        current = current.next;
      }
      if (current != null){
        System.out.println(node.value + ": " + node.priority + " is less than " + current.value + ": " + current.priority);
      } else {
        System.out.println(node.value + ": " + node.priority + " is the highest value");
      }

      last.next = node;
      node.next = current;


    }

  }

  private boolean goesBefore(QueueNode a, QueueNode b) {
    if (a.priority < b.priority) {
      return true;
    } else if (a.value.length() < b.value.length()) {
      return true;
    } else if (a.value.length() == b.value.length()) {
      if (a.value.compareTo(b.value) > 0) {
        return true;
      }
    }
    return false;
  }

  public QueueNode pop() {
    QueueNode tmp = top;
    top = tmp.next;
    return tmp;
  }

  public void print() {
    QueueNode current = top;
    while (current.next != null) {
      System.out.println(current.value + ": " + current.priority);
      current = current.next;
    }
    System.out.println(current.value + ": " + current.priority);
  }

}
