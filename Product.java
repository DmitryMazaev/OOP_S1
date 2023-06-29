public class Product
{
    private String productName;
    private String productCategory;
    private double productPrice;

    public Product (String productName, String productCategory, double productPrice)
    {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
    }

    public String getproductName() 
    {
        return productName;
    }

    public String getCategory() 
    {
        return productCategory;
    }

    public double getPrice() 
    {
        return productPrice;
    }

    public void setPrice(double productPrice) 
    {
        if (productPrice <= 0)
        {
            throw new IllegalStateException(String.format("Цена указана некорректно!", productPrice));
        }
        this.productPrice = productPrice;
    }
    
    @Override
    public String toString()
    {
        return "Продукт " + productName + " из категории " + productCategory + " стоимостью " + productPrice + " рублей";
    }

    public String toStringTo()
    {
        return null;
    }

}