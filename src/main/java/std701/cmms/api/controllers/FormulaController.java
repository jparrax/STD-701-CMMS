package std701.cmms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import std701.cmms.api.models.Formula;
import std701.cmms.api.models.HttpResponse;
import std701.cmms.api.models.Ingredient;
import std701.cmms.api.models.User;
import std701.cmms.api.repositories.FormulaRepository;
import std701.cmms.api.repositories.IngredientRepository;
import std701.cmms.api.repositories.RawMaterialRepository;
import std701.cmms.api.repositories.UserRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/formulas")
public class FormulaController {
    private FormulaRepository formulaRepository;
    private UserRepository userRepository;
    private IngredientRepository ingredientRepository;
    private RawMaterialRepository rawMaterialRepository;

    @Autowired
    public FormulaController(FormulaRepository formulaRepository,
                             UserRepository userRepository,
                             IngredientRepository ingredientRepository,
                             RawMaterialRepository rawMaterialRepository) {
        this.formulaRepository = formulaRepository;
        this.userRepository = userRepository;
        this.ingredientRepository = ingredientRepository;
        this.rawMaterialRepository = rawMaterialRepository;
    }

    @GetMapping
    public HttpResponse<List<Formula>> getFormulas() {
        HttpResponse<List<Formula>> httpResponse = new HttpResponse<>();

        httpResponse.setMessage("Success!");
        httpResponse.setStatus(200);
        httpResponse.setData(StreamSupport.stream(formulaRepository.findAll()
                .spliterator(), false)
                .collect(Collectors.toList()));

        return httpResponse;
    }

    @PostMapping
    public HttpResponse<Formula> saveFormula(@RequestBody Formula reqFormula) {
        HttpResponse<Formula> httpResponse = new HttpResponse<>();
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        User defaultUser = userRepository.findById(1).orElse(null);
        Formula newFormula = new Formula();

        newFormula.setFormulaName(reqFormula.getFormulaName());
        newFormula.setFormulaDesc(reqFormula.getFormulaDesc());
        newFormula.setIsActive(true);
        newFormula.setCreatedAt(currentTimestamp);
        Set<Ingredient> ingredients;
        //Set defaultUser
        newFormula.setUser(defaultUser);
        //Save new formula or Update existing formula
        newFormula = formulaRepository.save(newFormula);
        Formula finalNewFormula = newFormula;
        ingredients = reqFormula.getIngredientList()
                .stream()
                .map(ingredient -> {
                    ingredient.setFormula(finalNewFormula);
                    ingredient.setRawMaterial(
                            rawMaterialRepository.findById(
                                    ingredient.getRawMaterial().getMaterialId()).orElse(null));
                    ingredient.setUser(defaultUser);
                    ingredient.setInputDate(currentTimestamp);
                    ingredient.setIsActive(true);
                    ingredient.setCreatedAt(currentTimestamp);
                    return ingredient;
                }).collect(Collectors.toSet());
        //Save all ingredients in
        ingredients = StreamSupport.stream(
                ingredientRepository.saveAll(ingredients).spliterator(), false)
                .collect(Collectors.toSet());

        newFormula.setIngredientList(ingredients);

        httpResponse.setData(newFormula);
        httpResponse.setStatus(200);
        httpResponse.setMessage("Success!");
        return httpResponse;
    }
}
