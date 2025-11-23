public class MedicalRecord {
    private String patientId;
    private double bloodPressure;
    private int heartRate;
    private double temperature;
    private double bloodSugar;
    private double oxygenSaturation;
    
    public MedicalRecord(String patientId, double bp, int hr, double temp, double sugar, double oxygen) {
        this.patientId = patientId;
        this.bloodPressure = bp;
        this.heartRate = hr;
        this.temperature = temp;
        this.bloodSugar = sugar;
        this.oxygenSaturation = oxygen;
    }
    
    public String getPatientId() { return patientId; }
    public double getBloodPressure() { return bloodPressure; }
    public int getHeartRate() { return heartRate; }
    public double getTemperature() { return temperature; }
    public double getBloodSugar() { return bloodSugar; }
    public double getOxygenSaturation() { return oxygenSaturation; }
    
    public String toFileString() {
        return patientId + "," + bloodPressure + "," + heartRate + "," + 
               temperature + "," + bloodSugar + "," + oxygenSaturation;
    }
}
