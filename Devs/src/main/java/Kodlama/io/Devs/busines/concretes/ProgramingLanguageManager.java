package Kodlama.io.Devs.busines.concretes;

import Kodlama.io.Devs.busines.abstracts.ProgramingLanguageService;
import Kodlama.io.Devs.dataAccsess.abstracts.ProgramingLanguageRepository;
import Kodlama.io.Devs.entites.concretes.ProgramingLanguage;
import org.springframework.stereotype.Service;

import java.util.List;



@Service

public class ProgramingLanguageManager implements ProgramingLanguageService {

    private ProgramingLanguageRepository programingLanguageRepository;



    public ProgramingLanguageManager(ProgramingLanguageRepository programingLanguageRepository) {
        this.programingLanguageRepository = programingLanguageRepository;
    }

    @Override
    public List<ProgramingLanguage> getAll() {
        return programingLanguageRepository.getAll();
    }

    @Override
    public ProgramingLanguage getById(int id) throws Exception{
        if (!isIdExist(id)){
            throw new Exception("Id bulunamadı");
        }

        return programingLanguageRepository.getById(id);
    }

    @Override
    public void add(ProgramingLanguage programingLanguage) throws  Exception{
            isNameValid(programingLanguage);
            if (isIdExist(programingLanguage.getId())){
                throw new Exception("Bu id zaten kayıtlı");
            }
            programingLanguageRepository.add(programingLanguage);
    }

    @Override
    public void update(int id, ProgramingLanguage programingLanguage) throws Exception{
        if (!isIdExist(id)){
            throw new Exception("Böyle bir id bulunamadı");
        }
        isNameValid(programingLanguage);
        programingLanguageRepository.update(id,programingLanguage);
    }

    @Override
    public void delete(int id) throws Exception{
        if (!isIdExist(id)){
            throw new Exception("Böyle bir Id bulunamadı");
        }
        programingLanguageRepository.delete(id);
    }
   private boolean isNameValid(ProgramingLanguage programingLanguage) throws Exception {
        if (programingLanguage.getName().isBlank()) {
            throw new Exception("Programlama dili boş geçilemez");
        }

        for (ProgramingLanguage programingLanguage1 : getAll()){
            if (programingLanguage1.getName().equalsIgnoreCase(programingLanguage.getName())){
                throw new Exception("isim tekrar edemez");
            }
        }return true;

    }
    private boolean isIdExist(int id) {
        for (ProgramingLanguage programingLanguage : getAll()) {
            if (programingLanguage.getId() == id) {
                return true;
            }
        }return false;
    }

}
