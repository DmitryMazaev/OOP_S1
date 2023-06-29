import java.util.LinkedHashMap;

public class VendingMachine 
{
    private int volume;



    private LinkedHashMap<Integer, ColdDrink> products;

    public VendingMachine(int volume) 
    {
        this.volume = volume;
        products = new LinkedHashMap<Integer, ColdDrink>();
    }
    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) 
    {
        this.volume = volume;
    }
    public LinkedHashMap<Integer, ColdDrink> getProducts() 
    {
        return products;
    }
    public void setProducts(LinkedHashMap<Integer, ColdDrink> products) 
    {
        this.products = products;
    }
    public Integer volumeProducts() // метод для суммирования общего числа продуктов в машине
    {
        int sum = 0;
        for (int value : products.keySet()) 
        {
            sum = sum + value;
        }
        return sum;
    }

    public void addProduct(Integer id, ColdDrink coldDrink) //метод по добавлению продукта в map
    {
        if (products.containsKey(id) != true)
        {
            products.put(id, coldDrink);
            
        }
    }

    public double printPrice(ColdDrink coldDrink) // метод по выводу цены продукта
    {
        return coldDrink.getPrice();
    }

    public int printChangeTheRemainingDrinks(ColdDrink coldDrink) //метод по выводу остатка продуктов
    {
        return coldDrink.getColdDrinkAmount();
    }
    
    public void changeDrinkVolume(ColdDrink coldDrink) //метод по уменьшению продуктов в автомате после покупки
    {
        coldDrink.setColdDrinkAmount(coldDrink.getColdDrinkAmount() - 1);
    }

}
