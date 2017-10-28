package Array.orderedArray;

import java.util.Random;

public class OrderedArray {

    private int[] array;
    private int size;
    private int nElem;

    OrderedArray(int size) {
        this.size = size;
        array = new int[size];
        nElem = 0;
    }

    OrderedArray() {
        size = 100;
        array = new int[size];
        nElem = 0;
    }


    public int findPlace(int value) {
        int lowBound = 0;
        int highBound = nElem - 1;
        int current = 0;

        if(nElem == 0 ){
            return 0;
        }
        else if(value >= array[nElem-1] ){
            return  nElem;
        }
        else if(value <= array[0]){
            return  0;
        }
        else {
            while (highBound - lowBound > 1) {
                current = (lowBound + highBound) / 2;
                if (array[current] > value) {
                    highBound = current;
                }
                 else if (array[current] < value) {
                    lowBound = current;
                } else if (array[current] == value) {

                    break;
                }
            }

            if(array[current] < value){
                current ++;
            }
            return current;
        }
   }


    public boolean insert(int value) {
        if (nElem == size) {
            System.out.println("Array is full");
            return false;
        } else {
            int index = findPlace(value+1);

            for (int i = nElem; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = value;
            nElem++;

      //      System.out.println(value + " was added");

            return true;
        }
    }


    public boolean delete(int value) {

        int index = nElem;
        for(int k = 0; k< nElem; k++){
            if(value == array[k]){
                index = k;
            }

        }

        if(index == nElem){
            System.out.println("value was not found");
            return false;
        }

            for (int i = index; i < nElem - 1; i++) {
                array[i] = array[i + 1];
            }
            nElem--;
            System.out.println(value + " was deleted");
            return true;
        }



    public void display(){
        for(int i = 0; i < nElem; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public int getFromIndex(int index){
         return array[index];
    }


    public static void main(String[] args) {
        Random rnd = new Random(System.currentTimeMillis());

        int numberforProverka = 10;
         rnd.nextInt(5);
        OrderedArray array = new OrderedArray(9);
        for(int i = 1; i <= numberforProverka; i++){

            array.insert(i);
        }

        for(int i = 1; i <= numberforProverka; i++){
            array.delete(i);
            array.display();
        }


    }

}
