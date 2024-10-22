import data.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DummyDataPopulate {

    public static List<Administrator> populateAdministrators() {
        List<Administrator> administrators = new ArrayList<>();

        Administrator admin1 = new Administrator();
        admin1.setFirstName("John");
        admin1.setLastName("Doe");
        admin1.setUserId(1);
        admin1.setEmail("johndoe@vetclinic.com");
        admin1.setPhoneNumber("555-1234");
        admin1.setAddress(new Address("Fairfield", "IA", "123 Main St", "52556"));

        Administrator admin2 = new Administrator();
        admin2.setFirstName("Jane");
        admin2.setLastName("Smith");
        admin2.setUserId(2);
        admin2.setEmail("janesmith@vetclinic.com");
        admin2.setPhoneNumber("555-5678");
        admin2.setAddress(new Address("Ottumwa", "IA", "456 Maple St", "52501"));

        administrators.add(admin1);
        administrators.add(admin2);

        return administrators;
    }

    public static List<PetOwner> populatePetOwners() {
        List<PetOwner> petOwners = new ArrayList<>();

        PetOwner owner1 = new PetOwner();
        owner1.setFirstName("Alice");
        owner1.setLastName("Williams");
        owner1.setUserId(3);
        owner1.setEmail("alice@pets.com");
        owner1.setPhoneNumber("555-9876");
        owner1.setAddress(new Address("Burlington", "IA", "789 Oak St", "52601"));
        owner1.setPets(populatePetsForOwner(owner1));

        PetOwner owner2 = new PetOwner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Johnson");
        owner2.setUserId(4);
        owner2.setEmail("bob@pets.com");
        owner2.setPhoneNumber("555-4321");
        owner2.setAddress(new Address("Cedar Rapids", "IA", "234 Pine St", "52401"));
        owner2.setPets(populatePetsForOwner(owner2));

        petOwners.add(owner1);
        petOwners.add(owner2);

        return petOwners;
    }

    private static List<Pet> populatePetsForOwner(PetOwner owner) {
        List<Pet> pets = new ArrayList<>();

        Pet pet1 = new Pet(1, 1, 3, 1001);
        pet1.addMedicalRecords(new MedicalRecord(1, LocalDate.now().minusMonths(3), "Vaccination", pet1));
        pet1.addMedicalRecords(new MedicalRecord(2, LocalDate.now().minusMonths(1), "Check-up", pet1));

        Pet pet2 = new Pet(2, 2, 5, 1002);
        pet2.addMedicalRecords(new MedicalRecord(3, LocalDate.now().minusMonths(5), "Surgery", pet2));

        pets.add(pet1);
        pets.add(pet2);

        return pets;
    }

    public static List<VeterinaryDoctor> populateVeterinaryDoctors() {
        List<VeterinaryDoctor> doctors = new ArrayList<>();

        VeterinaryDoctor doc1 = new VeterinaryDoctor("VetCertification123");
        doc1.setFirstName("Emily");
        doc1.setLastName("Brown");
        doc1.setUserId(5);
        doc1.setEmail("emilybrown@vetclinic.com");
        doc1.setPhoneNumber("555-2468");
        doc1.setAddress(new Address("Des Moines", "IA", "567 Elm St", "50301"));

        VeterinaryDoctor doc2 = new VeterinaryDoctor("VetCertification456");
        doc2.setFirstName("David");
        doc2.setLastName("Wilson");
        doc2.setUserId(6);
        doc2.setEmail("davidwilson@vetclinic.com");
        doc2.setPhoneNumber("555-1357");
        doc2.setAddress(new Address("Ames", "IA", "890 Walnut St", "50010"));

        doctors.add(doc1);
        doctors.add(doc2);

        return doctors;
    }

    public static List<Appointment> populateAppointments() {
        List<Appointment> appointments = new ArrayList<>();

        Appointment app1 = new Appointment(1001, LocalDate.now().plusDays(3), null, "General Check-up");
        Appointment app2 = new Appointment(1002, LocalDate.now().plusDays(7), null, "Vaccination");

        appointments.add(app1);
        appointments.add(app2);

        return appointments;
    }

    public static void populateAll(){

        populateAdministrators();
        populatePetsForOwner(populatePetOwners().get(0));
        populateVeterinaryDoctors();
        populateAppointments();

    }

}
