package service;

import data.Appointment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {

    Appointment scheduleAppointment(LocalDateTime appointmentDate, String reason);

    Appointment getAppointmentById(int appointmentId);

    List<Appointment> getAppointmentsByDate(LocalDate date);

    boolean updateAppointment(Appointment appointment);

    boolean cancelAppointment(int appointmentId);
}
