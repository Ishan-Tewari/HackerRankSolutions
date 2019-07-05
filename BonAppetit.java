import java.util.Scanner;

public class BonAppetit {
    public static void main(String[] args){

        //declaration and initialization
        Scanner in = new Scanner(System.in);
        int n,k,bActual=0,sum=0,bCharged;
        n=in.nextInt();
        k=in.nextInt();
        int bill[] = new int[n];

        //scanning the elements of array
        for(int i=0;i<n;i++){
            bill[i]=in.nextInt();
        }

        //scanning the value of the charged bill
        bCharged = in.nextInt();

        //calculation of the actual bill
        for(int i=0;i<n;i++){
            if(i!=k){
                sum=sum+bill[i];
            }
        }
        for(int i=0;i<n;i++){
            bActual=sum/2;
        }

        //printing the result for both the cases
        if(bActual==bCharged)
            System.out.println("Bon Appetit");
        else
            System.out.println(bCharged-bActual);
    }
}
