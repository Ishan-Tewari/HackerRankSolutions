import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;

import static java.lang.Math.*;

// fast reader program for faster reading of data
public class SockMerchant implements Runnable
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
        new Thread(null, new SockMerchant(),"Main",1<<27).start();
    }

    // main logic of program
    public void run(){
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int pair=0;
        int n = in.nextInt();
        int a[] = new int[101];
        int count[] = new int[101];

        //scanning array
        for (int i=0;i<n;i++){
            a[i]=in.nextInt();
        }

        //counting of frequency of each and every element of array
        for (int i=0;i<101;i++){
            int temp=a[i];
            count[temp]++;
        }
        
        //starting for loop from 1 because we dont need 0 in our data(conditions already given)
        //if count is even and it is not 0, then pair would be half of the value of count        
        // eg: count=4, thus there are 2 pair of socks and 0 remaining socks
        // if count is odd and it is not 0, then pair would bey half of (count-1) as 1 sock would be left as it is
        //eg: count=5, thus there are 2 pair of socks and 1 remaining socks
        for (int i=1;i<101;i++){
            if(count[i]%2==0 && count[i]!=0){
                pair=pair +count[i]/2;
            }
            else if(count[i]%2!=0 && count[i]!=0){
                pair=pair+(count[i]-1)/2;
            }
          }

        w.println(pair);

        //closing of w function from fast reader program we created
        w.flush();
        w.close();
    }

}
