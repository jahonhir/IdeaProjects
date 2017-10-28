package StacksAndQue.Deque;


import java.util.Random;

public class Deque {

    private int[] deque;
    int rear;
    int front;
    int nElem;
    int size;

    Deque(int size){
        this.size = size;
        this.deque = new int[this.size];
        this.rear = size / 2 ;
        this.front = this.rear + 1;
    }

    Deque(){
        this.size = 100;
        this.deque = new int[this.size];
        this.rear = this.size / 2;
        this.front = this.rear + 1;
    }


    public void insertLeft(int value){
        if(front == 0){
            front = size;
        }
        deque[--front] = value;
        nElem ++;

    }

    public void insertRight(int value){
        if(rear == size - 1){
            rear = -1;
        }
        deque[++rear] = value;
        nElem ++;
    }

    public int removeLeft(){
        if(front == size){
            front = 0;
        }
        nElem --;
        return deque[front ++];
    }

    public int removeRight(){
        if(rear == -1){
            rear = size - 1;
        }
        nElem --;
        return deque[rear --];
    }

    public boolean isFull(){
        return nElem == size;
    }

    public boolean isEmpty(){
        return nElem == 0;
    }

    public void display(){
        for(int i = 0; i < nElem; i++ ){
            System.out.print(deque[(front + i) % size] + " ");
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        Deque deque = new Deque(20);
        Random random = new Random();

        while (!deque.isFull()){
            deque.insertLeft(random.nextInt(100));
        }

        deque.display();

        while (!deque.isEmpty()){
            System.out.print(deque.removeRight() + " ");
        }


    }


}
