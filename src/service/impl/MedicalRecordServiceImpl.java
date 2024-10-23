package service.impl;

import data.MedicalRecord;
import data.Pet;
import data.dao.Storage;
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
//
//        MedicalRecord existingRecord = getRecordById(record.getRecordID());
//        if (existingRecord != null) {
//            // Update the fields of the existing record
//            existingRecord.setDate(record.getDate());
//            existingRecord.setTreatment(record.getTreatment());
//            // Commit the changes to the data source
//            Storage.add();// Save changes to database or list
//            return true;
//        }
        return false;
    }

    @Override
    public boolean deleteRecord(int recordId) {
        return false;
    }
}
