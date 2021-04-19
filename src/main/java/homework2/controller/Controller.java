package homework2.controller;

import homework2.Person.Person;
import homework2.service.ServiceManager;

import java.util.Scanner;

import static homework2.randomAddPeoples.RandomGeneratePeople.personArrayList;

public class Controller {

    public void startProgramControl() {

        Scanner scanner = new Scanner(System.in);
        int id;
        boolean variable = true;

        ServiceManager service = new ServiceManager();

        System.out.println("**********************************");
        System.out.println("********** HELLO MASTER **********");
        System.out.println("**********************************");


        while (variable) {

            System.out.println();
            System.out.println("Press 1 for create new random people in catalog.");
            System.out.println("Press 2 for print information about people from catalog.");
            System.out.println("Press 3 for update information about people in catalog.");
            System.out.println("Press 4 for delete people in catalog.");
            System.out.println("Press 5 for write all information about people in catalog to console.");
            System.out.println("Press 6 for EXIT!!!");
            System.out.println();

            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Congratulations you create new person in catalog.");
                    System.out.println();
                    service.createNewPerson();
                }
                case 2 -> {
                    System.out.print("Please enter ID witch person information you want to see in console. ID -> ");
                    id = scanner.nextInt();
                    if (id <= personArrayList.size()) {
                        System.out.println("Information of the person what you want is written in the console.");
                        System.out.println("***************************************************************** " + "\n");
                        service.readPersonInformation(id);
                    } else {
                        System.out.println("This ID does not exist. Please try again Master!");
                    }
                }
                case 3 -> {
                    System.out.print("Please enter ID witch person information you want to update. ID -> ");
                    id = scanner.nextInt();
                    if (id <= personArrayList.size()) {

                        System.out.print("Name: ");
                        String name = scanner.next();

                        System.out.print("Surname: ");
                        String surname = scanner.next();

                        System.out.print("Phone: ");
                        String phone = scanner.next();

                        System.out.print("Address: ");
                        String address = scanner.next();

                        service.updatePersonInformation(id, new Person(name, surname, phone, address));
                        System.out.println("Congratulations information about this person is update in catalog.");
                        System.out.println();
                    } else {
                        System.out.println("This ID does not exist. Please try again Master!");
                    }
                }
                case 4 -> {
                    System.out.print("Please enter ID witch person information you want to delete. ID -> ");
                    id = scanner.nextInt();
                    if (id <= personArrayList.size()) {
                        System.out.println("Congratulations information about this person is deleted in catalog.");
                        System.out.println();
                        service.deletePerson(id);
                    } else {
                        System.out.println("This ID does not exist. Please try again Master!");
                    }
                }
                case 5 -> {
                    System.out.println("Congratulations all information in catalog is written in the console.");
                    System.out.println();
                    personArrayList.forEach(System.out::println);
                }
                case 6 -> {
                    System.out.println("EXIT!!!");
                    variable = false;
                }
                default -> System.out.println("sometimes is wrong please try again MASTER.");
            }

        }

    }
}
