package service.impl;

import console.Login;
import data.Appointment;
import data.Pet;
import data.PetOwner;
import data.dao.Storage;
import service.AppointmentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentServiceImpl implements AppointmentService {

    @Override
    public Appointment scheduleAppointment(LocalDateTime appointmentDate, String reason) {

        Appointment appointment = new Appointment(appointmentDate,reason, ((PetOwner) Login.loggedInUser));

        boolean isDateAvailable = Storage.getAppointmentBasedOnDateAndTime(appointmentDate);

        if (isDateAvailable){
            return null;
        }

        Storage.add(appointment);
        return appointment;
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        return null;
    }

    @Override
    public List<Appointment> getAppointmentsByDate(LocalDate date) {

        return null;
    }

    @Override
    public boolean updateAppointment(Appointment appointment) {

        return false;
    }

    @Override
    public boolean cancelAppointment(int appointmentId) {
        return false;
    }
}
