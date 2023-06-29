public class ColdDrink extends Product
{
    private int volume;
    private int coldDrinkAmount;

    

    public ColdDrink(String productName, String productCategory, double productPrice, int volume, int coldDrinkAmount) throws Exception 
    {
        super(productName, productCategory, productPrice);
        this.volume = volume;
        this.coldDrinkAmount = coldDrinkAmount;
    }

    public void setVolume(int volume) 
    {
        this.volume = volume;
    }

    public int getVolume() 
    {
        return volume;
    }

    public int getColdDrinkAmount() 
    {
        return coldDrinkAmount;
    }

    public void setColdDrinkAmount(int coldDrinkAmount) 
    {
        this.coldDrinkAmount = coldDrinkAmount;
    }
    
    @Override
    public String toString()
    {
        return "Напиток " + super.getproductName() + " из категории " + super.getCategory() + " объемом " + volume + " мл "+ "стоимостью " + super.getPrice() + " рублей. " + "Осталось продуктов: " + getColdDrinkAmount();
    }

    @Override
    public String toStringTo() //Вывод списка напитков для покупателя
    {
        return super.getproductName() + " Стоимостью " + super.getPrice() + " рублей. ";
    }

}