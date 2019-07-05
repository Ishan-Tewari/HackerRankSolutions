import java.util.Scanner;

public class MigratoryBirds {
    public static void main(String[] args){
        
        //declaration and initialization
        Scanner in = new Scanner(System.in);
        int n,temp;
        int max=0;
        n=in.nextInt();
        int a[]= new int[n];
        int count[]= new int[n];

        // Scanning the array
        for (int i=0;i<n;i++){
            a[i]=in.nextInt();
        }

        //counting the frequency of each character
        for(int i=0;i<n;i++){
            temp=a[i];
            count[temp]++;
        }

        //findind the maximum number of birds of any type
        for(int i=0;i<n;i++){
            if(count[i]>max)
                max=count[i];
        }
        //finding the smallest type of bird which occurs for the max time and printing the ans
        for(int i=0;i<n;i++){
            if(count[i]==max){
                System.out.println(i);
                break;
            }
        }
    }
}
