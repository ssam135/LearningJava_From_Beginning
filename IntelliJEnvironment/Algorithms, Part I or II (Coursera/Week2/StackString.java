/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

package Week2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;


//implements with linkedList.
public class StackString<String> implements Iterable<String> {
    private Node first = null;

    //inner class.
    private class Node {
        String item;
        Node next;
    }

    public Iterator<String> iterator() {
        return new ListIterator();
    }

    //ToDo : https://www.youtube.com/watch?v=bx0ebSGUKto 
    private class ListIterator implements Iterator<String> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public String next() {
            
            String st = current.item;
            current = current.next;
            return st;
        }

    }

    public boolean isEmpty() {
        return first == null;
    }


    public String pop() {

        String item = first.item;
        first = first.next;
        return item;

    }

    public void push(String new_item) {

        Node oldFirst = first;
        first = new Node();
        first.item = new_item;
        first.next = oldFirst;


    }

    public void printLinkedList() {

        while (first.next != null) {
            System.out.print(first.item);
            first = first.next;
        }
    }

    public static void main(String[] args) {

        //clinet codes

        StackString stack = new StackString();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-"))
                StdOut.print(stack.pop());
            else
                stack.push(s);
        }


    }

}
