package Recursion.TriangleProgramm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
    public int sum(int n){
        if(n == 1) {

            return 1;
        }
        return n + sum(n-1);
    }

}

class TriangleApp{

    public static void main(String[] args) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Triangle triangle = new Triangle();
        int n = Integer.parseInt(br.readLine());
        System.out.println(triangle.sum(n));
    }

}