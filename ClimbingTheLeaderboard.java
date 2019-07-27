//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem


import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.math.*;
import java.lang.*;

import static java.lang.Math.*;

// fast reader program for faster reading of data(you can use System.out.println too)
public class ClimbingTheLeaderboard implements Runnable
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
        new Thread(null, new ClimbingTheLeaderboard(),"Main",1<<27).start();
    }

    // main logic of program
    public void run() {

        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        //scanning the scores
        int n = in.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = in.nextInt();
        }

        //providing ranks on the basis of scores using dense ranking system
        int[] ranks = new int[n];

        //first element is itself given rank 1 as the scores array is already sorted in decreasing order
        int rank = 1;

        for (int i = 0; i < n; i++) {

            //checking if the two elements are same so they are provided the same rank
            if (i > 0 && scores[i] != scores[i - 1]) {
                rank++;
            }

            //assigning the calculated rank to the ranks array
            ranks[i] = rank;
        }

        //scanning the alice's scores and calculating its rank at the same time so no need of declaring an array
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int aliceScore = in.nextInt();

            //applying binary search logic
            int left = 0;
            int right = n-1;
            int aliceRank = 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (aliceScore == scores[mid]) {

                    //if the alice's score is same as anyone else's score than the rank would be same
                    aliceRank = ranks[mid];
                    break;
                }

                //if alice's score is less than someone else's score, it would have a lesser rank than that person
                else if (aliceScore < scores[mid]) {
                    aliceRank = ranks[mid] + 1;
                    left = mid + 1;
                }

                //if alice's score is less than someone else's score, it would have a greator rank than that person
                else {
                    right = mid - 1;
                }
            }
            w.println(aliceRank);

        }
        //end of main logic of the program

        w.flush();
        w.close();
    }


}



