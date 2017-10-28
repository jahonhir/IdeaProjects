package Recursion.MergeSort;


public class MergeSortApp {
    int array[];
    int nElem;
    int size;

    MergeSortApp(int size){
        this.size = size;
        nElem = 0;
        array = new int[size];
    }

    public void insert(int value){
        if(nElem == size){
            System.out.println("Array is full");
        }
        else {
            array[nElem++] = value;
        }
    }

    public void display(){
        for(int i = 0; i < nElem; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }

    public int[] merge(int[] a, int[] b) {
        int sizeA = a.length;
        int sizeB = b.length;
        int sizeC = sizeA + sizeB;
        int[] c = new int[sizeC];
        int currentA = 0;
        int currentB = 0;

        for (int i = 0; i < sizeC; i++) {
            if (currentA >= sizeA) {
                c[i] = b[currentB++];
            } else if (currentB >= sizeB) {
                c[i] = a[currentA++];
            } else if (a[currentA] < b[currentB]) {
                c[i] = a[currentA++];
            } else {
                c[i] = b[currentB++];
            }
        }
        return c;
    }

    public int[] fromIndexToArray(int lowIndex, int highIndex){
        int newSize = highIndex - lowIndex + 1;
        int[] ret = new int[newSize];
        for(int i = 0; i < newSize; i++){
            ret[i] = array[lowIndex + i];
        }
        return ret;
    }

    public int[] mergeSort(int lowIndexA, int highIndexA,
                          int lowIndexB, int highIndexB){
        if(lowIndexA == highIndexA && lowIndexB == highIndexB){
            return merge(fromIndexToArray(lowIndexA, highIndexA), fromIndexToArray(lowIndexB, highIndexB));
        }

            return merge(
                    mergeSort(lowIndexA, (lowIndexA + highIndexA) / 2,(lowIndexA + highIndexA) / 2 + 1, highIndexA),
                    mergeSort(lowIndexB, (lowIndexB + highIndexB) / 2,(lowIndexB + highIndexB) / 2 + 1, highIndexB));

    }

    public static void main(String[] args) {
        MergeSortApp m = new MergeSortApp(10);
        for(int i = 0; i < 10; i++){
           m.insert(i);
        }

        m.display();


        int[] sol = m.mergeSort(0, 5, 6, 9);

        for(int i = 0; i < sol.length; i++){
            System.out.println(sol[i]);
        }

    }

}

