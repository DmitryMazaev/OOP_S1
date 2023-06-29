import java.util.LinkedHashMap;

public class CofeMachine 
{
    private int cupAmount; //количество стаканчиков
    private int shugarAmount; //количество сахара
    private int boiledWater; //количество кипятка
    private int cofeAmount;  //количество кофе

    private LinkedHashMap<Integer, HotDrink> hotDrinks;

    public CofeMachine(int cupAmount, int shugarAmount, int boiledWater, int cofeAmount) 
    {
        this.cupAmount = cupAmount;
        this.shugarAmount = shugarAmount;
        this.boiledWater = boiledWater;
        this.cofeAmount = cofeAmount;
        hotDrinks = new LinkedHashMap<Integer, HotDrink>();
    }
    public int getCupAmount() {
        return cupAmount;
    }


    public int getShugarAmount() {
        return shugarAmount;
    }


    public int getBoiledWater() {
        return boiledWater;
    }


    public int getCofeAmount() {
        return cofeAmount;
    }


    public LinkedHashMap<Integer, HotDrink> getHotDrinks() {
        return hotDrinks;
    }

    public void setCupAmount(int cupAmount) {
        this.cupAmount = cupAmount;
    }
    public void setShugarAmount(int shugarAmount) {
        this.shugarAmount = shugarAmount;
    }
    public void setBoiledWater(int boiledWater) {
        this.boiledWater = boiledWater;
    }
    public void setCofeAmount(int cofeAmount) {
        this.cofeAmount = cofeAmount;
    }
    public void setHotDrinks(LinkedHashMap<Integer, HotDrink> hotDrinks) {
        this.hotDrinks = hotDrinks;
    }

    public void addHotDrink(Integer idCofe, HotDrink hotDrink) //метод по добавлению продукта в map
    {
        if (hotDrinks.containsKey(idCofe) != true)
        {
            hotDrinks.put(idCofe, hotDrink);
            
        }
    }

    public double printPrice(HotDrink hotDrink) // метод по выводу цены продукта
    {
        return hotDrink.getPrice();
    }

    public void changeCupAmount(HotDrink hotDrink) //метод по уменьшению стаканчиков в автомате после покупки
    {
        setCupAmount(getCupAmount() - 1);
    }
    
    public void changeShugarAmount(HotDrink hotDrink) //метод по уменьшению сахара в автомате после покупки
    {
        setShugarAmount(getShugarAmount() - hotDrink.getDoseShugar());
    }

    public void changeBoiledWater(HotDrink hotDrink) //метод по уменьшению воды в автомате после покупки
    {
        setBoiledWater(getBoiledWater() - hotDrink.getVolume());
    }
    
    public void changeCofeAmount(HotDrink hotDrink) //метод по уменьшению кофе в автомате после покупки
    {
        setCofeAmount(getCofeAmount() - hotDrink.getDoseCofe());
    }
    
    
}
