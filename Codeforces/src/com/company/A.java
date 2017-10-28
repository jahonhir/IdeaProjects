//package com.company;

import java.io.*;


    public class A {
        public static void main(String[] args) throws IOException
        {
            new A().run();
        }

        StreamTokenizer in;
        PrintWriter out;

        long nextInt() throws IOException
        {
            in.nextToken();
            return (long )in.nval;
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
            long n = nextInt();
            long k = nextInt();

            long numberOfDiploma = (n/2) / (k+1);

            long numberOfMention = numberOfDiploma * k;

            long numberOfLoser = n - numberOfDiploma - numberOfMention;

            out.println(numberOfDiploma);
            out.println(numberOfMention);
            out.println(numberOfLoser);

        }


    }

