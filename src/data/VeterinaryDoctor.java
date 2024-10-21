package data;

public class VeterinaryDoctor extends User{

    private String Certification;

    public VeterinaryDoctor(String cert) {
        super();
        this.Certification=cert;
    }

    public String getCertification() {
        return Certification;
    }
}
