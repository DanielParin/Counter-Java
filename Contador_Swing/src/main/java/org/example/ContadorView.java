package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ContadorView extends JFrame {

    public ContadorView(){
        initComponents();

    }

    private void initComponents() {


        var buttonPlus = new JButton("+");
        var buttonMinus = new JButton("-");
        var teclado = new JPanel();
        int[] numero = {0};
        var pantalla = new JLabel(""+numero[0]);

        pantalla.setHorizontalAlignment(SwingConstants.CENTER);//Centra el Label

        //Cambiar el tamaño de la fuente
        Font font = pantalla.getFont().deriveFont(Font.PLAIN,30);
        pantalla.setFont(font);
        buttonPlus.setFont(font);
        buttonMinus.setFont(font);

        this.setLayout(new GridLayout(2,1));
        teclado.setLayout(new GridLayout(1,2));

        teclado.add(buttonMinus);
        teclado.add(buttonPlus);
        this.add(pantalla);
        this.add(teclado);


        buttonPlus.addActionListener(e -> {
            numero[0]++;
            pantalla.setText("" + numero[0]);
        });

        buttonMinus.addActionListener(e -> {
            numero[0]--;
            pantalla.setText("" + numero[0]);
        });


        pack();// pack() va siempre antes de poner el tamaño.

        //Cambiar el icono de la app
        String projectDirectory = System.getProperty("user.dir");
        String imgRoute = (projectDirectory+ File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"images"+File.separator+"contador.png");
        ImageIcon iconApp = new ImageIcon(imgRoute);
        Image icon = iconApp.getImage();
        this.setIconImage(icon);

        this.setTitle("CONTADOR");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);//Centrar en la pantalla
        pantalla.setLocation(250,250);
    }
}
