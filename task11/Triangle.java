/**
*@author YotamGranot @version 2020a
*class that determines if given triangle Upholds the triangle inequality
*/
import java.util.Scanner;
public class Triangle
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter the three lengths"
        + " of a triangle's sides");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int p = a+b+c; //  perimeter of the given triangle
        double area;
        if(!(a+b>c))
        {
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println("lengths of triangle's sides are invalid because "
            + a + "+" + b + " isnt greater than " + c);// invalid because of triangle inequality
        }
        else if(!(a+c>b))
        {
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println("lengths of triangle's sides are invalid because "
            + a + "+" + c + " isnt greater than " + b);// invalid because of triangle inequality
        }       
        else if(!(b+c>a))
        {
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println("lengths of triangle's sides are invalid because "
            + b + "+" + c + " isnt greater than " + a);// invalid because of triangle inequality
        }
        else
        {
            area = Math.sqrt(0.5*p*(0.5*p-a)*(0.5*p-b)*(0.5*p-c));
            System.out.println("the perimeter of the triangle is " + p);
            System.out.println("the area of the triangle is " + area);
        }

    }
}
