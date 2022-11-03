package Kodlama.io.Devs.busines.abstracts;

import Kodlama.io.Devs.entites.concretes.ProgramingLanguage;

import java.util.List;

public interface ProgramingLanguageService  {
    List<ProgramingLanguage> getAll();

    ProgramingLanguage getById(int id)throws Exception;
    void add (ProgramingLanguage programingLanguage)throws Exception;
    void update(int id, ProgramingLanguage programingLanguage)throws Exception;
    void delete(int id)throws Exception;


}
