package com.project;

import java.util.Scanner;
import java.util.Set;

public class Application {

        public void handleUserSelection(int option){
            UserInterface userInterface = UserInterface.getInstance();
            SweetRepository sweetRepository = SweetRepository.getInstance();
            Set sweetList = sweetRepository.getSweetList();

            switch (option){
                case 1:
                    Sweet sweet = addSweet();
                    sweetRepository.add(sweet);
                    break;
                case 2:
                    Scanner input = new Scanner(System.in);
                    System.out.println("Enter Sweet Name: ");
                    String sweetName = input.nextLine();
                    Sweet deleteSweet = sweetRepository.getSweet(sweetName);
                    sweetRepository.delete(deleteSweet);
                    break;
                case 3 :
                    editSweet();
                    break;
                case 4:
                    System.out.println("Diet Sweet: ");
                    userInterface.print(sweetList);
                    break;
                case 5:
                    System.out.println("Normal Sweet : ");
                    userInterface.printDietSweets(sweetList);
                    break;
                case 6:
                    System.out.println("All Sweet : ");
                    userInterface.printNormalSweets(sweetList);
                    break;
                case 7:
                    System.out.println("Good Bye.....");
                    break;
                default:
                    System.out.println("Invalid Input");
            }

        }

    public Sweet addSweet(){
        Scanner sc = new Scanner(System.in);
        Sweet sweet = new Sweet();
        System.out.println("Enter sweet name : ");
        sweet.name = sc.next();
        System.out.println("Enter Sweet Price : ");
        sweet.price = sc.nextInt();
        System.out.println("Enter Sweet Id : ");
        sweet.id = sc.next();

        System.out.println("Category \nEnter 1 for VEG \nEnter 2 for SUGARLESS \nEnter 3 for GHEE \nEnter 4 for BENGALI_SWEET");
        int getCategory = sc.nextInt();
        switch (getCategory){
            case 1 :
                sweet.category = Sweet.Category.VEG;
                break;
            case 2 :
                sweet.category = Sweet.Category.SUGARLESS;
                break;
            case 3 :
                sweet.category = Sweet.Category.GHEE;
                break;
            case 4 :
                sweet.category = Sweet.Category.BENGALI_SWEET;
                break;
            default:
                System.out.println("Invalid Input");
        }

        System.out.println("Color \nEnter 1 for RED \nEnter 2 for GREEN \nEnter 3 for WHITE \nEnter 4 for GREEN_WHITE");
        int getColor = sc.nextInt();
        switch (getColor){
            case 1 :
                sweet.color = Sweet.Color.RED;
                break;
            case 2 :
                sweet.color = Sweet.Color.GREEN;
                break;
            case 3 :
                sweet.color = Sweet.Color.WHITE;
                break;
            case 4 :
                sweet.color = Sweet.Color.GREEN_WHITE;
                break;
            default:
                System.out.println("Invalid Input");
        }

        System.out.println("Color \nEnter 1 for diet sweet \nEnter 2 for normal sweet");
        int getType = sc.nextInt();
        switch (getType) {
            case 1:
                sweet.propertyType = Sweet.PropertyType.IsDiet;
                break;
            case 2:
                sweet.propertyType = Sweet.PropertyType.IsNormal;
                break;
            default:
                System.out.println("Invalid Input");
        }
        return sweet;
    }

    private void editSweet(){
        SweetRepository sweetRepository = SweetRepository.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sweet name : ");
        String getSweetName = sc.nextLine();
        Sweet editName = sweetRepository.getSweet(getSweetName);
        System.out.println("Enter 1 for edit category \nEnter 2 for color" +
                "\nEnter 3 for price \nEnter 4 for id \nEnter 5 for name");
        int input = sc.nextInt();
        switch (input){
            case 1 :
                System.out.println("Enter 1 for VEG \nEnter 2 for SUGARLESS \nEnter 3 for GHEE \nEnter 4 for BENGALI_SWEET");
                int getCategory = sc.nextInt();
                switch (getCategory){
                    case 1 :
                        editName.category = Sweet.Category.VEG;
                        break;
                    case 2 :
                        editName.category = Sweet.Category.SUGARLESS;
                        break;
                    case 3 :
                        editName.category = Sweet.Category.GHEE;
                        break;
                    case 4 :
                        editName.category = Sweet.Category.BENGALI_SWEET;
                        break;
                    default:
                }
                break;
            case 2 :
                System.out.println("Enter 1 for RED \nEnter 2 for GREEN \nEnter 3 for WHILTE \nEnter 4 for GREEN_WHITE");
                int getColor = sc.nextInt();
                switch (getColor) {
                    case 1:
                        editName.color = Sweet.Color.RED;
                        break;
                    case 2:
                        editName.color = Sweet.Color.GREEN;
                        break;
                    case 3:
                        editName.color = Sweet.Color.WHITE;
                        break;
                    case 4:
                        editName.color = Sweet.Color.GREEN_WHITE;
                        break;
                    default:
                }
                break;
            case 3 :
                editName.price = sc.nextInt();
                break;
            case 4 :
                editName.id = sc.next();
                break;
            case 5 :
                editName.name = sc.next();
                break;
            default:
                System.out.println("Invalid Input");
        }
    }

        public static void main(String[] args) {
            System.out.println("Welcome To Sweet Shop Management System");
            Application application = new Application();
            int option = 0;
            final int EXIT = 7;

            UserInterface userInterface =UserInterface.getInstance();

            while (option != EXIT){
                option = userInterface.showUserMenu();
                application.handleUserSelection(option);
            }
        }
}
