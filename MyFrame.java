import java.awt.Container;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame
{
    public MyFrame()
    {
        super("VendingMachine");
        super.setBounds(0, 0, 1000 , 300);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 5, 2, 2));

        JLabel label1 = new JLabel("Вас приветствует аппарат по продаже холодных и горячих напитков! Нажмите нужную кнопку: ");

        JTextField textField2 = new JTextField("", 1);

        JButton button1 = new JButton("Холодные напитки", null);
        JButton button2 = new JButton("Горячие напитки", null);
        JButton button9 = new JButton("Проверка заполненности автомата", null);

        container.add(label1);
        container.add(textField2);
        container.add(button1);
        container.add(button2);
        container.add(button9);

        //button1.addActionListener();

    }
}
