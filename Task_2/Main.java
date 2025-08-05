import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Filter;

public class Main {

    public static void main(String[] args) {
        long id = 100;
        List<Student> listOfStudent = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        boolean run = true;
        int choice = 5;
        while (run) {
            System.out.println(
                    "\nStudent Record Management System CLI:\nSelect the operation\n1] Create Student\n2] Read Students\n3] Edit Student\n4] Delete Student\n5] Exit Program");

            try {
                System.out.print("Enter the Operation Number: ");
                choice = Integer.parseInt(input.nextLine().trim());
            } catch (Exception e) {
                break;
            }

            switch (choice) {
                case 1:
                    Student newStudent = new Student();
                    newStudent.setId(id++);
                    System.out.print("Enter Student First Name: ");
                    newStudent.setFirtName(input.nextLine().trim());
                    System.out.print("Enter Student Last Name: ");
                    newStudent.setLastName(input.nextLine().trim());
                    System.out.print("Enter Student Roll Number: ");
                    newStudent.setRollNo(Integer.parseInt(input.nextLine().trim()));
                    System.out.print("Enter Student Marks: ");
                    newStudent.setMarks(Float.parseFloat(input.nextLine().trim()));

                    listOfStudent.add(newStudent);
                    break;
                case 2:
                    if (listOfStudent.size() < 1) {
                        System.out.println("No Student Added!");
                        break;
                    }
                    System.out.println("<=====| List of Students |====>");
                    for (Student std : listOfStudent) {
                        System.out.println(std.toString());
                    }
                    break;
                case 3:
                    if (listOfStudent.size() < 1) {
                        System.out.println("No Student Added!");
                        break;
                    }
                    System.out.print("Enter Student id to edit: ");
                    long std_id = Long.parseLong(input.nextLine().trim());
                    Student stdToEdit = listOfStudent.stream()
                            .filter(student -> student.getId() == std_id)
                            .findFirst()
                            .orElse(null);

                    if (stdToEdit == null) {
                        System.out.println("Student Not Found!");
                        break;
                    } else {


                        System.out.println("Student to edit: " + stdToEdit.toString());
                        boolean edit = true;
                        while (edit) {
                            System.out.println("\nWhat to edit?\n1] first name\n2] last name\n3] Roll Numer\n4] Marks\n5] done edit!!");
                            System.out.print("Enter the Operation number.");
                            int editChoice = Integer.parseInt(input.nextLine().trim());
                            switch (editChoice) {
                                case 1:
                                    System.out.print("Enter new First name: ");
                                    String new_firstName = input.nextLine().trim();
                                    stdToEdit.setFirtName(new_firstName);
                                case 2:
                                    System.out.print("Enter new Last Name: ");
                                    String newLastName = input.nextLine().trim();
                                    stdToEdit.setLastName(newLastName);
                                    break;

                                case 3:
                                    System.out.print("Enter new Roll Number: ");
                                    int newRollNumber = Integer.parseInt(input.nextLine().trim());
                                    stdToEdit.setRollNo(newRollNumber);
                                    break;

                                case 4:
                                    System.out.print("Enter new Marks: ");
                                    float newMarks = Float.parseFloat(input.nextLine().trim());
                                    stdToEdit.setMarks(newMarks);
                                    break;

                                case 5:
                                    edit = false;
                                    System.out.println("student editedd");
                                    break;
                            }
                        }
                    }
                    break;
                case 4:
                    if (listOfStudent.size() < 1) {
                        System.out.println("No Student Added!");
                        break;
                    }
                    System.out.print("Enter Student id to delete: ");
                    long id_del = Long.parseLong(input.nextLine().trim());
                    Student stdToDelete = listOfStudent.stream()
                            .filter(student -> student.getId() == id_del)
                            .findFirst()
                            .orElse(null);

                    if (stdToDelete == null) {
                        System.out.println("Student Not Found!");
                        break;
                    }else{
                        listOfStudent.remove(stdToDelete);
                        System.out.println("Student Deleted");
                    }
                    break;
                case 5:
                    run = false;
                    System.out.println("Bye!");
                    break;

                default:
                    break;
            }

        }


    }

    private static List<Student> deleteStudente(List<Student> listOfStudent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStudente'");
    }


}
