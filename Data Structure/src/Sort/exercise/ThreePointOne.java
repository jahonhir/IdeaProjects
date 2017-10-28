package Sort.exercise;

import java.util.Random;

public class ThreePointOne {
    int[] array;
    int size;
    int nElem;

    ThreePointOne(int size){
        this.size = size;
        array = new int[size];
        nElem = 0;
    }

    public void insert(int value){
        if(nElem < size) {
            array[nElem++] = value;
        }
        else {
            System.out.println("Array is full");
        }
    }

    public void display(){
        for(int i = 0; i < nElem; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    private void swap(int firstIndex, int seconIndex){
        int toSwapValue= array[firstIndex];
        array[firstIndex] = array[seconIndex];
        array[seconIndex] = toSwapValue;
    }

    public void leftRighBubbleSort(){
        for(int i = 0; i < nElem; i++){
            for(int k = i; k < nElem - i - 1; k++){
                if(array[k + 1] < array[k]){
                    swap(k, k + 1);
                }
               if(array[nElem - k - 1] < array[nElem - k - 2]){
                    swap(nElem - k - 1 , nElem - k - 2);
                }
            }
            display();
        }

    }

    public static void main(String[] args) {
        Random random = new Random();
        int sizeOfArray = 15;
        ThreePointOne array = new ThreePointOne(sizeOfArray);

        for(int i = 0; i < sizeOfArray; i++){
            array.insert(random.nextInt(100));
        }
        array.display();
        System.out.println(" ");


        array.leftRighBubbleSort();
    }


}
