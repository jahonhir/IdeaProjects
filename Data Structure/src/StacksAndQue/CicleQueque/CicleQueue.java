package StacksAndQue.CicleQueque;


import java.util.Random;

public class CicleQueue {
    int queue[];
    int maxSize;
    int front;
    int rear;

    CicleQueue(int maxSize) {
        this.maxSize = maxSize + 1;
        front = 0;
        rear = -1;
        queue = new int[this.maxSize];
    }

    CicleQueue() {
        maxSize = 101;
        front = 0;
        rear = -1;
        queue = new int[maxSize];
    }

    public void insert(int value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queue[++rear] = value;
    }

    public int remove() {

        int value = queue[front++];

        if (front == maxSize + 1) {
            front = 0;
        }
        return value;
    }

    public int peekFront() {
        return queue[rear];
    }

    public void display() {
        for (int i = 0; i < size(); i++) {
            System.out.print(queue[(front + i) % maxSize] + " ");
        }
        System.out.println(" ");
    }

    public boolean isEmpty() {
        return (rear + 1 == front || front + maxSize - 1 == rear);
    }

    public boolean isFull() {
        return (rear + 2 == front || front + maxSize - 2 == rear);
    }

    public int size() {
        if (rear >= front) {
            return rear - front + 1;
        } else {
            return maxSize - front + rear + 1;
        }
    }


    public static void main(String[] args) {
        Random random = new Random();

        int maxSize = 10;

        CicleQueue cicleQueue = new CicleQueue(maxSize);

        for(int i = 0; i < maxSize ; i ++){
            cicleQueue.insert(random.nextInt(20)+1);
            cicleQueue.display();
        }


        for(int i = 0; i < maxSize / 2; i++){
            System.out.println(cicleQueue.remove());
            cicleQueue.display();
        }

        int i = 0;
        while(!cicleQueue.isFull()){
            i++;
            cicleQueue.insert(-1 * i);
            cicleQueue.display();
        }

    }



}
