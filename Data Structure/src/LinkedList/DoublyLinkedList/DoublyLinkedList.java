package LinkedList.DoublyLinkedList;

import java.util.Random;

class ListD{
    int value;
    ListD next;
    ListD previous;

    ListD(int value){
        this.value = value;
    }

    public void displayListD(){
        System.out.print(value + " ");
    }
}



public class DoublyLinkedList {
    ListD first;
    ListD last;

    DoublyLinkedList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void displayForward(){
        ListD current = first;

        while (current != null){
            current.displayListD();
            current = current.next;
        }

        System.out.println(" ");
    }

    public void displayBackward(){
        ListD current = last;

        while (current != null){
            current.displayListD();
            current = current.previous;
        }
        System.out.println(" ");
    }

    public void insertFirst(int value){
        ListD inserted = new ListD(value);

        if(isEmpty()){
            first = inserted;
            last = inserted;
            return;
        }

        first.previous = inserted;
        inserted.next = first;
        first = inserted;
    }

    public void insertLast(int value){
        ListD inserted = new ListD(value);
        if(isEmpty()){
            insertFirst(value);
            return;
        }

        last.next = inserted;
        inserted.previous = last;
        last = inserted;

    }

    public ListD find(int key){
        ListD current = first;

        while (current != null && current.value != key){
            current = current.next;
        }

        return current;
    }

    public void insertAfter(int key, int value){
        ListD toInsert = new ListD(value);
        ListD found = find(key);
        if(found == null){
            System.out.println("Not find " + key + " to insert!");
            return;
        }

        if(found.next == null){
            insertLast(value);
            return;
        }
        else {
            toInsert.previous = found;
            toInsert.next = found.next;
            found.next.previous = toInsert;
            found.next = toInsert;
        }

    }

    public ListD deleteFirst(){
        ListD deleted = first;
        if(first.next == null){
            first = null;
            last = null;
        }
        else{
            deleted.next.previous = null;
            first = deleted.next;
        }

        return deleted;
    }

    public ListD deleteLast(){
        ListD toDelete = last;
        if(first.next == null){
            first = null;
            last = null;

        }
        else {
            last.previous.next  = null;
            last  = last.previous;
        }
        return  toDelete;
    }

    public ListD deleteKey(int key){
        ListD toDelete = find(key);
        if(toDelete == null){
            System.out.println("Not found " + key + " in LinkedList to delete");
        }
        else if(toDelete.next == null){
            deleteLast();
        }
        else  if(toDelete.previous == null){
            deleteFirst();
        } else {
            toDelete.previous.next = toDelete.next;
            toDelete.next.previous = toDelete.previous;
        }

        return toDelete;
    }

    public static void main(String[] args) {
        Random random = new Random();
        DoublyLinkedList doublyList = new DoublyLinkedList();

        for(int i = 1; i <= 5; i++){
            int a = i;
            doublyList.insertFirst(a);
            doublyList.insertLast(-a);
        }

        doublyList.displayForward();
        doublyList.insertAfter(10, 100);
        doublyList.insertAfter(-10,-100);
        doublyList.insertAfter(-100,0);
        doublyList.insertLast(1223);

        doublyList.displayForward();

        doublyList.deleteFirst();
        doublyList.deleteLast();
        doublyList.deleteKey(2);
        doublyList.deleteKey(-2);
        doublyList.deleteKey(0);
        doublyList.deleteKey(-1);
        doublyList.deleteKey(100);
        doublyList.deleteKey(-100);

        doublyList.displayBackward();
        doublyList.displayForward();

        while (!doublyList.isEmpty()){
          doublyList.deleteFirst().displayListD();
        }

        System.out.println(" ");
        doublyList.displayBackward();
    }

}
