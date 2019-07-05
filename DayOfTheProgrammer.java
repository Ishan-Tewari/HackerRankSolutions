import java.util.Scanner;

public class DayOfTheProgrammer {
    public static void main(String[] args){

        //declaration and initialization
        Scanner in=new Scanner(System.in);
        int y,date,temp;
        y=in.nextInt();

        //condition if the year lies in the gregorian calendar
        if(y>1918){
            //condition to check if the year is a leap year
            if(y%400==0 || (y%4==0 && y%100!=0))
                temp=29;
            else
                temp=28;
            //215=sum of the days in first 8 months excluding february
            //256=256th day of the year
            //subtracting (215+ the days in feb) from 256 will give the date required
            date=256-(215+temp);
        }

        //condition if the year lies in the julian calendar
        else if(y<1918){
            //condition to check if the year is a leap year
            if(y%4==0)
                temp=29;
            else
                temp=28;

            //subtracting (215+ the days in feb) from 256 will give the date required
            date=256-(215+temp);
        }

        //condition if the year is 1918(the year of transition)
        else
            //date=26 by calculating the days required to reach the 256th day of that month
            // i.e. 256-(31+15+31+30+31+30+31+31)
            date=26;

        //printing the date and the month will always be of september 
        System.out.println(date+"."+"09."+y);
    }
}
