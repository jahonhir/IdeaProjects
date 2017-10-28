package Sort.selectionSort;

import java.util.Random;

public class SelectionSort {
    private int[] array;
    private int nElements;
    private int size;

    SelectionSort(int size) {
        this.size = size;
        array = new int[size];
        nElements = 0;
    }

    SelectionSort() {
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

    public void selectionSort(){

        for(int i = 0; i < nElements; i++ ){
            int min = array[i];
            int indexMin = i;

            for(int k = i+1; k < nElements; k++){
                if(min > array[k]){
                    min = array[k];
                    indexMin = k;
                }
            }

            swap(i, indexMin);

            display();
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

        SelectionSort array = new SelectionSort(size);
        for(int i = 1; i <= size; i++){
            array.insert(rnd.nextInt(100));
        }




        array.selectionSort();



    }

}


