import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
    public void start()
    {
        ArrayList<Person> personArrayList =  new Users().loadAllUsers();
        new Login(personArrayList);
    }
}