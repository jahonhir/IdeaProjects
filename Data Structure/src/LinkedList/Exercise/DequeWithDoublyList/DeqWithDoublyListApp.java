package LinkedList.Exercise.DequeWithDoublyList;


import java.util.Random;

class Link {
    Link next;
    Link previous;
    int data;

    Link(int value){
        data = value;
    }

    public void displayList(){
        System.out.print(data + " ");
    }
}

class DoublyLinkedList{
    Link first;
    Link last;

    DoublyLinkedList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int value){
        Link toInsert = new Link(value);
        if(isEmpty()){
            first = toInsert;
            last = toInsert;

        }
        else {
            first.previous = toInsert;
            toInsert.next = first;
            first = toInsert;
        }
    }

    public void insertLast(int value){
        Link toInsert = new Link(value);
        if(isEmpty()){
            first = toInsert;
            last = toInsert;
        }
        else {
            toInsert.previous = last;
            last.next = toInsert;
            last = toInsert;
        }
    }

    public Link deleteFirst(){
        Link toDelete = first;
        if(first.next == null){
            first = null;
            last = null;
        }
        else {
            first = first.next;
            first.previous = null;
        }
        return toDelete;
    }

    public Link deleteLast(){
       Link toDelete = last;
        if(first.next == null){
            first = null;
            last = null;
        }
        else{
            last = last.previous;
            last.next = null;
        }
        return toDelete;
    }

    public void displayForward(){
        Link current = first;
        if(first == null){
            System.out.println("List is empty");
        }
        while (current != null){
            current.displayList();
            current = current.next;
        }
        System.out.println("");
    }

    public void displayBackwart(){
        Link current = last;
        if(first == null){
            System.out.println("List is empty");
        }
        while (current != null){
            current.displayList();
            current = current.previous;
        }
        System.out.println("");
    }

}

class Deque{
    DoublyLinkedList deque;

    Deque(){
        deque = new DoublyLinkedList();
    }

    public void insertLeft(int value){
        deque.insertFirst(value);
    }

    public void insertRight(int value){
        deque.insertLast(value);
    }

    public int removeLeft(){
        return deque.deleteFirst().data;
    }

    public int removeRIGHT(){
        return deque.deleteLast().data;
    }

    public boolean isEmpty(){
        return deque.isEmpty();
    }

    public void showDeque(){
        deque.displayForward();
    }



}

public class DeqWithDoublyListApp {
    public static void main(String[] args) {
        Random random = new Random();
        Deque deque = new Deque();


        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(20);
            System.out.println("Inserted left: " + x);
            deque.insertLeft(x);

            System.out.println("Inserted right: -" + x);
            deque.insertRight(-x);
        }
        deque.showDeque();
    }
}
