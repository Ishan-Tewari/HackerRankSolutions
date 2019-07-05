import java.util.Scanner;
public class MiniMaxSum
{
    public static void main(String[] args)
    {
        long a[]= new long[5];
        long sum[]= new long[5];
        int i,j;
        long sum_tot=0,temp;
        Scanner scan=new Scanner(System.in);
        for(i=0;i<5;i++)
        {
            a[i]=scan.nextLong();
        }
        for(i=0;i<5;i++)
        {
            sum_tot=sum_tot+a[i];
        }
        for(i=0;i<5;i++)
        {
            sum[i]=sum_tot-a[i];
        }
        for (i = 0; i < 4; i++)
        {
            for (j = 0; j < 4-i; j++)
            {
                if (sum[j] > sum[j+1])
                {
                    
                    temp = sum[j];
                    sum[j] = sum[j+1];
                    sum[j+1] = temp;
                }
            }
        }
        System.out.println(sum[0]+" "+sum[4]);
    }
}
