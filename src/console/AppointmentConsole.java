package console;

import data.Appointment;
import data.PetOwner;
import service.AppointmentService;
import service.impl.AppointmentServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class AppointmentConsole {

    private static final Scanner scanner = new Scanner(System.in);

    public static void scheduleAppointment() {

        while (true) {
            LocalDate date = null;
            ConsoleUtil.displayColoredMessageWithNewLine("Enter appointment date (MM/dd/yyyy)", ConsoleUtil.BLUE);
            while (true) {
                String datee = ConsoleUtil.getScanner().nextLine();
                date = ConsoleUtil.DateValidation(datee);
                if (date != null) {
                    break;
                }
            }

            ConsoleUtil.displayColoredMessageWithNewLine("Enter appointment time (hh:mm am/pm)", ConsoleUtil.BLUE);
            LocalTime time = null;
            while (true) {
                String appointmentTime = ConsoleUtil.getScanner().nextLine();
                time = ConsoleUtil.timeValidation(appointmentTime);
                if (time != null) {
                    break;
                }
            }
            LocalDateTime appointmentDate = date.atTime(time);

            ConsoleUtil.displayColoredMessageWithNewLine("Appointment Reason", ConsoleUtil.BLUE);
            String reason = ConsoleUtil.getScanner().nextLine();

            AppointmentService appointmentService = new AppointmentServiceImpl();
            Appointment appointment = appointmentService.scheduleAppointment(appointmentDate, reason);

            if (appointment == null) {
                ConsoleUtil.displayError("The selected date is not Available, please select another Date/time");
            } else {
                break;
            }
        }
        ConsoleUtil.displaySuccessMessage("Appointment created successfully.");
    }

    public static void viewAppointments(PetOwner owner) {
        System.out.println("Owner Appointments: " + owner.getAppointments());
    }
}
