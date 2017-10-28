package Recursion.FactorialProgramm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Factorial {

    public BigInteger fact(BigInteger n){
        if(n.compareTo(BigInteger.ONE) == 0 || n.compareTo(BigInteger.ZERO) == 0){
            return BigInteger.ONE;
        }

        return n.multiply(fact(n.subtract(BigInteger.ONE)));
    }
}



class FactarialApp{
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Factorial factorial = new Factorial();

        BigInteger n = BigInteger.valueOf(Integer.parseInt(br.readLine()));

        BigInteger f = factorial.fact(n);

        System.out.println(f);

    }
}