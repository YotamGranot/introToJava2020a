/**
 * mmn 14 solution
 *
 * @author YotamG
 * @version 2020a
 */
public class Ex14
{
    /**
     * method that finds number of substrings that start and end
     * </br> with a given char and has one show of C har in it
     * Time complexity: O(n)</br>
     * Space complexity: O(1)</br>
     * @param s string to find substrings of.
     * @paran c char to start, end and will be once in subString
     * @return number of substrings which start with c end with c
     * </br>  and only has one show of c.
     * 
     */
    public static int subStrC(String s, char c){
        
        int numOfC = 0;
        for (int i=0; i<s.length();i++){//counts how many c's in string
            if (s.charAt(i) == c){
                numOfC++;                     
            }
        }
        if(numOfC>1) 
            // if there is more than 2 c's 
            // number of asked substrigs is numcer Of c's-2
            //else it's 0
            return numOfC-2;
        return 0;
    }
    /**
     * method that finds number of substrings that start and end
     * </br> with a given char and has  max given number of shows of C har in it
     * Time complexity: O(n)</br>
     * Space complexity: O(1)</br>
     * @param s string to find substrings of.
     * @paran c char to start, end and will be 
     * </br>max given numbers of times in subString
     * @param k max number of shows for c
     * @return number of substrings which start with c end with c
     * </br>  and only has max k shows of c.
     * 
     */
    public static int subStrMaxC(String s, char c, int k){
        int numOfC = 0;
        int numOfKSubStrings = 0;
        if(k>s.length()-2) 
        //there can't be any substrings longer than the string
            k = s.length();
        for(int i=0; i<s.length();i++){
            // counts number of c's
            if (s.charAt(i) == c){
                numOfC++;
            }
        }
        for(int i = 0;i<=k;i++){
            // for each iteration counts number of 
            //substrings with i times c's in it
            if(numOfC>i+1)
            // if not numOfC>i+1 cant be longer substring
                numOfKSubStrings+=(numOfC-i-1);
        }
        
        return numOfKSubStrings;
    } 
    /**
     * method that changes given array of 1's and 0's to an</br>
     * array of shortest distance between the indexes of the one</br>
     * to the closest zero</br>
     * Time complexity: O(n)</br>
     * Space complexity:O(1)
     * @param a array to be changed
     */
    public static void zeroDistance (int [] a){
        
        int firstZero=-1;
        for (int i=0 ; i<a.length ; i++) 
        //counts from left to right and places in each cell
        //distance to closest cell with 0 from the left.
            if (a[i] == 0)
            //if there is 0 in cell counter from first zero is 0
                firstZero= 0;
            else {         
           
                if (firstZero== -1)
                //if no zero found tag cell with max value
                    a[i] = Integer.MAX_VALUE;
               else {
                   //raise counter by 1 and 
                   //adjust the value of currnent cell 
                   //to counter
                   firstZero++;
                   a[i] = firstZero;
               }                    
            }
        int lastZero=-1;
        for (int i=a.length-1 ; i>=0 ; i--)
        //counts from right to left and places in each cell
        //distance to closest cell with 0 from the right.
        //only if smaller than closest 0 from the left
            if (a[i] == 0)  
            //if there is 0 in cell counter from first zero is 0
                lastZero= 0;
            else if (lastZero!= -1 && a[i] > ++lastZero)
            // if found 0 or value in cell 
            //bigger than counter place counter in cell
                a[i] = lastZero;  
                                        
    }
    /**
     * method that determinant is the string in the second</br>
     * parameter is transformation of the string in the</br>
     * second parameter,
     * param s string that is the source of transformed string
     * param t transformed string
     * @return true if t is transformation of s
     */
    public static boolean isTrans(String s, String t){
        
        if(s.length()>t.length())
        //if sourch longer than transformed 
        //there is no transformation
            return false; 
        
        if(t.length() == 0){
            //if length of transformed string is zero 
            // and length of source <= length of transformed
            //both empty so this is transformation
            return true;
            
        }
        if(s.length() == 0)
        //if s.length = 0 and t.length != 0
        // there is no transformation
            return false;
        if(s.charAt(0) == t.charAt(0)){
            //recursive call 
            //return isTrans of given source and transformed without 1st char
            //or isTrans of both source and transformed without 1st char
            return (isTrans(s,t.substring(1))||isTrans(s.substring(1),t.substring(1)));
        }
        return false; 
    }
    /**
     * method that counts the paths from first cell of </br>
     * given matrix to last cell of the given matrix
     * @param mat matrix to count paths in
     * @return number of paths
     */
    public static int countPaths (int [][] mat){
        return countPaths(mat, 0,0);
    }
    private static int countPaths (int [][] mat, int i,int j){
        if(i == mat.length -1 && j == mat[0].length-1){
            //if this is last cell of matrix return 1
            return 1;
        }
        else if(i >= mat.length || j>=mat[0].length){
            //if out of matrix return 0
            return 0;
        }
        else if(mat[i][j] == 0)
        //if sent back to begining return 0
            return 0;
        else if(mat[i][j]%11 == 0){
            //if value in cell mod 11 is 0 
            //both units and tens equal so cell can send only 1 location
            int units = (mat[i][j]%10);
            int tens = mat[i][j]/10;
            // recursive call
            //find number of path from next cell
            return(countPaths(mat, i+tens,j+units));
        }
        else{
            int units = (mat[i][j]%10);
            int tens = mat[i][j]/10;
            //recursive call
            //find number of path from next 2 cells 
            //returns sum of both

            return(countPaths(mat, i+tens,j+units)+countPaths(mat,i+units,j+tens));
        }
    }
}
    
       


