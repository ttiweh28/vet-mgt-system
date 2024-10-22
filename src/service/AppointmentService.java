package service;

import data.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {

    Appointment createAppointment(Appointment appointment);

    Appointment getAppointmentById(int appointmentId);

    List<Appointment> getAppointmentsByDate(LocalDate date);

    boolean updateAppointment(Appointment appointment);

    boolean cancelAppointment(int appointmentId);
}
