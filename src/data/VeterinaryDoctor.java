package data;

public class VeterinaryDoctor extends User {

    private final String Certification;
    private Appointment appointment;

    public VeterinaryDoctor(String cert) {
        this.Certification = cert;
    }

    public String getCertification() {
        return Certification;
    }
}
