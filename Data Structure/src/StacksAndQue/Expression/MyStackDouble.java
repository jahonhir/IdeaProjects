package StacksAndQue.Expression;


class MyStackDouble {
    double[] stack;
    int nElem;
    int size;

    MyStackDouble(int size){
        this.size = size;
        this.nElem = 0;
        this.stack = new double[size];
    }

    MyStackDouble(){
        this.size = 100;
        this.nElem = 0;
        this.stack = new double[size];
    }

    public void push(double value){
        stack[nElem++] = value;
    }

    public double pop(){
        return stack[--nElem];
    }

    public double top(){
        return stack[nElem - 1];
    }

    public boolean isEmpty(){
        return nElem == 0;
    }

    public boolean isFull(){
        return nElem == size;
    }
}