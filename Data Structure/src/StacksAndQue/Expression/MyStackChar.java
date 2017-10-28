package StacksAndQue.Expression;


public class MyStackChar {

        char[] myStackX;
        int size;
        int nItem;

        MyStackChar(int size){
            this.size = size;
            this.nItem = 0;
            this.myStackX = new char[this.size];
        }

        MyStackChar(){
            this.size = 100;
            this.nItem = 0;
            this.myStackX = new char[this.size];
        }

        public void push(char value){
            myStackX[nItem ++] = value;
        }

        public boolean isEmpty(){
            return nItem == 0;
        }

        public boolean isFull(){
            return nItem == size;
        }

        public char pop(){
            return myStackX[--nItem];
        }

        public void display(){
            System.out.println("bottom -> top: ");
            for(int i = 0; i < nItem; i++){
                System.out.print(myStackX[i] + " ");
            }
        }

        public  char top(){
            return myStackX[nItem - 1];
        }
}

