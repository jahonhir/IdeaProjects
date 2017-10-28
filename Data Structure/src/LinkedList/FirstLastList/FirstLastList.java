package LinkedList.FirstLastList;


import java.util.Random;


public class FirstLastList {

    List first;
    List last;

    FirstLastList(){
        first = null;
        last = null;
    }

    public void insertFirst(int firstValue, int secondValue){
        List inserted = new List(firstValue, secondValue);

       if(isEmpty()){
           last = inserted;
       }

        inserted.next = this.first;
        first = inserted;
    }

    public List deleteFirst(){

        List temp = first;
        first = first.next;

        if(isEmpty()){
            last = null;
        }
        return temp;
    }

    public void insertLast(int firstValue, int secondValue){
        List inserted = new List(firstValue, secondValue);
        if(isEmpty()){
            first = inserted;
        }
        else {
            last.next = inserted;
        }
        last = inserted;
    }

    public void  displayFirstLast(){
        List temp = first;
        if(first == null){
            System.out.println("List is empty");
        }
        while (temp != null ){
            temp.displayList();
            temp = temp.next;
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    private List getFirst(){
        return first;
    }

    class List{
        int firstValue;
        int secondValue;
        List next;

        List(int firstValue, int secondValue){
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        }

        public void displayList(){
            System.out.println("First value: " + firstValue + " ,Second value: " + secondValue);
        }
    }


    public static void main(String[] args) {
        Random random = new Random();
        FirstLastList list = new FirstLastList();

        for(int i = 0; i < 10; i++){
            list.insertFirst(i, random.nextInt(100));

        }

        for(int i = -1; i > -10; i--){
            list.insertLast(i, random.nextInt(100) - 100);
        }

        list.displayFirstLast();

        while (!list.isEmpty()){
            list.deleteFirst();
        }
        list.displayFirstLast();
    }
}
