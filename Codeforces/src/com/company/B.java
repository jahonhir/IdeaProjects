package com.company;


import java.io.*;

public class B {
    public static void main(String[] args) throws IOException
    {
        new B().run();
    }

    StreamTokenizer in;
    PrintWriter out;

    int nextInt() throws IOException
    {
        in.nextToken();
        return (int)in.nval;
    }

    void run() throws IOException
    {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }

    void solve() throws IOException
    {
        int n = nextInt();
        int m = nextInt();

        int[] l = new int[m];
        int[] a = new int[n+1];

        for(int i = 0; i < m; i++){
            l[i] = nextInt();
        }

        int sumL = 0;
        a[l[0]] = Math.abs(a[l[2]] - a[l[1]]);
        if(a[l[0]] == 0){
            a[l[0]] = n;
        }
        for(int i = 1; i < m-1; i++) {
                a[l[i]] = Math.abs(a[l[i-1]]  - l[i + 1]) % n;


            if(a[l[i]] == 0){
                a[l[i]] = n;
            }
        }

        int numberOfZero = 0;

        for(int i =1; i <=n; i++){
           if(a[i] == 0){
               numberOfZero++;
           }
        }


        if(numberOfZero > 0){
            out.println(-1);
            return;
        }


        for(int i =1; i <=n; i++){
            out.println(a[i]);

        }
    }


}
