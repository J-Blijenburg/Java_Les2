import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Person userLoggedIn;
    private ArrayList<Person> personArrayList;
    private int studentNumber;
    public Menu(Person userLoggedIn, ArrayList<Person> personArrayList){
        this.personArrayList = personArrayList;
        this.userLoggedIn = userLoggedIn;
        displayMenu();
    }
    private void displayMenu(){
        switch(userLoggedIn.access) {
            case Basic:
                displayMenuBasic();
                break;
            case Editor:
                displayMenuEditor();
                break;
            case Admin:
                displayMenuAdmin();
                break;
        }
    }
    private void displayMenuBasic(){
        System.out.println();
        System.out.println("S. Display Students | T. Display Teachers | X. Exit |");
        System.out.println();
        System.out.print("Please, enter a choice: ");
        switch(scanner.nextLine()){
            case "s":
                displayStudentList();
                break;
            case "t":
                displayTeacherList();
                break;
            case "x":
                System.out.println();
                System.out.println("Leaving the program now ...");
                System.exit(0);
        }
        displayMenuBasic();
    }

    private void displayMenuEditor(){
        Scanner editorScanner = new Scanner(System.in);
        System.out.println();
        System.out.println("S. Display Students | T. Display Teachers | A. Add Students | R. Display Reports | X. Exit |");
        System.out.println();
        System.out.print("Please, enter a choice: ");
        String userInput = editorScanner.nextLine();
        switch(userInput) {
            case "s":
                displayStudentList();
                break;
            case "t":
                displayTeacherList();
                break;
            case "a":
                addStudent();
                break;
            case "r":
                displayReports();
                studentReportCard();
                menuReportCard();
                break;
            case "x":
                System.out.println();
                System.out.println("Leaving the program now ...");
        }
        displayMenuEditor();
}
    private void displayMenuAdmin(){
        Scanner adminScanner = new Scanner(System.in);
        System.out.println();
        System.out.println("S. Display Students | T. Display Teachers | A. Add Students | R. Display Reports | V. Remove students | P. Add teachers | U. Remove teachers | X. Exit |");
        System.out.println();
        System.out.print("Please, enter a choice: ");
        String userInput = adminScanner.nextLine();
        switch(userInput) {
            case "s":
                displayStudentList();
                break;
            case "t":
                displayTeacherList();
                break;
            case "a":
                addStudent();
                break;
            case "r":
                displayReports();
                studentReportCard();
                menuReportCard();
                break;
            case "v":
                removeStudent();
                break;
            case "p":
                addTeacher();
                break;
            case "u":
                removeTeacher();
                break;
            case "x":
                System.out.println();
                System.out.println("Leaving the program now ...");
        }
        displayMenuAdmin();
    }

    private void displayStudentList(){
        System.out.println("");
        System.out.println("LIST OF STUDENTS");
        System.out.println("");
        System.out.println("ID     FirstName     LastName     Birthdate     Age     Group     ");
        System.out.println("**     *********     ********     *********     ***     *****     ");
        for(Person person : personArrayList){
            if(person instanceof Student){
                person.displayPerson();
            }
        }
    }
    private void displayTeacherList(){
        System.out.println("");
        System.out.println("LIST OF Teachers");
        System.out.println("");
        System.out.println("ID     FirstName     LastName     Birthdate     Age");
        System.out.println("**     *********     ********     *********     ***");
        for(Person person : personArrayList){
            if(person instanceof Teacher){
                person.displayPerson();
            }
        }
    }
    private void addStudent(){
        System.out.println("");
        System.out.println("ADD Student");
        System.out.println("");
        String userName = stringQuestion("Choose a username: ");
        String passWord = stringQuestion("" + "Choose a password: ");
        String firstName = stringQuestion("" + "Enter first name: ");
        String lastName = stringQuestion("" + "Enter last name: ");
        LocalDate dateOfBirth = LocalDate.parse((stringQuestion("" + "Please enter date of birth in YYYY-MM-DD: ")));
        String group = stringQuestion("" + "Enter group: ");
        personArrayList.add(new Student( personArrayList.size() + 1, firstName, lastName, dateOfBirth,  group, userName, passWord, Access.Basic,0,0,0,0));
        System.out.println("\n" + "The data was successfully added!");
    }
    private String stringQuestion(String question){
        System.out.print(question);
        return scanner.nextLine();
    }

    private void displayReports(){
        System.out.println("");
        System.out.println("STUDENTS RESULTS");
        System.out.println("");
        System.out.println("ID     FirstName     LastName     Birthdate     Age     Group     Java     CSharp     Python     PHP     ");
        System.out.println("**     *********     ********     *********     ***     *****     ****     ******     ******     ***     ");
        for(Person person : personArrayList){
            if(person instanceof Student){
                ((Student) person).displayStudentReport();
            }
        }
    }
    private void studentReportCard(){
        System.out.println("");
        System.out.println("Enter student id (Report Details) | Or 0 back to main menu: ");
        studentNumber = scanner.nextInt();
        for(Person person : personArrayList){
            if(person instanceof Student && person.id == studentNumber){
                ((Student) person).studentReportCard();
            }
        }
    }
    private void menuReportCard(){
        System.out.println("");
        System.out.println("A. Add (Update) Report | R. Display Reports | B. Back to main | X. Exit |");
        System.out.println("");
        System.out.print("Please, enter a choice: ");
        chooseOption();
    }
    private void chooseOption(){
        Boolean backToMain = false;
        do{
            Scanner newScanner = new Scanner(System.in);
            System.out.print("Select a menu:  ");
            switch(newScanner.nextLine()) {
                case "a":
                    Student student = (Student) personArrayList.get(studentNumber - 1);
                    student.updateReportCard();
                    break;
                case "r":
                    System.out.println();
                    System.out.println("display Report ..................");
                    System.out.println();
                    displayReports();
                    break;
                case "b":
                    backToMain = true;
                    break;
                case "x":
                    System.out.println();
                    System.out.println("Leaving the program now ...");
                    System.exit(0);

            }
        }
        while(backToMain.equals(false));
    }
    private void removeStudent(){
        Scanner removeStudentScanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Remove a student from the system");
        System.out.println("");
        System.out.print("Enter student id: ");
        int studentNumber = Integer.parseInt(removeStudentScanner.nextLine());
        personArrayList.remove(studentNumber - 1);
        System.out.println("Student has been removed!");
    }
    private void addTeacher(){
        System.out.println("");
        System.out.println("ADD Teacher");
        System.out.println("");
        String userName = stringQuestion("Choose a username: ");
        String passWord = stringQuestion("" + "Choose a password: ");
        String firstName = stringQuestion("" + "Enter first name: ");
        String lastName = stringQuestion("" + "Enter last name: ");
        LocalDate dateOfBirth = LocalDate.parse((stringQuestion("" + "Please enter date of birth in YYYY-MM-DD: ")));
        personArrayList.add(new Teacher( personArrayList.size() + 1, firstName, lastName, dateOfBirth, userName, passWord, Access.Editor));
        System.out.println("\n" + "The data was successfully added!");
    }
    private void removeTeacher(){
        Scanner removeTeacherScanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Remove a teacher from the system");
        System.out.println("");
        System.out.print("Enter teacher id: ");
        int teacherNumber = Integer.parseInt(removeTeacherScanner.nextLine());
        personArrayList.remove(teacherNumber - 1);
        System.out.println("teacher has been removed!");
    }
}
