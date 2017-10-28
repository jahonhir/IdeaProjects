package LinkedList.ListWithIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LinkedListWithIterator {

    List first;

    LinkedListWithIterator() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int value) {
        List toInsert = new List(value);
        toInsert.next = first;
    }

    public void displayLinkedList() {
        List current = first;

        while (current != null) {
            current.displayList();
            current = current.next;
        }
        System.out.println(" ");
    }

    public List getFirst() {
        return first;
    }

    public void setFirst(List first) {
        this.first = first;
    }

    public ListIterator getIterator() {
        return new ListIterator(this);
    }
}

    class List {
        int data;
        List next;

        List(int value) {
            this.data = value;
        }

        public void displayList() {
            System.out.print(data + " ");
        }
    }

    class ListIterator {
        List previous;
        List current;
        LinkedListWithIterator ourList;

        ListIterator(LinkedListWithIterator ourList) {
            this.ourList = ourList;
            this.current = ourList.getFirst();
        }

        public void reset() {
            current = ourList.getFirst();
            previous = null;
        }

        public void next() {
            previous = current;
            current = current.next;
        }

        public List getCurrent() {
            return current;
        }

        public boolean atEnd() {
            return current.next == null;
        }

        public void insertAfter(int value) {
            List toInsert = new List(value);
            if (ourList.isEmpty()) {
                ourList.setFirst(toInsert);
               reset();
            }
            else if(current.next == null) {
                current.next = toInsert;
            }
            else {
                toInsert = current.next;
                current.next = toInsert;
                next();
            }
        }

        public void insertBefore(int value) {

            List toInsert = new List(value);

            if (previous == null) {
                toInsert.next = current;
                ourList.setFirst(toInsert);
                reset();
            } else {
                previous.next = toInsert;
                toInsert.next = current;
                current = toInsert;
            }
        }

        public int deleteCurrent() {

            int value = current.data;

            previous.next = current.next;

            if (atEnd()) {
                reset();
            }
            current = current.next;

            return value;
        }

    }


    class IteratorApp  {

        public static void main(String[] args) throws IOException {
            LinkedListWithIterator list = new LinkedListWithIterator();
            ListIterator iterator = list.getIterator();

            char in;
            int value;

            iterator.insertAfter(20);
            iterator.insertAfter(10);
            iterator.insertAfter(5);
            iterator.next();
            iterator.insertBefore(-1);

            while (true) {
                System.out.flush();
                in = getChar();

                switch (in){
                    case 's':
                        if(list.isEmpty()){
                            System.out.println("List is empty");
                        }
                        else {
                            list.displayLinkedList();
                        }
                        break;

                    case 'r':
                        iterator.reset();
                        break;

                    case 'n':
                        iterator.next();
                        break;

                    case 'g':
                        iterator.getCurrent().displayList();
                        break;

                    case 'b':
                        value = getInt();
                        iterator.insertBefore(value);
                        break;

                    case 'a':
                        value = getInt();
                        iterator.insertAfter(value);
                        break;

                    case 'd':
                        iterator.deleteCurrent();
                        break;
                }

            }

        }

        public static String getString() throws IOException {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            return br.readLine();
        }

        public static char getChar() throws IOException {
            return getString().charAt(0);
        }

        public static int getInt() throws IOException{
            return Integer.parseInt(getString());
        }

    }


