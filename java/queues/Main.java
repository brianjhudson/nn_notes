package java.queues;

import java.util.ArrayList;

class Queue<T> {
  private ArrayList<T> q;
  Queue () {
    this.q = new ArrayList<T>();  
  }
  public void add (T nextItem) {
    q.add(nextItem);
  }
  public T retrieve() {
    return q.remove(0);
  }
}

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    Queue<String> q = new Queue<String>();
    q.add("Hello");
    q.add("world");
    System.out.println(q.retrieve());
    System.out.println(q.retrieve());
  }
}
