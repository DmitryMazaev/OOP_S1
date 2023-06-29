import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        VendingMachine vendingMachine = new VendingMachine(100);
        CofeMachine cofeMachine = new CofeMachine(50, 100, 1000, 100);

        vendingMachine.addProduct(1, new ColdDrink("Тархун", "Напиток газированный", 50, 500, 2));
        vendingMachine.addProduct(2, new ColdDrink("Колокольчик", "Напиток газированный", 45, 500, 10));
        vendingMachine.addProduct(3, new ColdDrink("Усполонь", "Вода негазированная", 25, 500, 15));
        vendingMachine.addProduct(4, new ColdDrink("Кока-Кола", "Напиток газированный", 70, 500, 14));
        
        cofeMachine.addHotDrink(25, new HotDrink("Капучино", "Кофе", 100, 120, 95, 10, 10));
        cofeMachine.addHotDrink(26, new HotDrink("Американо", "Кофе", 120, 100, 100, 12, 0));
        cofeMachine.addHotDrink(27, new HotDrink("Эспрессо", "Кофе", 130, 80, 100, 11, 6));

        Scanner in = new Scanner(System.in);

        MyFrame myFrame = new MyFrame();
        myFrame.setVisible(true);
        
            double vendingMachineCash = 0; //Общее количество денег в автомате
            while (true)
            {
                System.out.println("Вас приветствует автомат с холодными и горячими напитками! Выберите нужную опцию: ");
                System.out.println("1 - Холодный напиток, 2 - Горячий напиток, 9 - Проверка заполненности автомата (для обслуживающей организации)");
                int choose = in.nextInt();
                if (choose == 9)
                {
                    System.out.println("-------------");
                    System.out.println("Холодные напитки: ");
                    for(int prod: vendingMachine.getProducts().keySet())
                    {
                        
                        System.out.println(vendingMachine.getProducts().get(prod).toString());
                        
                        
                    }
                    System.out.println("-------------");
                    System.out.println("Горячие напитки: ");
                    System.out.println("Стаканчиков осталось: " + cofeMachine.getCupAmount() + " штук");
                    System.out.println("Сахара осталось: " + cofeMachine.getShugarAmount() + " грамм");
                    System.out.println("Горячей воды осталось: " + cofeMachine.getBoiledWater() + " милилитров");
                    System.out.println("Кофе осталось: " + cofeMachine.getCofeAmount() + " грамм");
                    
                    System.out.println("-------------");
                    int sumDrinks = 0;
                        for(int prod: vendingMachine.getProducts().keySet())
                        {
                            sumDrinks = sumDrinks + vendingMachine.printChangeTheRemainingDrinks(vendingMachine.getProducts().get(prod));
                        }  

                    
                    System.out.println("Продуктов в аппарате: " + sumDrinks + " штук");
                    System.out.println("Можно загрузить: " + (vendingMachine.getVolume() - sumDrinks) + " штук");
                    System.out.println("Денег в автомате: " + vendingMachineCash + " рублей");
                    System.out.println("-------------");
                }

                if (choose == 1)
                {
                    System.out.println("-------------");
                    System.out.println("Выберите напиток: ");

                    for(int prod: vendingMachine.getProducts().keySet())
                    {
                        if (vendingMachine.printChangeTheRemainingDrinks(vendingMachine.getProducts().get(prod)) > 0)
                        {
                            System.out.println(prod + " " +vendingMachine.getProducts().get(prod).toStringTo());
                        }
                        
                    }

                    choose = in.nextInt();

                    if (vendingMachine.printChangeTheRemainingDrinks(vendingMachine.getProducts().get(choose)) > 0)

                    {
                        System.out.println("-------------");

                        for(int prod: vendingMachine.getProducts().keySet())
                        {
                            if (prod == choose)
                            {
                                System.out.println("Вы выбрали " + vendingMachine.getProducts().get(prod).toStringTo());
                            }
                        }

                        System.out.print("Внесите " + vendingMachine.printPrice(vendingMachine.getProducts().get(choose)) + " рублей: ");

                        double depositedMoney = 0; //внесенные деньги
                        double sumDepositedMoney = 0; //сумма внесенных денег
                        double changeMoney = 0; //сдача
                        while (sumDepositedMoney < vendingMachine.printPrice(vendingMachine.getProducts().get(choose))) //Цикл: вносим деньги, пока их количество не будет больше или равно стоимости напитка
                        {
                            depositedMoney = in.nextInt();
                            if (depositedMoney > 0)
                            {
                                sumDepositedMoney = sumDepositedMoney + depositedMoney;
                                if (sumDepositedMoney < vendingMachine.printPrice(vendingMachine.getProducts().get(choose)))
                                {
                                    System.out.printf("Вы внесли %f рублей, внесите еще %f рублей: ", sumDepositedMoney, vendingMachine.printPrice(vendingMachine.getProducts().get(choose))-sumDepositedMoney);
                                    
                                }
                                else
                                {
                                    System.out.printf("Вы внесли %f рублей ", sumDepositedMoney);
                                    System.out.println();
                                    System.out.println("-------------");
                                }
                            }
                            else
                            {
                                System.out.println("Введено некорректное значение, попробуйте еще раз:");
                            }
                        }
                        changeMoney = sumDepositedMoney - vendingMachine.printPrice(vendingMachine.getProducts().get(choose)); //расчет сдачи

                        vendingMachine.changeDrinkVolume(vendingMachine.getProducts().get(choose));//метод по изменению количества продуктов в автомате

                        System.out.println("Заберите напиток ");
                        System.out.printf("Заберите сдачу: %f рублей", changeMoney);
                        System.out.println();
                        System.out.println("-------------");
                        vendingMachineCash = vendingMachineCash + vendingMachine.printPrice(vendingMachine.getProducts().get(choose));
                    }

                }
                
                if (choose == 2)
                {
                    System.out.println("-------------");
                    System.out.println("Выберите напиток: ");

                    for(int prod: cofeMachine.getHotDrinks().keySet())
                    {
                        if (cofeMachine.getBoiledWater() > 0 && cofeMachine.getCofeAmount() >0 && cofeMachine.getCupAmount() > 0 && cofeMachine.getShugarAmount() > 0)
                        {
                            System.out.println(prod + " " +cofeMachine.getHotDrinks().get(prod).toStringTo());
                        }
                        
                    }

                    choose = in.nextInt();

                    System.out.println("-------------");

                    for(int prod: cofeMachine.getHotDrinks().keySet())
                    {
                        if (prod == choose)
                        {
                            System.out.println("Вы выбрали " + cofeMachine.getHotDrinks().get(prod).toStringTo());
                        }
                    }

                    System.out.print("Внесите " + cofeMachine.printPrice(cofeMachine.getHotDrinks().get(choose)) + " рублей: ");

                    double depositedMoney = 0; //внесенные деньги
                    double sumDepositedMoney = 0; //сумма внесенных денег
                    double changeMoney = 0; //сдача

                    while (sumDepositedMoney < cofeMachine.printPrice(cofeMachine.getHotDrinks().get(choose))) //Цикл: вносим деньги, пока их количество не будет больше или равно стоимости напитка
                        {
                            depositedMoney = in.nextInt();
                            if (depositedMoney > 0)
                            {
                                sumDepositedMoney = sumDepositedMoney + depositedMoney;
                                if (sumDepositedMoney < cofeMachine.printPrice(cofeMachine.getHotDrinks().get(choose)))
                                {
                                    System.out.printf("Вы внесли %f рублей, внесите еще %f рублей: ", sumDepositedMoney, cofeMachine.printPrice(cofeMachine.getHotDrinks().get(choose))-sumDepositedMoney);
                                    
                                }
                                else
                                {
                                    System.out.printf("Вы внесли %f рублей ", sumDepositedMoney);
                                    System.out.println();
                                    System.out.println("-------------");
                                }
                            }
                            else
                            {
                                System.out.println("Введено некорректное значение, попробуйте еще раз:");
                            }
                        }
                        changeMoney = sumDepositedMoney - cofeMachine.printPrice(cofeMachine.getHotDrinks().get(choose)); //расчет сдачи

                        cofeMachine.changeCupAmount(cofeMachine.getHotDrinks().get(choose));  //метод по изменению количества стаканчиков в автомате
                        cofeMachine.changeShugarAmount(cofeMachine.getHotDrinks().get(choose)); //метод по изменению сахара в автомате
                        cofeMachine.changeBoiledWater(cofeMachine.getHotDrinks().get(choose)); //метод по изменению количества воды в автомате
                        cofeMachine.changeCofeAmount(cofeMachine.getHotDrinks().get(choose)); //метод по изменению количества кофе в автомате
                        

                        System.out.println("Заберите напиток ");
                        System.out.printf("Заберите сдачу: %f рублей", changeMoney);
                        System.out.println();
                        System.out.println("-------------");
                        vendingMachineCash = vendingMachineCash + cofeMachine.printPrice(cofeMachine.getHotDrinks().get(choose));

                }
                
            }

    }
    
}
