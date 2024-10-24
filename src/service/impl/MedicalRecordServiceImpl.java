package service.impl;

import data.MedicalRecord;
import data.dao.Storage;
import service.MedicalRecordService;

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
    public boolean updateRecord(MedicalRecord record, String treatment) {

        record.setTreatment(treatment);
        return true;
    }
}
