package service;

import data.MedicalRecord;
import data.Pet;

import java.util.List;

public interface MedicalRecordService {

    void createRecord(MedicalRecord record);

    MedicalRecord getRecordById(int recordId);

    List<MedicalRecord> getRecordsByPet(Pet pet);

    boolean updateRecord(MedicalRecord record, String treatment);

    boolean deleteRecord(int recordId);
}
