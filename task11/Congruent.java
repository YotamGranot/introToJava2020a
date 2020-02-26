/**
*@author YotamGranot @version 2020a
*class that determines if two triangles are congruent
*/

import java.util.Scanner;
public class Congruent
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program calculates the length of given"
        + " triangles' sides and determine if they are Congruent");
        System.out.println("Please enter 3 coordinates of first triangle's"
        + " sides, first the x than the y" );
        double t1x1 = scan.nextDouble();
        double t1y1 = scan.nextDouble();
        double t1x2 = scan.nextDouble();
        double t1y2 = scan.nextDouble();
        double t1x3 = scan.nextDouble();
        double t1y3 = scan.nextDouble();
        System.out.println("Please enter 3 coordinates of second triangle's"
        + " sides, first the x than the y" );
        double t2x1 = scan.nextDouble();
        double t2y1 = scan.nextDouble();
        double t2x2 = scan.nextDouble();
        double t2y2 = scan.nextDouble();
        double t2x3 = scan.nextDouble();
        double t2y3 = scan.nextDouble();
        
        double t1a = Math.sqrt(Math.pow((t1x1-t1x2),2.0)+Math.pow((t1y1-t1y2),2.0));
        double t1b = Math.sqrt(Math.pow((t1x3-t1x2),2.0)+Math.pow((t1y3-t1y2),2.0));
        double t1c = Math.sqrt(Math.pow((t1x1-t1x3),2.0)+Math.pow((t1y1-t1y3),2.0));
        double t2a = Math.sqrt(Math.pow((t2x1-t2x2),2.0)+Math.pow((t2y1-t2y2),2.0));
        double t2b = Math.sqrt(Math.pow((t2x3-t2x2),2.0)+Math.pow((t2y3-t2y2),2.0));
        double t2c = Math.sqrt(Math.pow((t2x1-t2x3),2.0)+Math.pow((t2y1-t2y3),2.0));
        System.out.println("The first triangle is ("+t1x1+","+t1y1+")"
        +" ("+t1x2+","+t1y2+") ("+t1x3+","+t1y3+").");
        System.out.println("Its lengths are "+t1a+" "+t1b+" "+t1c+" ");
        System.out.println("The first triangle is ("+t2x1+","+t2y1+")"
        +" ("+t2x2+","+t2y2+") ("+t2x3+","+t2y3+").");
        System.out.println("Its lengths are "+t2a+" "+t2b+" "+t2c+" ");
        if ((t1a == t2a) && (t1b == t2b) && (t1c == t2c)||
            (t1a == t2a) && (t1b == t2c) && (t1c == t2b)||
            (t1a == t2b) && (t1b == t2a) && (t1c == t2c)||
            (t1a == t2b) && (t1b == t2c) && (t1c == t2a)||
            (t1a == t2c) && (t1b == t2a) && (t1c == t2b)||
            (t1a == t2c) && (t1b == t2a) && (t1c == t2b)){
                System.out.println("The triangles are congruent");
        }else{
            System.out.println("The triangles are not congruent");
        }    
    }
}
