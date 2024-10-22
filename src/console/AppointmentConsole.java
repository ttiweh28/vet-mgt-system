package console;

import data.Appointment;
import data.PetOwner;
import service.impl.PetOwnerServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class AppointmentConsole {

    private static final Scanner scanner = new Scanner(System.in);

    public static void createAppointment(PetOwner owner, PetOwnerServiceImpl service) {
        System.out.print("Enter Appointment ID: ");
        int appointmentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Reason: ");
        String reason = scanner.nextLine();
        System.out.print("Enter Date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        Appointment appointment = new Appointment(appointmentId, date, null, reason);
        owner.getAppointments().add(appointment);
        System.out.println("Appointment created successfully.");
    }

    public static void viewAppointments(PetOwner owner) {
        System.out.println("Owner Appointments: " + owner.getAppointments());
    }
}
