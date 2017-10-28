package Sort.bubbleSort;

import java.util.Random;

public class BubbleSort {
    private int[] array;
    private int nElements;
    private int size;

    BubbleSort(int size) {
        this.size = size;
        array = new int[size];
        nElements = 0;
    }

    BubbleSort() {
        this.size = 100;
        array = new int[size];
        nElements = 0;
    }

    public int findFirst(int value) {  // возвращает индекс первого вхождения числа value
        int j;

        for (j = 0; j < nElements; j++) {
            if (array[j] == value)
                break;
        }

        if (j == nElements) {
            return -1;
        } else {
            return j;
        }
    }

    public boolean insert(int value) {
        if (nElements < size) {
            array[nElements++] = value;
            return true;
        } else {
            System.out.println("Array is full");
            return false;
        }
    }

    public boolean deleteFirst(int value) {
        int index = findFirst(value);

        if (index != (nElements) && index != -1) {
            for (int i = index; i < nElements - 1; i++) {
                array[i] = array[i + 1];
            }
            nElements--;
            return true;
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < nElements; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }

    public void bubbleSort(){

        for(int i = 0; i < nElements; i++ ){
            for(int k = 0; k < nElements - i - 1; k++){
                if(array[k] > array[k+1]){
                    swap(k, k+1);
                }

                display();
            }
        }

    }

    public void swap(int firstIndex, int secondIndex ){
        int h = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = h;

    }

    public static void main(String[] args) {

        Random rnd = new Random(System.currentTimeMillis());

        int size = 15;

        BubbleSort array = new   BubbleSort (size);
        for(int i = 1; i <= size; i++){
            array.insert(rnd.nextInt(100));
        }



        array.bubbleSort();

    }

}


