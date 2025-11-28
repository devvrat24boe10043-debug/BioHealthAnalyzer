import java.util.*;

public class Main {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    // User-friendly menu system with input validation and error handling
    public static void main(String[] args) {
        System.out.println("=== BIOHEALTH ANALYZER ===");
        System.out.println("Medical Data Analysis System");
        System.out.println("----------------------------");
        
        // Load existing data
        patients = FileManager.loadPatients();
        medicalRecords = FileManager.loadMedicalRecords();
        
        showMainMenu();
    }
    
    public static void showMainMenu() {
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Add New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Add Medical Record");
            System.out.println("4. Analyze Patient Health");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1: addNewPatient(); break;
                case 2: viewAllPatients(); break;
                case 3: addMedicalRecord(); break;
                case 4: analyzePatientHealth(); break;
                case 5: 
                    FileManager.savePatients(patients);
                    FileManager.saveMedicalRecords(medicalRecords);
                    System.out.println("Data saved. Thank you for using BioHealth Analyzer!");
                    return;
                default: System.out.println("Invalid choice! Try again.");
            }
        }
    }
    
    public static void addNewPatient() {
        System.out.println("\n=== ADD NEW PATIENT ===");
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Gender (M/F): ");
        String gender = scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();
        
        patients.add(new Patient(id, name, age, gender, contact));
        System.out.println("Patient added successfully!");
    }
    
    public static void viewAllPatients() {
        System.out.println("\n=== ALL PATIENTS ===");
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        for (Patient p : patients) {
            p.displayInfo();
        }
    }
    
    public static void addMedicalRecord() {
        System.out.println("\n=== ADD MEDICAL RECORD ===");
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter Blood Pressure: ");
        double bp = scanner.nextDouble();
        System.out.print("Enter Heart Rate: ");
        int hr = scanner.nextInt();
        System.out.print("Enter Temperature: ");
        double temp = scanner.nextDouble();
        scanner.nextLine();
        
        medicalRecords.add(new MedicalRecord(id, bp, hr, temp, 0, 0));
        System.out.println("Medical record added successfully!");
    }
    
    public static void analyzePatientHealth() {
        System.out.println("\n=== HEALTH ANALYSIS ===");
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        
        for (MedicalRecord record : medicalRecords) {
            if (record.getPatientId().equals(id)) {
                HealthAnalyzer.comprehensiveAnalysis(record);
                return;
            }
        }
        System.out.println("No medical records found for this patient.");
    }
}
