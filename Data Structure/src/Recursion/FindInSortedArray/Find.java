package Recursion.FindInSortedArray;


import java.util.Random;

public class Find {
    int[] array;
    int size;
    int nElem;

    Find(int size){
        this.array = new int[size];
        this.size  = size;
        this.nElem = 0;
    }

    public void insert(int value){
        if(nElem == size){
            System.out.println("Array is full");
            return;
        }
        if(nElem == 0){
            array[nElem++] = value;
            return;
        }
        if(array[nElem-1] < value){
            array[nElem++]=value;
            return;
        }
        if(array[0] > value){
            paste(value, 0);
            return;
        }
        int position = 0;
        while (value > array[position] &&  position < nElem - 1){
            position++;
        }
        paste(value, position);


    }

    public void paste(int value, int position){
        for(int i = nElem; i > position; i--){
            array[i] = array[i-1];
        }

        array[position] = value;
        nElem++;
    }

    public void display(){
        for(int i = 0; i < nElem; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }

    public int recFind(int key, int lowBound, int highBound){
        int current = (highBound + lowBound)/2;
            int isIt = array[current];

        if(isIt == key){
                return current;
        }
        if(lowBound > highBound) {
            return nElem;
        }
        if(key > isIt){
            lowBound = current + 1;
        }
        else if(key < isIt){
            highBound = current - 1;
        }

        return recFind(key, lowBound, highBound);
    }

    public static void main(String[] args) {
        Find find = new Find(10);
        Random rd = new Random();

        for(int i = 0; i < 10; i++){
            find.insert(rd.nextInt(20));
        }

        find.display();
        System.out.println(find.recFind(4, 0, 9));
    }

}
