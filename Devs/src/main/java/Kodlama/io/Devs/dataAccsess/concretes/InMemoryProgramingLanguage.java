package Kodlama.io.Devs.dataAccsess.concretes;

import Kodlama.io.Devs.dataAccsess.abstracts.ProgramingLanguageRepository;
import Kodlama.io.Devs.entites.concretes.ProgramingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgramingLanguage implements ProgramingLanguageRepository {
    List<ProgramingLanguage> programingLanguages;

    public InMemoryProgramingLanguage() {
        programingLanguages =new ArrayList<>();
        programingLanguages.add(new ProgramingLanguage(1,"C#"));
        programingLanguages.add(new ProgramingLanguage(2,"java"));
        programingLanguages.add(new ProgramingLanguage(3,"Pyhton"));

    }

    @Override
    public List<ProgramingLanguage> getAll() {
        return programingLanguages;
    }

    @Override
    public ProgramingLanguage getById(int id) {

        for (ProgramingLanguage programingLanguage : programingLanguages){
            if (programingLanguage.getId()==id){
                return programingLanguage;
            }
        }return null;
    }

    @Override
    public void add(ProgramingLanguage programingLanguage) {
       programingLanguages.add(programingLanguage);
    }

    @Override
    public void update(int id, ProgramingLanguage programingLanguage ) {
       ProgramingLanguage changeProgramingLanguage = getById(id);
       changeProgramingLanguage.setName(programingLanguage.getName());

    }

    @Override
    public void delete(int id) {
            ProgramingLanguage deletedProgramingLanguage =getById(id);
            programingLanguages.remove(deletedProgramingLanguage);
            }
        }


