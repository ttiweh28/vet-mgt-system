package service;

import data.Appointment;
import data.VeterinaryDoctor;

public class VeterinaryDoctorServiceImpl implements VeterinaryDoctorService {
    @Override
    public VeterinaryDoctor createVeterinaryDoctor(VeterinaryDoctor doctor) {
        return null;
    }

    @Override
    public VeterinaryDoctor getVeterinaryDoctorById(int doctorId) {
        return null;
    }

    @Override
    public boolean assignAppointment(VeterinaryDoctor doctor, Appointment appointment) {
        return false;
    }

    @Override
    public boolean updateVeterinaryDoctor(VeterinaryDoctor doctor) {
        return false;
    }

    @Override
    public boolean deleteVeterinaryDoctor(int doctorId) {
        return false;
    }
}
