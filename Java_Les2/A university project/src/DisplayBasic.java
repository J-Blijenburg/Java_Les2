import java.util.ArrayList;
import java.util.Scanner;

public class DisplayBasic extends Display{
    Scanner scanner = new Scanner(System.in);

    public DisplayBasic(ArrayList<Person> personArrayList){
        super(personArrayList);
    }

    protected void displayMenu() {
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
        displayMenu();

    }

}
