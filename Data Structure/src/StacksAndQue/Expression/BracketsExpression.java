package StacksAndQue.Expression;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketsExpression {


    private MyStackChar stackChar;
    private char[] infix;
    private char[] postfix;
    private String output;

    BracketsExpression(String infix){
        this.infix = infix.toCharArray();
        this.postfix = new char[infix.length()];
        this.stackChar = new MyStackChar();
    }

    public  void infixTiPostfix() {
        int infSize = infix.length;
        int nPost = 0;

        for (int i = 0; i < infSize; i++) {
            char onThis = infix[i];

            if (!isSign(onThis)) {
                postfix[nPost++] = onThis;
            }
            else if (stackChar.isEmpty()) {
                stackChar.push(onThis);
            }
            else if (onThis != ')' && onThis != '(') {

                while (stackChar.nItem > 0 && quantity(stackChar.top()) >= quantity(onThis) && stackChar.top() != '(') {
                    postfix[nPost++] = stackChar.pop();
                }
                stackChar.push(onThis);
            }

            else if(onThis == '('){
                stackChar.push(onThis);
            }
            else{
                while (stackChar.top() != '('){
                    postfix[nPost++] = stackChar.pop();
                }
                stackChar.pop();
            }

        }
        while (!stackChar.isEmpty()) {
            postfix[nPost++] = stackChar.pop();
        }
    }
    public boolean isSign(char value){

            if(value == '+' || value == '-' || value == '*' || value == '/' || value == '(' || value == ')' ){
                return true;
            }
            else {
                return false;
            }
        }

    public int quantity(char value){
            switch (value){
                case '+' : return 0;

                case '-' : return 0;

                case '*':  return 1;

                case '/': return 1;

                case '(': return 2;

                case ')': return 2;

            }
            return -2;
        }

    public double countPostfix(){

        double val;
        MyStackDouble stackDouble = new MyStackDouble(100);
        int i = 0;

        while (i < postfix.length && postfix[i] != 0){
            if(isSign(postfix[i])){
                double first = stackDouble.pop();
                double second = stackDouble.pop();
                stackDouble.push(calculete(postfix[i], second , first ));
            }
            else{
                stackDouble.push(charToDouble(postfix[i]));
            }
            i++;
        }
        return stackDouble.pop();
    }

    public double calculete(char sign, double a, double b){

        switch (sign){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
        }

        System.out.println("Syntasys error!");
        return 0;
    }

    public double charToDouble(char a){
        return Character.getNumericValue(a);
    }


    public static void main(String[] args) throws  IOException{
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String in = bufferedReader.readLine();

        BracketsExpression expression = new BracketsExpression(in);

        expression.infixTiPostfix();

        System.out.println(expression.countPostfix());



    }

}
// 1+2+3*(4-5*6-7)