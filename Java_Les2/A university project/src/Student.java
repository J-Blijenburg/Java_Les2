import java.time.LocalDate;
import java.util.Scanner;

public class Student extends  Person{
    private String group;
    private int java;
    private int cSharp;
    private int python;
    private int pHP;
    private int countRetake = 0;

    public Student(int id, String firstName, String lastName, LocalDate birthdate, String group, String userName, String passWord, Access access, int java, int cSharp, int python, int pHP){
        super(id, firstName, lastName, birthdate, userName, passWord, access);
        this.group = group;
        this.java = java;
        this.cSharp = cSharp;
        this.python = python;
        this.pHP = pHP;
    }

    public void displayPerson() {
        System.out.println(String.format("%-" + 7 + "s", id) + String.format("%-" + 14 + "s", firstName) + String.format("%-" + 13 + "s", lastName) + String.format("%-" + 14 + "s", birthdate) + String.format("%-" + 8 + "s", age) + String.format("%-" + 10 + "s", group));
    }

    public void displayStudentReport(){
        System.out.println(String.format("%-" + 7 + "s", id) +
                String.format("%-" + 14 + "s", firstName) +
                String.format("%-" + 13 + "s", lastName) +
                String.format("%-" + 14 + "s", birthdate) +
                String.format("%-" + 8 + "s", age) +
                String.format("%-" + 10 + "s", group) +
                String.format("%-" + 9 + "s", java) +
                String.format("%-" + 11 + "s", cSharp) +
                String.format("%-" + 11 + "s", python) +
                String.format("%-" + 8 + "s", pHP));
    }

    public void studentReportCard(){
        System.out.println("");
        System.out.println("Report of student " + firstName + lastName);
        System.out.println("");
        System.out.println("Student Id   ................   " + id);
        System.out.println("First Name   ................   " + firstName);
        System.out.println("Last Name   .................   " + lastName);
        System.out.println("age   .......................   " + age);
        System.out.println("");
        System.out.println("            COURSES");
        System.out.println("");
        System.out.println("Java   .......................   " + java);
        System.out.println("CSharp   .....................   " + cSharp);
        System.out.println("Python   .....................   " + python);
        System.out.println("PHP   ........................   " + pHP);
        System.out.println("");
        System.out.println("            RESULTS");
        System.out.println("");
        System.out.println("Result   .....................   " + studentPassed());
        System.out.println("Retakes   ....................   " + calculateRetakes());
    }
    private String studentPassed(){
        if(java > 55 && cSharp > 55 && python > 55 && pHP > 55){
            return "Passed";
        }
        else{
            return "Not Passed";
        }
    }
    private int calculateRetakes(){
        determineRetake(java);
        determineRetake(cSharp);
        determineRetake(python);
        determineRetake(pHP);

        return countRetake;
    }
    private int determineRetake(int course){
        if(course < 55){
            return countRetake++;
        }
        return countRetake;
    }

    public void updateReportCard(){
        java = updateGrade("Current grade Java is: " + java + " Enter (new) grade: ");
        cSharp = updateGrade("Current grade CSharp is: " + cSharp + " Enter (new) grade: ");
        python = updateGrade("Current grade Python is: " + python + " Enter (new) grade: ");
        pHP = updateGrade("Current grade PHP is: " + pHP + " Enter (new) grade: ");
    }

    private int updateGrade(String question){
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        return Integer.parseInt(scanner.nextLine());
    }
}
