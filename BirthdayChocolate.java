import java.util.Scanner;
public class BirthdayChocolate{
    public static void main(String[] args){

        //Scanning and declaring variables
        Scanner in=new Scanner(System.in);
        int d,m;
        int i,j,n,sum=0,count=0;
        n=in.nextInt();
        int a[]=new int[n];

        //Storing variables

        for(i=0;i<n;i++){
            a[i]=in.nextInt();
        }

        d=in.nextInt();
        m=in.nextInt();

        //calculation

        for(i=0;i<n;i++){
            if((i + m - 1) == n){
                break;
            }

            else{
                sum= 0;
                for(j = 0; j < m ; j++){
                    sum += a[i+j];
                }

                if(sum == d){
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
