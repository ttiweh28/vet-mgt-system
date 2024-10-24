package service;

import data.MedicalRecord;

public interface MedicalRecordService {

    void createRecord(MedicalRecord record);

    MedicalRecord getRecordById(int recordId);

    boolean updateRecord(MedicalRecord record, String treatment);
}
