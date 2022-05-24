package demartini_F_prova.bin;

// Class Declaration

public record Person(String name, String surname, int age, String sex) {
    // Constructor Declaration of Class

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
