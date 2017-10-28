package Array.Exercise;

import java.util.Random;

public class TwoPointThree {

    private int [] array;
    private int nElements;
    private int size;

    TwoPointThree(int size){
        this.size  = size;
        array = new int[size];
        nElements = 0;
    }

    TwoPointThree(){
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

    public int removeMax(){
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

            deleteFirst(max);
            return max;
        }
    }



    public static void main(String[] args) {
        Random rnd = new Random(System.currentTimeMillis());

        int size = 15;

        TwoPointThree array = new TwoPointThree(size);
        TwoPointThree sortedArray = new TwoPointThree(size);
        for(int i = 1; i <= size; i++){
            array.insert(rnd.nextInt(100));
        }

        array.display();

        for(int i = 0; i < size; i++){
            sortedArray.insert(array.removeMax());
        }

        sortedArray.display();

    }
}
