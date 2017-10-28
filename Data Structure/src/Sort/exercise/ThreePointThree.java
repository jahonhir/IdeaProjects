package Sort.exercise;

import java.util.Random;

public class ThreePointThree {
    private int[] array;
    private int nElements;
    private int size;

    ThreePointThree(int size) {
        this.size = size;
        array = new int[size];
        nElements = 0;
    }

    ThreePointThree() {
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

    public void insertionSort(){

        int temp;
        int index;

        for(int i = 1; i < nElements; i++ ){
            temp = array[i];
            index = i;

            while (index > 0 && temp < array[index-1]){
                array[index] = array[--index];
            }

            array[index] = temp;

           // display();
        }


    }

    public void noDoups(){
        for(int i = 0; i < nElements; i++){
            int dups = 1;
            int value = array[i];

            while(i + dups < nElements && value == array[i+dups]) {
                dups ++;
            }

                if (dups > 1) {
                    for (int k = i + 1; k < nElements - dups + 1; k++) {
                        array[k] = array[k + dups - 1];

                    }

                    nElements = nElements - dups + 1;
                }
                display();
        }
    }



    public static void main(String[] args) {

        Random rnd = new Random(System.currentTimeMillis());

        int size = 100;

        ThreePointThree array = new ThreePointThree(3*size);
        for(int i = 1; i <= size; i++){
            int a = rnd.nextInt(10);
            array.insert(a);
            array.insert(a);
            array.insert(a);
        }


        array.display();
        System.out.println("  ");

        array.insertionSort();

        array.display();
        System.out.println(" ");

        array.noDoups();
    }

}


