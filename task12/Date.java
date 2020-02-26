
/**
 * This class represents a Date object
 *
 * @author Yotam Granot
 * @version 2020a
 */
public class Date
{
    
    private int _day;
    private int _month;
    private int _year;
    private final int DEFAULT_YEAR =2000, DEFAULT_DAY = 1, DEFAULT_MONTH = 1;
    private final int DEC = 12, JAN = 1,AUG =8,FEB = 2,JUL = 7;
    private final int MIN_YEAR = 1000,MAX_YEAR = 9999;
    private final int DAYS_IN_LONG_MONTH = 31, DAYS_IN_SHORT_MONTH = 30, DAYS_IN_FEB = 28;
    /**
     *creates a new Date object if the date is valid, otherwise creates the date 1/1/2000
     * @param day - the day in the month (1-31)
     * @param month - the month in the year (1-12)
     * @param year - the year (4 digits)
     */
    public Date(int day, int month, int year)
    {
        // initialise instance variables
        this._day = day;
        this._month = month;
        this._year = year;
        if (!isValid(this._day, this._month, this._year))
        {
            this._day = DEFAULT_DAY;
            this._month =DEFAULT_MONTH;
            this._year = DEFAULT_YEAR;
        }
    }

    /**
     * copy constructor
     * @param other  the date to be copied
     */
    public Date(Date other)
    {
        this._day = other.getDay();
        this._month = other.getMonth();
        this._year = other.getYear();
    }

    /**
     *  gets the day
     * @return the day
     */
    public int getDay()
    {
        return this._day;
    }
    /**
     *  gets the month
     * @return the month
     */
    public int getMonth()
    {
        return this._month;
    }
    /**
     *  gets the year
     * @return the year
     */
    public int getYear()
    {
        return this._year;
    }

    /**
     * sets the year (only if date remains valid)
     * @param yearToSet the year value to be set
     */
    public void setYear(int yearToSet)
    {
        if (isValid(this._day,this.month,yearToSet))
        {
            this._year = yearToSet;
        }
    }
    /**
     * sets the month (only if date remains valid)
     * @param monthToSet the month value to be set
     */
    public void setMonth(int monthToSet)
    {
        if (isValid(this._day,monthToSet,this._year))
        {
            this._month = monthToSet;
        }
    }
    /**
     * sets the day (only if date remains valid)
     * @param dayToSet the day value to be set
     */
    public void setDay(int dayToSet)
    {
        if (isValid(dayToSet,this._month,this._year))
        {
            this._day = dayToSet;
        }
    }

    /**
     * check if 2 dates are the same
     * @param other the date to compare this date to
     * @return true if the dates are the same
     */
    public boolean equals(Date other)
    {
        if (this._day == other.getDay() && this._month == other.getMonth() && 
            this._year == other.getYear())
        {
            return true;
        }
        return false;
    }
    /**
     * check if this date is before other date
     * @param other the date to compare this date to
     * @return true if this date is before other date
     */
    public boolean before(Date other)
    {
        if (this._year<other.getYear()) //check if year is before
        {
            return true;
        }
        else if (this._year == other.getYear()) {
            if (this._month<other.getMonth()) //if month before it's true
            {   
                return true;
            }
            else if (this._month==other.getMonth())
            {
                if (this._day<other.getDay()) // if day before it's true
                {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * check if this date is after other date
     * @param other the date to compare this date to
     * @return true if this date is after other date
     */
    public boolean after(Date other)
    {
        return other.before(this);
    }
    
    public int difference(Date other)
    {
        return Math.abs(calculateDate(this._day,this._month,this._year)-
                        calculateDate(other.getDay(), other.getMonth(),
                        other.getYear()));
    }

    /**
     * calculate the date of tomorrow
     * @return the date of tomorrow
     */
    public Date tomorrow()
    {
        if (lastDayOfMonth(this._day, this._month,this._year))
        {   
            if (this._month ==DEC)
            {
                return new Date(DEFAULT_DAY,DEFAULT_MONTH,this._year+1);
            }
            return new Date(DEFAULT_DAY,(this._month+DEFAULT_MONTH),this._year);
        }
        return new Date((this._day+DEFAULT_DAY),this._month,this._year);
    }

    /**
     * returns a String that represents this date
     * @return String that represents this date in the following format: day/month/year for example: 02/03/1998
     */
    public String toString()
    {
        if (this._day<10&&this._month<10)
        return ("0"+this._day +"/" +"0"+ this._month + "/" + this._year);
        else if (this._day<10)
        return ("0"+this._day +"/" + this._month + "/" + this._year);
        else if (this._month<10)
        return (this._day +"/" + "0"+this._month + "/" + this._year);
        
        return (this._day +"/" + this._month + "/" + this._year);
    }

    /**
     * calculate the day of the week that this date occurs on 0-Saturday 1-Sunday 2-Monday etc.
     * @return the day of the week that this date occurs on
     */
    public int dayInWeek()
    {
        int D = this._day;
        int M = this._month;
        int Y = this._year % 100;
        int C = this._year / 100;
        if (M==FEB||M==JAN){
            M+=12;
            Y = (this._year-1) % 100;
            C = (this._year-1) / 100;
        }
        int baseDay = (D + (26*(M+1))/10 + Y + Y/4 + C/4 - 2*C);//given formula
        if (baseDay<0){
            return Math.floorMod(baseDay,7);
        }
        return (baseDay % 7);

        
    }
    
    /* Private methods */
    private boolean isValid(int day,int month, int year)
    {
		if (month<=0||day<=0||year<=0)
			return false;
        if (month>=JAN&&month<=DEC)//check if month between JAN and DEC
        {
            if ((year>=MIN_YEAR) && (year<=MAX_YEAR)) //check if year in range
            {
                if ((month<AUG && month%FEB != 0) || (month>JUL && month%FEB == 0))
                {
                    if (day <= DAYS_IN_LONG_MONTH)
                    {
                        return true;
                    }
                }
                else if (month !=FEB)
                {
                    if (day < DAYS_IN_LONG_MONTH)
                    {
                        return true;
                    }
                }
                else 
                {
                    if (isLeap(year))
                    {
                        if (day <= DAYS_IN_FEB+1)
                        {
                            return true;
                        }
                    }
                    else if (day<=DAYS_IN_FEB)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean isLeap(int year)
    {
        // calculate ifs the year leap
        if (year%4 == 0 &&( year%100 !=0 ||(year%400==0)))
        {
            return true;
        }
        return false;
    }
    //computes the day number since the beginning of the christian 
    //counting of years by given formula
    private int calculateDate (int day, int month, int year)
    {
         if (month < 3) {            
             year--;
             month = month + 12;        
         }          
         return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);                
    }
    
    private boolean lastDayOfMonth(int day, int month, int year)
    {   
        //JAN, MAR, MAY, JUL, AUG, OCT, DEC have 31 days
        if ((month<AUG && month%FEB != 0) || (month>JUL && month%FEB == 0)) 
        {
            if (day == DAYS_IN_LONG_MONTH)
            {
                return true;
            }
        }
        //APR, JUN, SEP, NOV have 30 days
        else if (month !=FEB)
        {
            if (day == DAYS_IN_SHORT_MONTH)
            {
                return true;
            }
        }
        else 
        {
            // in leap years FEB has 29 days
            if (isLeap(year))
            {
                if (day == DAYS_IN_FEB+1)
                {
                    return true;
                }
            }
            // in regular years FEB has 29 days
            else if (day==DAYS_IN_FEB)
            {
                return true;
            }
        }
        return false;
    }
}