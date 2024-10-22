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
            ConsoleUtil.displayColoredMessageWithNewLine("Enter appointment date (MM/dd/yyyy)", ConsoleUtil.BLUE);
            String datee = ConsoleUtil.getScanner().nextLine();

            LocalDate date = ConsoleUtil.DateValidation(datee);

            if (date == null) {
                scheduleAppointment();
                return;
            }

            ConsoleUtil.displayColoredMessageWithNewLine("Enter appointment time (hh:mm am/pm)", ConsoleUtil.BLUE);
            String appointmentTime = ConsoleUtil.getScanner().nextLine();

            LocalTime time = ConsoleUtil.timeValidation(appointmentTime);

            if (time == null) {
                scheduleAppointment();
                return;
            }

            LocalDateTime appointmentDate = date.atTime(time);

            ConsoleUtil.displayColoredMessageWithNewLine("Appointment Reason", ConsoleUtil.BLUE);
            String reason = ConsoleUtil.getScanner().nextLine();

            AppointmentService appointmentService = new AppointmentServiceImpl();
            Appointment appointment = appointmentService.scheduleAppointment(appointmentDate, reason);

            if (appointment == null) {
                ConsoleUtil.displayColoredMessageWithNewLine("The selected Date is not Available, please select another Date/time", ConsoleUtil.RED);
            } else {
                break;
            }
        }

        System.out.println("Appointment created successfully.");
    }

    public static void viewAppointments(PetOwner owner) {
        System.out.println("Owner Appointments: " + owner.getAppointments());
    }
}
