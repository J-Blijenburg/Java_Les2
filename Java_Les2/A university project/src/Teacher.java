import java.time.LocalDate;

public class Teacher extends Person{
    public Teacher(int id, String firstName, String lastName, LocalDate birthdate, String userName, String passWord, Access access){
        super(id, firstName, lastName, birthdate, userName, passWord, access);
    }

    protected void displayPerson() {
        System.out.println(String.format("%-" + 7 + "s", id) + String.format("%-" + 14 + "s", firstName) + String.format("%-" + 13 + "s", lastName) + String.format("%-" + 14 + "s", birthdate) + String.format("%-" + 8 + "s", age));
    }
}
