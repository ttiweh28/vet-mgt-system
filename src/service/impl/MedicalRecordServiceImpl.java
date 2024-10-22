package service.impl;

import data.MedicalRecord;
import data.Pet;
import service.MedicalRecordService;

import java.util.List;

public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Override
    public MedicalRecord createRecord(MedicalRecord record) {
        return null;
    }

    @Override
    public MedicalRecord getRecordById(int recordId) {
        return null;
    }

    @Override
    public List<MedicalRecord> getRecordsByPet(Pet pet) {
        return List.of();
    }

    @Override
    public boolean updateRecord(MedicalRecord record) {
        return false;
    }

    @Override
    public boolean deleteRecord(int recordId) {
        return false;
    }
}
