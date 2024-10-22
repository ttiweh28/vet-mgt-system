package service.impl;

import data.Appointment;
import service.AppointmentService;
import java.time.LocalDate;
import java.util.*;

public class AppointmentServiceImpl implements AppointmentService {
    private Map<Integer, Appointment> appointmentMap = new HashMap<>();

    @Override
    public Appointment createAppointment(Appointment appointment) {
        appointmentMap.put(appointment.getAppointmentID(), appointment);
        return appointment;
    }

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        return appointmentMap.get(appointmentId);
    }

    @Override
    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment app : appointmentMap.values()) {
            if (app.getDate().equals(date)) {
                result.add(app);
            }
        }
        return result;
    }

    @Override
    public boolean updateAppointment(Appointment appointment) {
        if (appointmentMap.containsKey(appointment.getAppointmentID())) {
            appointmentMap.put(appointment.getAppointmentID(), appointment);
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelAppointment(int appointmentId) {
        return appointmentMap.remove(appointmentId) != null;
    }
}
