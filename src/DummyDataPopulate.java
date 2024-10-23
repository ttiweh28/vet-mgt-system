import data.*;
import data.dao.Storage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DummyDataPopulate {

    static List<Pet> pets = new ArrayList<>();
    static List<PetOwner> petOwners = new ArrayList<>();


    public static void populateAdministrators() {

        Administrator admin1 = new Administrator();
        admin1.setFirstName("Sandra");
        admin1.setLastName("Kawombe");
        admin1.setUserId(1);
        admin1.setEmail("sandi@miu.edu");
        admin1.setPassword("sandi");
        admin1.setPhoneNumber("555-1234");
        admin1.setAddress(new Address("Fairfield", "IA", "123 Main St", "52556"));

        Storage.add(admin1);
    }

    public static void populatePetOwners() {

        PetOwner owner1 = new PetOwner();
        owner1.setFirstName("Hewitt");
        owner1.setLastName("Tusimme");
        owner1.setUserId(3);
        owner1.setEmail("Hewitt@miu.edu");
        owner1.setPassword("h");
        owner1.setPhoneNumber("444-335");
        owner1.setAddress(new Address("Burlington", "IA", "789 Oak St", "52601"));
        owner1.setPets(pets);

        petOwners.add(owner1);

        Storage.add(owner1);

    }

    private static List<Pet> populatePets() {

        Pet pet1 = new Pet("Golgy", 3);
        pet1.addMedicalRecords(new MedicalRecord(1, LocalDate.now().minusMonths(3), "Vaccination", pet1));
        pet1.addMedicalRecords(new MedicalRecord(2, LocalDate.now().minusMonths(1), "Check-up", pet1));

        Pet pet2 = new Pet("Helly", 2);
        pet2.addMedicalRecords(new MedicalRecord(3, LocalDate.now().minusMonths(5), "Surgery", pet2));


        pets.add(pet1);
        pets.add(pet2);

        Storage.add(pet1);
        Storage.add(pet2);

        return pets;
    }

    public static void populateVeterinaryDoctors() {

        VeterinaryDoctor doc1 = new VeterinaryDoctor("VetCertification123");
        doc1.setFirstName("Abenezer");
        doc1.setLastName("Tilahun");
        doc1.setUserId(5);
        doc1.setEmail("abenezer@miu.edu");
        doc1.setPassword("abenezer");
        doc1.setPhoneNumber("555-2468");
        doc1.setAddress(new Address("Des Moines", "IA", "567 Elm St", "50301"));

        Storage.add(doc1);

    }

    public static List<Appointment> populateAppointments() {
        List<Appointment> appointments = new ArrayList<>();

        Appointment app1 = new Appointment(LocalDateTime.now().plusDays(3), "null", petOwners.get(0));
        Appointment app2 = new Appointment(LocalDateTime.now().plusDays(7), "null", petOwners.get(0));

        app1.setPetOwner(petOwners.get(0));
        app2.setPetOwner(petOwners.get(0));

        appointments.add(app1);
        appointments.add(app2);

        Storage.add(app1);
        Storage.add(app2);

        return appointments;
    }

    public static void populateAll() {

        populateAdministrators();
        populatePets();
        populatePetOwners();
        populateVeterinaryDoctors();
        populateAppointments();

    }


}
