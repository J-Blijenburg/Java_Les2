import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Display {
    private Scanner scanner = new Scanner(System.in);
    private int studentNumber;
    protected ArrayList<Person> personArrayList;
    public Display(ArrayList<Person> personArrayList){
        this.personArrayList = personArrayList;
    }
    protected abstract void displayMenu();
    protected void displayStudentList(){
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

    protected void displayTeacherList(){
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
    protected void addStudent(){
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
    protected void displayReports(){
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
    protected void studentReportCard(){
        System.out.println("");
        System.out.println("Enter student id (Report Details) | Or 0 back to main menu: ");
        studentNumber = scanner.nextInt();
        for(Person person : personArrayList){
            if(person instanceof Student && person.id == studentNumber){
                ((Student) person).studentReportCard();
            }
        }
    }
    protected void menuReportCard(){
        System.out.println("");
        System.out.println("A. Add (Update) Report | R. Display Reports | B. Back to main | X. Exit |");
        System.out.println("");
        System.out.print("Please, enter a choice: ");
        chooseOption();
    }
    protected void chooseOption(){
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
    protected void removeStudent(){
        Scanner removeStudentScanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("Remove a student from the system");
        System.out.println("");
        System.out.print("Enter student id: ");
        int studentNumber = Integer.parseInt(removeStudentScanner.nextLine());
        personArrayList.remove(studentNumber - 1);
        System.out.println("Student has been removed!");
    }
    protected void addTeacher(){
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
    protected void removeTeacher(){
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
