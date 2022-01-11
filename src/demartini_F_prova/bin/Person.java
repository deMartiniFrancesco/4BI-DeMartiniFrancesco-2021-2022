package demartini_F_prova.bin;

// Class Declaration

public class Person {
    // Instance Variables
    final String name;
    final String surname;
    final int age;
    final String sex;

    // Constructor Declaration of Class
    public Person(String name, String surname,
                  int age, String sex) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Bil", "Gates", 50, "male");
        System.out.println(p1);

    }

    // method 1
    public String getName() {
        return name;
    }

    // method 2
    public String getSurname() {
        return surname;
    }

    // method 3
    public int getAge() {
        return age;
    }

    // method 4
    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return ("name " + this.getName() +
                "\nsurname " + this.getSurname() +
                "\nage " + this.getAge() +
                "\ncolor " + this.getSex());
    }
}
