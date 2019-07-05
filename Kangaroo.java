import java.util.*;

public class Kangaroo{
    public static void main(String[] args){
        
        Scanner in=new Scanner(System.in);

        int x1,v1,x2,v2,i;
        x1=in.nextInt();
        v1=in.nextInt();
        x2=in.nextInt();
        v2=in.nextInt();

        for(i=0;i<10000;i++){
            x1=x1+v1;
            x2=x2+v2;
            if(x1==x2){
                System.out.println("YES");
                break;
            }

        }
        
        if(x1!=x2)
            System.out.println("NO");
    }
}
