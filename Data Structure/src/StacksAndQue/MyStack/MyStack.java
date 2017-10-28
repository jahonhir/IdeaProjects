package StacksAndQue.MyStack;

public class MyStack {
    int[] stack;
    int nElem;
    int size;

    MyStack(int size){
        this.size = size;
        this.nElem = 0;
        this.stack = new int[size];
    }

    MyStack(){
        this.size = 100;
        this.nElem = 0;
        this.stack = new int[size];
    }

    public void push(int value){
        stack[nElem++] = value;
    }

    public int pop(){
        return stack[--nElem];
    }

    public int top(){
        return stack[nElem - 1];
    }

    public boolean isEmpty(){
        return nElem == 0;
    }

    public boolean isFuul(){
        return nElem == size;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();


        for(int i = 0; i < 20; i++){
            stack.push(i);
        }

        for(int i = 0; i < 20; i++){
            System.out.print(stack.pop() + " ");
        }
    }

}
