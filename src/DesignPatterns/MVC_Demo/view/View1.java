package DesignPatterns.MVC_Demo.view;

import DesignPatterns.MVC_Demo.model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View1 extends JFrame implements ActionListener {

    private Model model;
    private JButton helloButton;
    private JButton goodbyeButton;


    public View1(Model model) throws HeadlessException {
        super("MVC Demo");
        this.model = model;

        //create components
        helloButton = new JButton("Hello");
        goodbyeButton = new JButton(("Goodbye"));

        setLayout(new GridBagLayout());


        //This code positions the application window on the screen
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 1;
        gc.gridy=1;
        gc.weightx=1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        //add components to the window
        add(helloButton,gc);

        gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.CENTER;
        gc.gridx = 1;
        gc.gridy=2;
        gc.weightx=1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;

        add(goodbyeButton,gc);

        //initialise Observer Pattern - The "Subject" ( here the hellobutton)
        helloButton.addActionListener(this);
        goodbyeButton.addActionListener(this);
        goodbyeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Sorry to see you go!");
            }
        });
        //this code actually creates the mainframe of the UIR
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        JButton source = (JButton) actionEvent.getSource();

        if(source ==helloButton) {
            System.out.println("Hello There!");
        }
        else{
            System.out.println("Other Button");
        }
    }
}
