package Recursion.Anagram;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class AnagramApp {
    int size;
    char[] word;
    int count;
    int numbInString;
    AnagramApp(char [] word, int size){
        this.size = size;
        this.word = word;
        this.count = 0;
        this.numbInString = factorial(size-1);
    }

    public int factorial(int n){
        if(n <= 1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public void doAnagram(int n){
        if(n == 1){
            return;
        }

        for(int i = 0; i < n; i++) {
            doAnagram(n - 1);
            if(n == 2) {
                dislayWord();
            }
                rotate(n);

        }

    }

    public void dislayWord(){
        count ++;
        System.out.print(count + " ");
        for(int i = 0; i < size; i++){
            System.out.print(word[i]);
        }
        if(count % numbInString == 0){
            System.out.println("");
        }
        else {
            System.out.print("    ");
        }
    }

    public void rotate(int n){
        int position = size - n;
        char first = word[size-1];
        for(int i = size - 1 ; i > position; i-- ){
            word[i] = word[i-1];
        }
        word[position] = first;
    }


    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Enter word:");
        char[] input = br.readLine().toCharArray();
        AnagramApp anagram = new AnagramApp(input, input.length);
        anagram.doAnagram(anagram.size);
    }



}
