package service.impl;

import console.Login;
import data.Appointment;
import data.PetOwner;
import data.dao.Storage;
import service.AppointmentService;

import java.time.LocalDateTime;

public class AppointmentServiceImpl implements AppointmentService {

    @Override
    public Appointment scheduleAppointment(LocalDateTime appointmentDate, String reason) {

        Appointment appointment = new Appointment(appointmentDate, reason, ((PetOwner) Login.loggedInUser));

        boolean isDateAvailable = Storage.getAppointmentBasedOnDateAndTime(appointmentDate);

        if (isDateAvailable) {
            return null;
        }

        Storage.add(appointment);
        return appointment;
    }

}
