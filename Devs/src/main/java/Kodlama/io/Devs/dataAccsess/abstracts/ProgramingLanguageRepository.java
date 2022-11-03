package Kodlama.io.Devs.dataAccsess.abstracts;

import Kodlama.io.Devs.entites.concretes.ProgramingLanguage;

import java.util.List;

public interface ProgramingLanguageRepository {
    List<ProgramingLanguage> getAll();
    ProgramingLanguage getById(int id);
    void add(ProgramingLanguage programingLanguage);
    void update(int id,ProgramingLanguage programingLanguage );
    void delete(int id);


}
