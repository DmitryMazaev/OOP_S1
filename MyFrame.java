/* import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

        
        button1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {

                textField2.setText("Вы выбрали холодный напиток");
            }
        });

        button2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField2.setText("Вы выбрали горячий напиток");
            }
        });

        button9.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField2.setText("Вы работник обслуживающей организции и хотите проверить автомат");
            }
        });

    }
} */
