package LinkedList.Exercise.CicleLinkedList;


class Link{
    Link next;
    int data;

    Link(int value){
        data = value;
    }

    public void displayList(){
        System.out.print(data + " ");
    }
}

class CicleLinkedList{
    Link current;

    CicleLinkedList(){
        current = null;
    }

    public void insert(int a){
        Link toInsert = new Link(a);

        if(current == null){
            current = toInsert;
            toInsert.next = toInsert;
        }
        else {
            toInsert.next = current.next;
            current.next = toInsert;
            current = toInsert;
        }
    }

    public void step(){
        current = current.next;
    }

    public boolean isEmpty(){
        return current == null;
    }

    public Link delete(){
        Link toDelete = current.next;

        if(current == current.next){
            current = null;
        }
        else {
            current.next = toDelete.next;
        }

        return toDelete;
    }

    public Link find(int value){
        Link founded = null;
        if(current != null){
            Link now = current.next;
            while (now != current && now.data == value) {
               now = now.next;
            }
            if(now.data == value){
                founded = now;
            }
        }
        return founded;
    }

    public void displayCicleList(){
        if(current == null){
            System.out.println("Cicle is empty!");
        }
        else {
            Link now = current.next;
            current.displayList();
            while (now != current){
                now.displayList();
                now = now.next;
            }
            System.out.println("");
        }
    }

    public void showCurrent(){
        current.displayList();
        System.out.println("");
    }
}





public class CicleLinkedListApp {
    public static void main(String[] args) {
        CicleLinkedList cicle = new CicleLinkedList();

        for(int i = 0; i < 10; i++){
            cicle.insert(i);
        }

        cicle.showCurrent();
        cicle.displayCicleList();

        cicle.delete();

        cicle.displayCicleList();

        cicle.step();
        cicle.step();

        cicle.delete();

        cicle.displayCicleList();
    }
}
