//https://www.hackerrank.com/challenges/cut-the-sticks/problem
//for main logic of the program, skip to line 195
//dry run at line 238


import java.io.*;
import java.util.*;
import java.lang.*;

public class CutTheSticks implements Runnable
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
        new Thread(null, new CutTheSticks(),"Main",1<<27).start();
    }

    public void run()
    {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int n = in.nextInt();
        int a[] = new int[n];

        for (int i=0;i<n;i++){
            a[i] = in.nextInt();
        }

        //finding the maximum of the given array
        int max=0;
        for (int i=0;i<n;i++){
            if(a[i]>=max)
                max=a[i];
        }
        
        //counting the frequencies of each element
        int count[] = new int[max+1];
        for (int i=0;i<n;i++){
            int temp = a[i];
            count[temp]++;
        }

        //counting sum from starting to ending and printing, then from index 1 to ending and so on
        for (int j=0;j<max+1;j++){
            int sum=0;
            for ( int i=j; i<max+1; i++){

                if (count[i] == 0)
                    continue;
                else
                    sum = sum+count[i];
            }
            if (count[j]!=0)
                w.println(sum);
        }


        w.flush();
        w.close();
    }
}
/*
    Dry Run
    224458      22580
    2-2
    4-2
    5-1
    8-1
    
    print- 2+2+1+1;
    print- 2+1+1;
    print- 1+1;
    print- 1;

    11223334
    1-2
    2-2
    3-3
    4-1
    
    print- 2+2+3+1;
    print- 2+3+1;
    print- 3+1;
    print- 1;

 */
