package service;

import data.Appointment;

import java.time.LocalDateTime;

public interface AppointmentService {

    Appointment scheduleAppointment(LocalDateTime appointmentDate, String reason);

}
