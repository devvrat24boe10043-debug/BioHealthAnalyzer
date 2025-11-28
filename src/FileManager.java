import java.io.*;
import java.util.*;
// File operations with comprehensive error handling and data validation
public class FileManager {
    
    // Save patients to file
    public static void savePatients(ArrayList<Patient> patients) {
        try (PrintWriter writer = new PrintWriter("data/patients.txt")) {
            for (Patient patient : patients) {
                writer.println(patient.toFileString());
            }
            System.out.println("Patients data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving patients: " + e.getMessage());
        }
    }
    
    // Load patients from file
    public static ArrayList<Patient> loadPatients() {
        ArrayList<Patient> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/patients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    Patient patient = new Patient(parts[0], parts[1], 
                                                Integer.parseInt(parts[2]), parts[3], parts[4]);
                    patients.add(patient);
                }
            }
            System.out.println("Patients data loaded successfully!");
        } catch (IOException e) {
            System.out.println("No existing patient data found. Starting fresh.");
        }
        return patients;
    }
    
    // Save medical records
    public static void saveMedicalRecords(ArrayList<MedicalRecord> records) {
        try (PrintWriter writer = new PrintWriter("data/medical_records.txt")) {
            for (MedicalRecord record : records) {
                writer.println(record.toFileString());
            }
            System.out.println("Medical records saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving medical records: " + e.getMessage());
        }
    }
    
    // Load medical records
    public static ArrayList<MedicalRecord> loadMedicalRecords() {
        ArrayList<MedicalRecord> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data/medical_records.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    MedicalRecord record = new MedicalRecord(parts[0], 
                        Double.parseDouble(parts[1]), Integer.parseInt(parts[2]),
                        Double.parseDouble(parts[3]), Double.parseDouble(parts[4]),
                        Double.parseDouble(parts[5]));
                    records.add(record);
                }
            }
            System.out.println("Medical records loaded successfully!");
        } catch (IOException e) {
            System.out.println("No existing medical records found.");
        }
        return records;
    }
}
