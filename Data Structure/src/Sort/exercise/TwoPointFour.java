package Sort.exercise;


import java.util.Random;

public class TwoPointFour {

    private int[] array;
    private int size;
    private int nElem;

    TwoPointFour(int size) {
        this.size = size;
        array = new int[size];
        nElem = 0;
    }

    TwoPointFour() {
        this.size = 100;
        array = new int[this.size];
        nElem = 0;
    }

    public void insert(int value) {
        if (nElem >= size) {
            System.out.println("Array is full");
        } else {
            array[nElem++] = value;
        }
    }

    public void swap(int first, int second) {
        int cur = array[first];
        array[first] = array[second];
        array[second] = cur;
    }

    public int oddEvenSort() {

        int nSwaping = 0;
        int swapingOdd;
        int swapingEven;

        do {

            swapingEven = 0;
            swapingOdd = 0;


            for (int i = 0; i < nElem - 1; i = i + 2) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1);
                    swapingOdd ++;

                }

            }

            for(int i = 1; i < nElem - 1; i = i + 2) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1);
                    swapingEven ++;

                }
            }

            nSwaping += swapingEven + swapingOdd;


        }while ( swapingEven > 0 && swapingOdd  > 0);

        return nSwaping;

    }

    public void display(){
        for(int i = 0; i < nElem; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Random random = new Random();

        int size = 1000;

        TwoPointFour array = new TwoPointFour(size);

        for(int i = 0; i < size + 1; i ++){
            array.insert(random.nextInt(100));
        }

        array.display();

        System.out.println("   ");

        int sol = array.oddEvenSort();

       array.display();

        System.out.println( sol );
    }
}
