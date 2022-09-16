import java.util.ArrayList;
import java.util.Scanner;

public class DisplayEditor extends Display{
    public DisplayEditor(ArrayList<Person> personArrayList) {
        super(personArrayList);
    }

    protected void displayMenu() {
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
        displayMenu();
    }
}
