package be.intecbrussel.view;

import be.intecbrussel.data.HumanDAO;
import be.intecbrussel.model.Human;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {

    public final static HumanDAO humanDAO = new HumanDAO();

    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the human app");
        System.out.println("You wil be asked to input data of a human\n");

        System.out.println("First Name?");
        String name = scanner.nextLine();

        System.out.println("Last name?");
        String lastname = scanner.nextLine();

        System.out.println("Gender?");
        String gender = scanner.nextLine();

        Human human = new Human(name,lastname,gender);

        try {
            humanDAO.saveHuman(human);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }

        scanner.close();
    }

    public static void displayAllExistingHumans(){
        try{
            List<Human> humanList = humanDAO.getAllHumans();
            humanList.forEach(System.out::println);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public static void login(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Login:");

        System.out.println("Enter URL");
        String url = scanner.nextLine();

        System.out.println("Enter port");
        String port = scanner.nextLine();

        System.out.println("Enter database");
        String db = scanner.nextLine();

        System.out.println("Enter username");
        String username = scanner.nextLine();

        System.out.println("Enter password");
        String password = scanner.nextLine();

        humanDAO.setConfig(String.format("jdbc:mysql://‰s:‰s/‰s",url,port,db),username,password);


    }

}
