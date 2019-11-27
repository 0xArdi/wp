package mk.finki.ukim.mk.lab.web.controllers;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.exceptions.IngredientDoesntExistException;
import mk.finki.ukim.mk.lab.service.IngredientService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    private final IngredientService ingredientService;

    public IngredientsController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createIngredient(@RequestBody Ingredient ingredient) {
        return this.ingredientService.createIngredient(ingredient);
    }

    @PatchMapping("{id}")
    public Ingredient editIngredient(@PathVariable String id, @RequestBody Ingredient ingredient) {
        return this.ingredientService.editIngredient(id, ingredient);
    }

    @DeleteMapping("{id}")
    public void deleteIngredient(@PathVariable String id) {
        this.ingredientService.deleteIngredient(id);
    }

    @GetMapping("{id}")
    public Ingredient getIngredient(@PathVariable String id) {
        return this.ingredientService.getIngredient(id)
                .orElseThrow(IngredientDoesntExistException::new);
    }

    @GetMapping
    public Page<Ingredient> getIngredients(@RequestParam(required = false, defaultValue = "10") int size,
                                           @RequestParam(required = false, defaultValue = "0") int page,
                                           @RequestParam(required = false, defaultValue = "false") boolean isSpicy) {
        return this.ingredientService.getIngredients(page, size, isSpicy);
    }


}