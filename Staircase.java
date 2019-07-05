import java.util.Scanner;
public class Staircase
{
    public static void main(String[] args)
    {
        int i,j,n;
        Scanner scan=new Scanner(System.in);
        n=scan.nextInt();
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                if(j>=n+1-i && j<=n)
                    System.out.print("#");
                else
                    System.out.print(" "); 
            }
            System.out.println();
        }
    }
}                                                                   

 
