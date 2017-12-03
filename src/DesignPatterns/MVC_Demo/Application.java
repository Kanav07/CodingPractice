package DesignPatterns.MVC_Demo;

import DesignPatterns.MVC_Demo.controller.Controller;
import DesignPatterns.MVC_Demo.model.*;
import DesignPatterns.MVC_Demo.view.View;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                runApp();
            }
        });


    }

    public static  void runApp(){
        //First creating the model, since it is independent of the view1 & controller
        Model model = new Model();

        View view = new View(model);

        Controller controller = new Controller(model, view);

        view.setLoginListener(controller);
    }
}
