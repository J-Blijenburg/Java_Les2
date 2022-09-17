import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
    public void start()
    {
        ArrayList<Person> personArrayList =  loadAllUsers();
        new Login(personArrayList);
    }
    private ArrayList<Person> loadAllUsers(){

        ArrayList<Person> allUsers = new ArrayList<>();

        //Students
        allUsers.add(new Student(allUsers.size() + 1, "Emma", "Smith", LocalDate.of(1997, 12,4), "IT-02-A", "Emma", "Emma12", Access.Basic, 54,50,66,54));
        allUsers.add(new Student(allUsers.size() + 1, "Jack", "Brown", LocalDate.of(1993,8,7), "IT-02-A", "Jack", "Jack12", Access.Basic,72,68,43,95));
        allUsers.add(new Student(allUsers.size() + 1, "Michael", "Garcia", LocalDate.of(1999,11,1), "IT-02-A", "Michael", "Michael12", Access.Basic,45,71,55,84));
        allUsers.add(new Student(allUsers.size() + 1, "Lisa", "Jones", LocalDate.of(2000,4,29), "IT-02-A", "Lisa", "Lisa12", Access.Basic,98,64,81,72));
        allUsers.add(new Student(allUsers.size() + 1, "John", "Miller", LocalDate.of(2001,10,27), "IT-02-A", "John", "John12", Access.Basic,100,94,99,93));
        allUsers.add(new Student(allUsers.size() + 1, "Linda", "Martinez", LocalDate.of(2002,1,17), "IT-02-A", "Linda", "Linda12", Access.Basic,55,79,81,55));
        allUsers.add(new Student(allUsers.size() + 1, "Richard", "Davis", LocalDate.of(1997,9,22), "IT-02-A", "Richard", "Richard12", Access.Basic,51,64,39,59));
        allUsers.add(new Student(allUsers.size() + 1, "Mark", "Lopez", LocalDate.of(1996,12,9), "IT-02-A", "Mark", "Mark12", Access.Basic,78,98,89,99));
        allUsers.add(new Student(allUsers.size() + 1, "Debora", "Hernandez", LocalDate.of(1995,2,25), "IT-02-A", "Debora", "Debora12", Access.Basic,59,55,67,99));
        allUsers.add(new Student(allUsers.size() + 1, "Rick", "Moore", LocalDate.of(2000,3,16), "IT-02-A", "Rick", "Rick12", Access.Basic,96,87,55,82));

        //Teachers
        allUsers.add(new Teacher(allUsers.size() + 1, "David", "Taylor", LocalDate.of(1965,6,15), "David", "David12", Access.Admin));
        allUsers.add(new Teacher(allUsers.size() + 1, "Sophy", "Anderson", LocalDate.of(1987,1,6), "Sophy", "Sophy12", Access.Admin));
        allUsers.add(new Teacher(allUsers.size() + 1, "James", "Jordon", LocalDate.of(1956,3,19), "James", "James12", Access.Admin));
        allUsers.add(new Teacher(allUsers.size() + 1, "Susan", "Jackson", LocalDate.of(1978,12,25), "Susan", "Susan12", Access.Admin));
        allUsers.add(new Teacher(allUsers.size() + 1, "Mary", "Lee", LocalDate.of(1971,9,4), "Mary", "Mary12", Access.Admin));

        return allUsers;
    }
}