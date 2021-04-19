package homework2.randomAddPeoples;

import com.github.javafaker.Faker;
import homework2.Person.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RandomGeneratePeople {

    public static ArrayList<Person> personArrayList = new ArrayList<>();

    public static void randomGeneratePeople(int howMatch) {

        try (FileWriter writer = new FileWriter("C:\\Users\\HP\\Desktop\\PDF folder\\PersonDataBase.csv")) {
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("Name", "Surname", "Phone", "Address", "Id"));

            Faker faker = new Faker();


            for (int i = 1; i <= howMatch; i++) {
                Person person = new Person(faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().phoneNumber(),
                        faker.address().fullAddress(),
                        i);
                personArrayList.add(person);
                printer.printRecord(person.getName(), person.getSurname(), person.getPhone(), person.getAddress(), person.getId());
            }

            printer.flush();
            printer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
