package service;

import data.VeterinaryDoctor;
import data.Appointment;

public interface VeterinaryDoctorService {
    VeterinaryDoctor createVeterinaryDoctor(VeterinaryDoctor doctor);

    VeterinaryDoctor getVeterinaryDoctorById(int doctorId);

    boolean assignAppointment(VeterinaryDoctor doctor, Appointment appointment);

    boolean updateVeterinaryDoctor(VeterinaryDoctor doctor);

    boolean deleteVeterinaryDoctor(int doctorId);
}