package LinkedList.SimpleLinkedList;


public class LinkedList {

    Link first;

    LinkedList(){
        this.first = null;
    }

    public void insertFirst(String name, String lastName){
        Link newFirst = new Link(name, lastName);
        newFirst.next = first;
        this.first = newFirst;
    }

    public Link deleteFirst(){
        Link temp = this.first;
        this.first = this.first.next;
        return temp;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void displayLinkedList(){
        Link temp = this.first;

        while (temp != null){
            temp.displayLink();
            temp = temp.next;
        }

    }


    public Link findByLastName(String lastName){
        Link temp = first;

        while(temp != null){
            if(temp.lastName.compareTo(lastName) == 0){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    public Link deleteByLastName(String lastName){
        Link current = first;
        Link previous = null;
        Link temp = null;
        while (current != null){
            if(current.lastName.compareTo(lastName) == 0){
                temp = current;
                previous.next = current.next;
                break;
            }
            previous = current;
            current = current.next;
        }
        return temp;
    }

    class Link{
        String firstName;
        String lastName;
        Link next;

        Link(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public void displayLink() {
            System.out.println("Name: " + firstName + " Lastname: " + lastName);
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertFirst("jaha", "rus");
        linkedList.insertFirst("jaha", "isa");
        linkedList.insertFirst("jaha", "sad");
        linkedList.insertFirst("jaha", "mat");

        Link deleted = linkedList.deleteByLastName("sad");


        if(deleted != null) {
            deleted.displayLink();
        }
        else {
            System.out.println("Not delete");
        }

        System.out.println("");
        linkedList.displayLinkedList();

    }

}
