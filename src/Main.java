import com.model.Doctor;
import com.model.DoctorHash;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Doctor> doctors = new ArrayList<Doctor>() {{
        add(new Doctor("doc1", "John Smith", "Cardiology", 3));
        add(new Doctor("doc2", "Jane Doe", "Neurology", 2));
        add(new Doctor("doc3", "Emily Davis", "Pediatrics", 1));
        // Add more doctors as needed
    }};
    static DoctorHash db = new DoctorHash(doctors);
    public static void main(String[] args) {
        Menu();
    }

    public static void Menu(){
        final int add = 1, update = 2, delete = 3, search = 4, exit = 5;
        while (true) {
            System.out.println("""
                    ========= Doctor Management ==========
                    1.\tAdd Doctor
                    2.\tUpdate Doctor
                    3.\tDelete Doctor
                    4.\tSearch Doctor
                    5.\tExit
                    Enter your choice:\s""");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            String code, name, specialization;
            int availability;
            Doctor d;
            switch (choice) {
                case add:
                    System.out.print("""
                            --------- Add Doctor ----------
                            Enter Code:\s""");
                    sc = new Scanner(System.in);
                    code = sc.nextLine();
                    System.out.print("Enter Name: ");
                    sc = new Scanner(System.in);
                    name = sc.nextLine();
                    System.out.print("Enter Specialization: ");
                    specialization = sc.nextLine();
                    System.out.print("Enter Availability: ");
                    availability = sc.nextInt();
                    d = new Doctor(code, name, specialization, availability);
                    try {
                        boolean result = db.addDoctor(d);
                        if (result) {
                            System.out.println("Doctor added successfully.");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case update:
                    System.out.print("""
                            --------- Update Doctor ----------
                            Enter Code:\s""");
                    sc = new Scanner(System.in);
                    code = sc.nextLine();
                    System.out.print("Enter Name: ");
                    sc = new Scanner(System.in);
                    name = sc.nextLine();
                    System.out.print("Enter Specialization: ");
                    specialization = sc.nextLine();
                    System.out.print("Enter Availability: ");
                    availability = sc.nextInt();
                    d = new Doctor(code, name, specialization, availability);
                    try {
                        boolean result = db.updateDoctor(d);
                        if (result) {
                            System.out.println("Doctor updated successfully.");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case delete:
                    System.out.print("""
                            --------- Delete Doctor ----------
                            Enter Code:\s""");
                    sc = new Scanner(System.in);
                    code = sc.nextLine();
                    try {
                        boolean result = db.deleteDoctor(new Doctor(code, "", "", 0));
                        if (result) {
                            System.out.println("Doctor deleted successfully.");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case search:
                    System.out.print("""
                            --------- Search Doctor ----------
                            Enter text:\s""");
                    sc = new Scanner(System.in);
                    String query = sc.nextLine();
                    try {
                        ArrayList<Doctor> searchResult = db.searchDoctor(query);
                        System.out.println("""
                                ---------Result------------
                                Code \tName\t \tSpecialization    \tAvailability""");
                        for (Doctor doc : searchResult){
                            doc.display();
                        }
                        System.out.println("End of result.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case exit:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }

        }
    }

}
