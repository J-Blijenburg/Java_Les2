import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Person> personArrayList;
    public Login(ArrayList<Person> personArrayList){
        this.personArrayList = personArrayList;
        checkLogin();
    }

    public void checkLogin(){
        Boolean loggedIn = false;
     do{
         String userName = askQuestion("Enter username: ");
         String passWord = askQuestion("Enter password: ");

         for(Person person : personArrayList){
             if(person.userName.equals(userName) && person.passWord.equals(passWord)) {
                 displayMenu(person);
                 loggedIn = true;
             }
         }
     }while(loggedIn.equals(true));
    }
    private String askQuestion(String question){
        System.out.print(question);
        return scanner.nextLine();
    }
    private void displayMenu(Person person){
        switch(person.access) {
            case Basic:
                new DisplayBasic(personArrayList).displayMenu();
                break;
            case Editor:
                new DisplayEditor(personArrayList).displayMenu();
                break;
            case Admin:
                new DisplayAdmin(personArrayList).displayMenu();
                break;
        }
    }
}
