package StacksAndQue.Expression;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketsExpressionFinal {


    private MyStackChar stackChar;
    private char[] infix;
    private String output = " ";

    BracketsExpressionFinal(String infix) {
        infix = infix + ' ';
        this.infix = infix.toCharArray();
        this.stackChar = new MyStackChar();
    }

    public void infixTiPostfix() {

        int infSize = infix.length;

        for (int i = 0; i < infSize; i++) {
            char onThis = infix[i];


            while (i < infSize - 1 && !isSign(onThis)) {
                output = output + onThis;
                onThis = infix[++i];

            }

            output = output + " ";

            if (isSign(onThis)) {

                if (stackChar.isEmpty()) {
                    stackChar.push(onThis);
                } else if (onThis != ')' && onThis != '(') {
                    while (stackChar.nItem > 0 && quantity(stackChar.top()) >= quantity(onThis) && stackChar.top() != '(') {
                        output = output + stackChar.pop() + " ";
                    }
                    stackChar.push(onThis);
                } else if (onThis == '(') {
                    stackChar.push(onThis);
                } else {
                    while (stackChar.top() != '(') {
                        output = output + stackChar.pop() + " ";
                    }
                    stackChar.pop();
                }

            }

        }
        while (!stackChar.isEmpty()) {
            output = output + stackChar.pop() + " ";
        }
    }

    public boolean isSign(char value) {

        if (value == '+' || value == '-' || value == '*' || value == '/' || value == '(' || value == ')') {
            return true;
        } else {
            return false;
        }
    }

    public boolean isStringSign(String value) {
        if (value.compareTo("+") == 0 || value.compareTo("-") == 0 || value.compareTo("*") == 0 || value.compareTo("/") == 0) {
            return true;
        } else {
            return false;
        }
    }


    public int quantity(char value) {
        switch (value) {
            case '+':
                return 0;

            case '-':
                return 0;

            case '*':
                return 1;

            case '/':
                return 1;

            case '(':
                return 2;

            case ')':
                return 2;

        }
        return -2;
    }

    public double countPostfix() {
        String[] values = output.split(" ");
        MyStackDouble stackDouble = new MyStackDouble(100);

        for (int i = 0; i < values.length; i++) {
            String val = values[i];
            if (isStringSign(val)) {
                double first = stackDouble.pop();
                double second = stackDouble.pop();
                stackDouble.push(calculate(val.charAt(0), second, first));
            }
            else if(val.compareTo(" ") != 0 && val.compareTo("") != 0) {
                stackDouble.push(Double.parseDouble(val));
            }
        }
        return stackDouble.pop();
    }


    public double calculate(char sign, double a, double b){

        switch (sign){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
        }

        System.out.println("Syntax error!");
        return 0;
    }


    public static void main(String[] args) throws  IOException{
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String in = bufferedReader.readLine();

        BracketsExpressionFinal expression = new BracketsExpressionFinal(in);

        expression.infixTiPostfix();
        System.out.println(expression.countPostfix());
    }
}
