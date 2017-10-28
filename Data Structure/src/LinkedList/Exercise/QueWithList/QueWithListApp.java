package LinkedList.Exercise.QueWithList;


import java.util.Random;

class List{
    int data;
    List next;

    List(int a){
        this.data = a;
    }

    public void displayList(){
        System.out.print(data + " ");
    }
}

class  LinkedList{

    List first;

    public void insert(int a) {
        List toInsert = new List(a);
        List current = first;
        List previous = null;

            while (current !=  null && toInsert.data >= current.data) {
                previous = current;
                current = current.next;
            }

            if (previous == null) {
                toInsert.next = first;
                first = toInsert;
            }
            else {
                toInsert.next = current;
                previous.next = toInsert;
            }
    }


    public List deleteFirst(){
        List toDelete = first;
        if(first.next == null){
            first = null;
        }
        else{
            first = first.next;
        }
        return toDelete;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void displayLinkedList(){
        List current = first;
        while (current != null){
            current.displayList();
            current = current.next;
        }
        System.out.println(" ");
    }

}

class PreorityDeq{
    int nElem;
    LinkedList preorityDeq;
    PreorityDeq(){
        preorityDeq = new LinkedList();
        nElem = 0;
    }

    public void insert(int a){
        nElem ++;
        preorityDeq.insert(a);
    }

    public List delete(){
        if(0 == nElem --){
            System.out.println("List is empty");
            return null;
        }
        return preorityDeq.deleteFirst();
    }

    public int size(){
        return nElem;
    }

    public void showPreorityDeq(){
        preorityDeq.displayLinkedList();
    }
}

public class QueWithListApp {

    public static void main(String[] args) {
        PreorityDeq deq = new PreorityDeq();
        Random random = new Random();

        for(int i = 0; i< 10; i++){
            deq.insert(random.nextInt(20));
        }

        deq.showPreorityDeq();

        for(int i = 0; i < 11; i++){
            System.out.print(deq.delete().data + " ");
        }



    }

}
