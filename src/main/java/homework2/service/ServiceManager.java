package homework2.service;

import com.github.javafaker.Faker;
import homework2.Person.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static homework2.randomAddPeoples.RandomGeneratePeople.personArrayList;

public class ServiceManager {

    private void updateFileFromArray() {

        try (FileWriter writer = new FileWriter("C:\\Users\\HP\\Desktop\\PDF folder\\PersonDataBase.csv")) {
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("Name", "Surname", "Phone", "Address", "Id"));

            List<String> peopleNames = personArrayList.stream()
                    .map(Person::getName)
                    .collect(Collectors.toList());

            List<String> peopleSurnames = personArrayList.stream()
                    .map(Person::getSurname)
                    .collect(Collectors.toList());

            List<String> peoplesPhones = personArrayList.stream()
                    .map(Person::getPhone)
                    .collect(Collectors.toList());

            List<String> peoplesAddress = personArrayList.stream()
                    .map(Person::getAddress)
                    .collect(Collectors.toList());

            List<Integer> peoplesId = personArrayList.stream()
                    .map(Person::getId)
                    .collect(Collectors.toList());

            for (int i = 0; i < personArrayList.size(); i++) {
                printer.printRecord(peopleNames.get(i), peopleSurnames.get(i), peoplesPhones.get(i), peoplesAddress.get(i), peoplesId.get(i));
            }

            printer.flush();
            printer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createNewPerson() {
        try (FileWriter writer = new FileWriter("C:\\Users\\HP\\Desktop\\PDF folder\\PersonDataBase.csv", true)) {
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);

            Faker faker = new Faker();
            Person person = new Person(faker.name().firstName(),
                    faker.name().lastName(),
                    faker.phoneNumber().phoneNumber(),
                    faker.address().fullAddress(),
                    personArrayList.size() + 1);
            personArrayList.add(person);
            printer.printRecord(person.getName(), person.getSurname(), person.getPhone(), person.getAddress(), person.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readPersonInformation(int id) {
        System.out.println(personArrayList.get(id - 1));
    }

    public void updatePersonInformation(int id, Person person) {

        person.setId(id);
        personArrayList.remove(id - 1);
        personArrayList.add(id - 1, person);
        updateFileFromArray();

    }

    public void deletePerson(int id) {

        personArrayList.remove(id - 1);
        updateFileFromArray();

    }

}
