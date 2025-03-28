package Queues.Deque;

import java.util.LinkedList;

public class MyDeque {
    private LinkedList<String> deque;
    private final int CAPACITY = 16;

    public MyDeque() {
        this.deque = new LinkedList<>();
    }

    public void pushFront(String value) {
        if (deque.size() >= CAPACITY) {
            System.out.println("Deque full - cannot add " + value + "!");
            return;
        }
        deque.addFirst(value);
    }

    public void pushBack(String value) {
        if (deque.size() >= CAPACITY) {
            System.out.println("Deque full - cannot add " + value + "!");
            return;
        }
        deque.addLast(value);
    }

    public String popFront() {
        if (deque.isEmpty()) {
            return null;
        }
        return deque.removeFirst();
    }

    public String popBack() {
        if (deque.isEmpty()) {
            return null;
        }
        return deque.removeLast();
    }

    public String peekFront() {
        if (deque.isEmpty()) {
            return null;
        }
        return deque.getFirst();
    }

    public String peekBack() {
        if (deque.isEmpty()) {
            return null;
        }
        return deque.getLast();
    }

    public int size() {
        return deque.size();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public String toString() {
        if (deque.isEmpty()) {
            return "Empty";
        }
        return String.join(" ", deque);
    }
}