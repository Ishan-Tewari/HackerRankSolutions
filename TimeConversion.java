import java.util.Scanner;
public class TimeConversion
{
    public static void main(String[] args)
    {
        String t12,t24,sub,sub2;
        int n;
        Scanner scan=new Scanner(System.in);
        t12=scan.nextLine();
        if(t12.charAt(8)=='P')
        {
            sub=t12.substring(0,2);
            n=Integer.parseInt(sub);
            if(n!=12)
            {
                n=12+n;
            }
            sub=Integer.toString(n);
            t24=sub+t12.substring(2,8);
        }
        else
        {
            sub2=t12.substring(0,2);

            if(sub2.equals("12"))
            {
                t24="00"+t12.substring(2,8);
            }
            else
                t24=t12.substring(0,8);
        }
        System.out.println(t24);


    }
}
