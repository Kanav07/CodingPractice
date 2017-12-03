package DesignPatterns.MVC_Demo.controller;

import DesignPatterns.MVC_Demo.model.Model;
import DesignPatterns.MVC_Demo.view.LoginFormEvent;
import DesignPatterns.MVC_Demo.view.LoginListener;
import DesignPatterns.MVC_Demo.view.View;

public class Controller implements LoginListener {

    private View view;
    private Model model;

    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void loginPerformed(LoginFormEvent loginFormEvent) {
        System.out.println("Login event recieved with name:" + loginFormEvent.getName() + " password:" + loginFormEvent.getPassword());
    }
}
