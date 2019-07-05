import java.util.*;
public class ApplesAndOranges{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int s,t,a,b,m,n,i,a_pos,a_count=0,o_pos,o_count=0;


        //Scanning different variables

        s=in.nextInt();
        t=in.nextInt();
        a=in.nextInt();
        b=in.nextInt();
        m=in.nextInt();
        n=in.nextInt();

        //Scanning array

        int app_array[]=new int[m];
        int ora_array[]=new int[n];

        //Scanning elements of array
        
        for(i=0;i<m;i++){
            app_array[i]=in.nextInt();
        }
        for(i=0;i<n;i++){
            ora_array[i]=in.nextInt();
        }

        //Calculation

        for(i=0;i<m;i++){
            a_pos=a+app_array[i];
            if(a_pos>=s && a_pos<=t){
                a_count++;
            }
        }
        for(i=0;i<n;i++){
            o_pos=b+ora_array[i];
            if(o_pos>=s && o_pos<=t){
                o_count++;
            }
        }

        //Printing the result

        System.out.println(a_count);
        System.out.println(o_count);
    }
}
