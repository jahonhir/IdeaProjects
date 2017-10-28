package LinkedList.SortedList;


import java.util.Random;

    class List{
    int value;
    List next;

    List(int value){
        this.value = value;
    }

    public void displayList(){
        System.out.print(value + " ");
    }
}

class LinkedSortedList{
    List first;

    LinkedSortedList(){
        first = null;
    }

    public List deleteFirst(){
        List temp = first;
        first = first.next;
        return temp;
    }

    public void displayLinkedSortedList(){
        List temp = first;
        if(isEmpty()){
            System.out.println("SortedList if empty");
            return;
        }
        while (temp != null){
            temp.displayList();
            temp = temp.next;
        }
        System.out.println(" ");
    }

    public boolean isEmpty(){
        return first == null;
    }


    public void insert(int value) {

        List previous = null;
        List current = first;
        List inserted = new List(value);

        while (current != null && current.value < inserted.value) {
            previous = current;
            current = current.next;

        }

        if (previous == null) {
            inserted.next = first;
            first = inserted;
        }
        else {
            previous.next = inserted;
            inserted.next = current;
        }

    }

}


    public class SortedList{

        public static void main(String[] args) {
            Random random = new Random();
            LinkedSortedList sortedList = new LinkedSortedList();

            for(int i = 0; i < 15; i++){
                int toInsert = random.nextInt(10);
                sortedList.insert(toInsert);
                System.out.print(toInsert + " ");
            }
            System.out.println(" ");

            sortedList.displayLinkedSortedList();

            sortedList.deleteFirst();
            sortedList.deleteFirst();
            sortedList.displayLinkedSortedList();
        }

    }






