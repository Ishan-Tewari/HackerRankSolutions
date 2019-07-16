//https://www.hackerrank.com/challenges/magic-square-forming/problem

import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

import static java.lang.Math.*;

// fast reader program for faster reading of data(you can use System.out.println too)
public class FormingAMagicSquare implements Runnable
{
    static class InputReader
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream)
        {
            this.stream = stream;
        }

        public int read()
        {
            if (numChars==-1)
                throw new InputMismatchException();

            if (curChar >= numChars)
            {
                curChar = 0;
                try
                {
                    numChars = stream.read(buf);
                }
                catch (IOException e)
                {
                    throw new InputMismatchException();
                }

                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt()
        {
            int c = read();

            while(isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-')
            {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do
            {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.')
            {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.')
            {
                c = read();
                double m = 1;
                while (!isSpaceChar(c))
                {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c)
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next()
        {
            return readString();
        }

        public interface SpaceCharFilter
        {
            public boolean isSpaceChar(int ch);
        }
    }
    public static void main(String args[]) throws Exception
    {
        new Thread(null, new FormingAMagicSquare(),"Main",1<<27).start();
    }

    // main logic of program
    public void run(){
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        //only these many possible matrix can exist for a 3x3 matrix consisting of numbers 1-9
        //refer wikipedia for more understanding
        int[][][] possiblePermutations = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},// 1

                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},// 2

                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},// 3

                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},// 4

                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},// 5

                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},// 6

                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},// 7

                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},// 8
        };

        //declaring and storing the array/matrix
        int[][] a = new int[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
                a[i][j] = in.nextInt();
        }

        //initializing the minCost to maximum value of integer datatype
        int minCost = Integer.MAX_VALUE;
        //for every matrix, we have to match with the possible matrices and then see when lowest cost is achieved
        for (int matrix = 0; matrix < 8; matrix++)
        {
            int permutationCost = 0;
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                    permutationCost += Math.abs(a[i][j] - possiblePermutations[matrix][i][j]);
            }
            minCost = Math.min(minCost, permutationCost);
        }
        System.out.println(minCost);

        w.flush();
        w.close();
    }

}

