// Medical analysis based on clinical standards: AHA BP guidelines, standard heart rate ranges
public class HealthAnalyzer {
    public static String analyzeBloodPressure(double bp) {
        if (bp < 90) return "LOW (Hypotension)";
        else if (bp <= 120) return "NORMAL";
        else if (bp <= 139) return "ELEVATED";
        else return "HIGH (Hypertension) - Consult Doctor!";
    }
    
    public static String analyzeHeartRate(int hr) {
        if (hr < 60) return "LOW (Bradycardia)";
        else if (hr <= 100) return "NORMAL";
        else return "HIGH (Tachycardia)";
    }
    
    public static String analyzeTemperature(double temp) {
        if (temp < 36.0) return "LOW (Hypothermia)";
        else if (temp <= 37.5) return "NORMAL";
        else return "HIGH (Fever)";
    }
    
    public static void comprehensiveAnalysis(MedicalRecord record) {
        System.out.println("\n=== HEALTH ANALYSIS ===");
        System.out.println("Blood Pressure: " + record.getBloodPressure() + " - " + analyzeBloodPressure(record.getBloodPressure()));
        System.out.println("Heart Rate: " + record.getHeartRate() + " - " + analyzeHeartRate(record.getHeartRate()));
        System.out.println("Temperature: " + record.getTemperature() + " - " + analyzeTemperature(record.getTemperature()));
    }
}
