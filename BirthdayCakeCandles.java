import java.util.Scanner;
public class BirthdayCakeCandles
{
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int n,max=0,count=0;
        int i;
        n=scan.nextInt();
        int a[]= new int[n];
        for(i=0;i<n;i++)
        {
            a[i]=scan.nextInt();
        }
        for(i=0;i<n;i++)
        {
            if(a[i]>max)
                max=a[i];
        }
        for(i=0;i<n;i++)
        {
            if(a[i]==max)
                count++;
        }
        System.out.println(count);
    }
}
