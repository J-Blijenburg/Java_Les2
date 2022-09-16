import java.util.ArrayList;
import java.util.Scanner;

public class DisplayAdmin extends Display{
    public DisplayAdmin(ArrayList<Person> personArrayList) {
        super(personArrayList);
    }

    protected void displayMenu() {
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
        displayMenu();
    }
}
