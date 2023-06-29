public class HotDrink extends Product
{
    private int volume;
    private int temperature;
    private int doseCofe;
    private int doseShugar;
    
    public HotDrink(String productName, String productCategory, double productPrice, int volume, int temperature, int doseCofe, int doseShugar) throws Exception 
    {
        super(productName, productCategory, productPrice);
        this.volume = volume;
        this.temperature = temperature;
        this.doseCofe = doseCofe;
        this.doseShugar = doseShugar;
    }

    public void setVolume(int volume) 
    {
        this.volume = volume;
    }

    public int getVolume() 
    {
        return volume;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getDoseCofe() {
        return doseCofe;
    }

    public int getDoseShugar() {
        return doseShugar;
    }
    
    @Override
    public String toString()
    {
        return "Напиток " + super.getproductName() + " из категории " + super.getCategory() + " объемом " + volume + " мл "+ "t = " + temperature + " стоимостью " + super.getPrice() + " рублей";
    }

    @Override
    public String toStringTo()
    {
        return super.getproductName() + " Стоимостью " + super.getPrice() + " рублей. ";
    }
}