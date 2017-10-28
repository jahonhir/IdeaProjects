package Array.Exercise;

public class TwoPointOne {

    private int [] array;
    private int nElements;
    private int size;

    TwoPointOne(int size){
        this.size  = size;
        array = new int[size];
        nElements = 0;
    }

    TwoPointOne(){
        this.size  = 100;
        array = new int[size];
        nElements = 0;
    }

    public int findFirst(int value){  // возвращает индекс первого вхождения числа value
        int j;

        for( j = 0; j < nElements; j++){
            if(array[j] == value)
                break;
        }

        if(j == nElements){
            return -1;
        }
        else {
            return j;
        }
    }

    public boolean insert(int value){
        if(nElements < size){
            array[nElements++] = value;
            return true;
        }
        else {
            System.out.println("Array is full");
            return false;
        }
    }

    public boolean deleteFirst(int value){
        int index = findFirst(value);

        if( index != (nElements) && index != -1 ){
            for(int i = index; i < nElements - 1; i++ ){
                array[i] = array[i+1];
            }
            nElements--;
            return true;
        }
        return false;
    }

    public void display(){
        for(int i = 0; i< nElements; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }

    public int getMax(){
        if(nElements < 1){
            return -1;
        }
        else {
            int max = array[0];
            int isMax;

            for(int i = 1; i < nElements; i++){
                isMax = array[i];
                if(isMax > max){
                    max = isMax;
                }
            }
            return max;
        }
    }



    public static void main(String[] args) {
        TwoPointOne array = new TwoPointOne(10);
        for(int i = 1; i <= 12; i++){
            array.insert(i);
        }


        array.display();
        System.out.println(array.deleteFirst(1));
        array.display();
        System.out.println(array.deleteFirst(2));
        array.display();
        System.out.println(array.deleteFirst(0));
        array.display();

    }
}
