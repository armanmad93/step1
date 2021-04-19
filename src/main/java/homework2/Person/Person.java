package homework2.Person;

public class Person {

    String name;
    String surname;
    String phone;
    String address;
    int id;

    public Person(String name, String surname, String phone, String address, int id) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.id = id;
    }

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name + " " + surname + "\n" +
                "Phone: " + phone + "\n" +
                "Address: " + address + "\n" +
                "ID: " + id;
    }
}
