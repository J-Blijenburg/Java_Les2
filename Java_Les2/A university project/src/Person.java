import java.time.LocalDate;


public abstract class Person {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected LocalDate birthdate;
    protected int age;
    protected String userName;
    protected String passWord;
    protected Access access;

    public Person(int id, String firstName, String lastName, LocalDate birthdate, String userName, String passWord, Access access){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.age =  LocalDate.now().getYear() - birthdate.getYear();
        this.userName = userName;
        this.passWord = passWord;
        this.access = access;
    }
    protected abstract void displayPerson();
}
