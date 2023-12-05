class Person {
/*Побудувати ієрархію класів відповідно до варіанта завдання. Згідно
завдання вибрати суперклас (базовий клас) та підкласи (похідні класи). В класах
задати поля, які характерні для кожного класу. Для всіх класів розробити метод
Show(), який виводить дані про об’єкт класу. Розробити програму, яка вводить
інформацію про об’єкти заданих сутностей згідно варіанту в масив типу
суперкласу та друкує введений масив (з використанням методу Show() ) .
 2. Службовець, персона, робітник, інженер.  */
private String firstName;
    private String lastName;
    private int age;
    private String address;

    public Person(String firstName, String lastName, int age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public void Show() {
        System.out.println("Name: " + firstName);
        System.out.println("Lastname: " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}

class Worker extends Person {
    private String position;
    private double salary;

    public Worker(String firstName, String lastName, int age, String address, String position, double salary) {
        super(firstName, lastName, age, address);
        this.position = position;
        this.salary = salary;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary);
    }
}
class Engineer extends Person {
    private String specialization;
    private String qualificationLevel;

    public Engineer(String firstName, String lastName, int age, String address, String specialization, String qualificationLevel) {
        super(firstName, lastName, age, address);
        this.specialization = specialization;
        this.qualificationLevel = qualificationLevel;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Specialization: " + specialization);
        System.out.println("Qualification: " + qualificationLevel);
    }
}
public class Task1 {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Worker("Igor", "Semeniv", 30, "Odessa", "Master", 2500);
        people[1] = new Engineer("Maria", "Pronina", 25, "Ternopil", "Engineer", "The highest");
        people[2] = new Person("Oleg", "Horodynskiy", 40, "Chernivtsi");

        for (Person person : people) {
            person.Show();
            System.out.println();
        }
    }
}
