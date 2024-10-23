package service.impl;

import data.MedicalRecord;
import data.Pet;
import data.dao.Storage;
import service.MedicalRecordService;

import java.util.List;

public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Override
    public void createRecord(MedicalRecord record) {
        Storage.add(record);
    }

    @Override
    public MedicalRecord getRecordById(int recordId) {
        return Storage.getMedicalRecord(recordId);
    }

    @Override
    public List<MedicalRecord> getRecordsByPet(Pet pet) {
        return List.of();
    }

    @Override
    public boolean updateRecord(MedicalRecord record, String treatment) {

        record.setTreatment(treatment);
        return true;
    }

    @Override
    public boolean deleteRecord(int recordId) {
        return false;
    }
}
