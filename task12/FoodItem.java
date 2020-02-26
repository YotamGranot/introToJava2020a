/**
 * Write a description of class FoodItem here.
 *
 * @author (Yotam Granot)
 * @version (2020a)
 */
public class FoodItem
{
    // instance variables - replace the example below with your own
    private String _name;
    private long _catalogueNumber;
    private int _quantity;
    private Date _productionDate;
    private Date _expiryDate;
    private int _minTemperature;
    private int _maxTemperature;
    private int _price;
    private final int MIN_PRICE = 1, MIN_QUANTITY=0,MIN_CATALUGE=1000,MAX_CATALUGE =9999;
    private final int DEFAULT_CATALOGUE_NUMBER = 9999;
    
    /**
     * creates a new FoodItem object
     * @param name - name of food item
     * @param catalogueNumber - catalogue number of food item
     * @param quantity - quantity of food item
     * @param productionDate - production date
     * @param expiryDate - expiry date
     * @param minTemperature - minimum storage temperature
     * @param maxTemperature - maximum storage temperature
     * @param price - unit price
     */
    public FoodItem(String name, long catalogueNumber, int quantity, Date productionDate, Date expiryDate, 
                    int minTemperature, int maxTemperature, int price)
    {
        // initialise instance variables
        if (isNameValid(name)) //checking if name valid if not gives defualt
            this._name = name;
        else
            this._name = "item";
        if (isCatalugeNumValid(catalogueNumber)) //checking if catNum valid if not gives defualt
            this._catalogueNumber = catalogueNumber;
        else
            this._catalogueNumber = DEFAULT_CATALOGUE_NUMBER;
        if (quantity >= MIN_QUANTITY) //checking if quantity valid if not gives defualt
        {
            this._quantity = quantity;
        }
        else
            this._quantity = MIN_QUANTITY;
        
        this._productionDate = new Date(productionDate);
        if (isExpiryDateValid(expiryDate)) //checking if expiryDate valid if not gives defualt
        {
            this._expiryDate = new Date(expiryDate);
        }
        else
        {
            this._expiryDate = new Date(this._productionDate.tomorrow());
        }
        //checking if minTmp smaller then max if not switch
        if (isTemperaturesValid(minTemperature, maxTemperature))
        {
            this._minTemperature = minTemperature;
            this._maxTemperature = maxTemperature;
        }
        else
        {
            this._minTemperature = maxTemperature;
            this._maxTemperature = minTemperature;
        }
        if (price > MIN_PRICE)  //checking if price valid if not gives defualt
        {
            this._price = price;
        }
        else
            this._price = MIN_PRICE;
    }
    /**
     * copy constructor 
     * @param other - the food item to be copied
     */
    public FoodItem(FoodItem other)
    {
        this._name = other.getName();
        this._catalogueNumber = other.getCatalogueNumber();
        this._quantity = other.getQuantity();
        this._productionDate = other.getProductionDate();
        this._expiryDate = new Date(other.getExpiryDate());
        this._minTemperature = new Date(other.getMinTemperature());
        this._maxTemperature = other.getMaxTemperature();
        this._price = other.getPrice();
    }
    /**
     * gets the name 
     * @return the name
     */
    public String getName()
    {
        return this._name;
    }
    /**
     * gets the catalogue number 
     * @return the catalogue number
     */
    public long getCatalogueNumber()
    {
        return this._catalogueNumber;
    }
    /**
     * gets the quantity 
     * @return the quantity
     */
    public int getQuantity()
    {
        return this._quantity;
    }
    /**
     * gets the production date 
     * @return the production date
     */
    public Date getProductionDate()
    {
        return new Date(this._productionDate);
    }
    /**
     * gets the expiry date 
     * @return the expiry date
     */
    public Date getExpiryDate()
    {
        return new Date(this._expiryDate);
    }
    /**
     * gets the  minimum storage temperature 
     * @return the  minimum storage temperature
     */
    public int getMinTemperature()
    {
        return this._minTemperature;
    }
    /**
     * gets the maximum storage temperature
     * @return the maximum storage temperature
     */
    public int getMaxTemperature()
    {
        return this._maxTemperature;
    }
    /**
     * gets the unit price  
     * @return the unit price 
     */
    public int getPrice()
    {
        return this._price;
    }
    /**
     * set the quantity (only if not negative) 
     * @param n - the quantity value to be set
     */
    public void setQuantity(int n)
    {
        if (n >= MIN_QUANTITY) //check if quantity valid
        {
            this._quantity = n;
        }
    }
    /**
     * set the production date (only if not after expiry date )
     * @param d - production date value to be set
     */
    public void setProductionDate(Date d)
    {
        if (!(d.after(this._expiryDate)))//chek if production date valid
        {
            this._productionDate = new Date(d);
        }
    }
    /**
     * set the expiry date (only if not before production date ) 
     * @param d - expiry date value to be set
     */
    public void setExpiryDate(Date d)
    {
        if (!(d.before(this._productionDate))) //chek if expirydate valid
        {
            this._expiryDate = new Date(d);
        }
    }
    /**
     * set the price (only if positive) 
     * @param n - price value to be set
     */
    public void setPrice(int n) 
    {
        if (n > MIN_PRICE) //check price valid
        {
            this._price = n;
        }
    }
    /**
     * check if 2 food items are the same (excluding the quantity values) 
     * @param  other - the food item to compare this food item to 
     * @return true if the food items are the same
     */
    public boolean equals(FoodItem other)
    {
        
        if ((other.getPrice() == this._price) &&
            (other.getExpiryDate().equals(this._expiryDate)) &&
            (other.getProductionDate().equals(this._productionDate)) &&
            (other.getName().equals(this._name)) &&
            (other.getMinTemperature() == this._minTemperature) &&
            (other.getMaxTemperature() == this._maxTemperature) &&
            (other.getCatalogueNumber() == this._catalogueNumber))
        {
            return true;
        }
        return false;
    }
    /**
     * check if this food item is fresh on the date d 
     * @param d - date to check 
     * @return true if this food item is fresh on the date d
     */
    public boolean isFresh(Date d)
    {
        // if not after (before or equal) expiry and not before (equal or after) production date
        return !(d.after(this._expiryDate)) &&
        !(d.before(this._productionDate));
    }
    /**
     * returns a String that represents this food item 
     * @return String that represents this food item in the following format: </br>FoodItem: milk CatalogueNumber: 1234 ProductionDate: 14/12/2019 ExpiryDate: 21/12/2019 Quantity: 3 
     */
    public String toString()
    {
    return "FoodItem: " + this._name + "\tCatalogueNumber: " + this._catalogueNumber + "\tProductionDate: " + this._productionDate + "\tExpiryDate: " + this._expiryDate + "\tQuantity: " + this._quantity;
    }
    /**
     * check if this food item is older than other food item 
     * @param other - food item to compare this food item to 
     * @return true if this food item is older than other date
     */
    public boolean olderFoodItem(FoodItem other)
    {
        // check if production date before the given item production date
        if (this._productionDate.before(other.getProductionDate()))
        {
            return true;
        }
        return false;
    }
    /**
     * returns the number of units of products that can be purchased for a given amount 
     * @param amount - amount to purchase 
     * @return the number of units can be purchased
     */
    public int howManyItems(int amount)
    {   //check if there are less items than I can buy
        if (this._quantity<amount/this._price)
        {
            return this._quantity;
        }
        return amount/this._price;
    }
    /**
     * check if this food item is cheaper than other food item 
     * @param other - food item to compare this food item to 
     * @return true if this food item is cheaper than other date
     */
    public boolean isCheaper(FoodItem other)
    {
        if (other.getPrice()>this._price)
        {
            return true;
        }
        return false;
    }
    
    private boolean isExpiryDateValid(Date expiryDate)
    {
        if (!expiryDate.before(this._productionDate))// chek if expiry date valid
        {
            return true;
        }
        return false;
    }
    
    private boolean isTemperaturesValid(int minTemperature, int maxTemperature)
    {
        if (!(minTemperature>maxTemperature))
        {
            return true;
        }
        return false;
    }
    
    private boolean isCatalugeNumValid(long cat)
    {
        if (MIN_CATALUGE<=cat&&MAX_CATALUGE>=cat)
            return true;
        return false;
    }
    private boolean isNameValid(String name)
    {
        if (!(name.equals("")))
            return true;
        return false;
    }
}
