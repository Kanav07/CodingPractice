package DesignPatterns.MVC_Demo.model;

public class Database {
    private static Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }

    private Database() {
    }

    public void connect(){
        System.out.println("Database Connected");
    }

    public void disconnect(){
        System.out.println("Database Disconnected");
    }
}
