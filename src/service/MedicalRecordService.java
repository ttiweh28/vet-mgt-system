package service;

import data.MedicalRecord;
import data.Pet;

import java.util.List;

public interface MedicalRecordService {

    MedicalRecord createRecord(MedicalRecord record);

    MedicalRecord getRecordById(int recordId);

    List<MedicalRecord> getRecordsByPet(Pet pet);

    boolean updateRecord(MedicalRecord record);

    boolean deleteRecord(int recordId);
}
