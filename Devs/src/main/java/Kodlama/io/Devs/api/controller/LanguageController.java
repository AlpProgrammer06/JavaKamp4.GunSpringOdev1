package Kodlama.io.Devs.api.controller;

import Kodlama.io.Devs.busines.abstracts.ProgramingLanguageService;
import Kodlama.io.Devs.entites.concretes.ProgramingLanguage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")

public class LanguageController {
    private ProgramingLanguageService programingLanguageService;

    public LanguageController(ProgramingLanguageService programingLanguageService) {
        this.programingLanguageService = programingLanguageService;
    }

    @GetMapping
    public List<ProgramingLanguage> getAll(){
        return programingLanguageService.getAll();
    }

    @PostMapping
    public void add(@RequestBody ProgramingLanguage programingLanguage)throws Exception{
        programingLanguageService.add(programingLanguage);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ProgramingLanguage programingLanguage) throws Exception{
        programingLanguageService.update(id, programingLanguage);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)throws Exception{
        programingLanguageService.delete(id);
    }

    @GetMapping("/{id}")
    public ProgramingLanguage getById(@PathVariable int id)throws Exception{
        return programingLanguageService.getById(id);
    }

}
