package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.model.exceptions.DuplicatePizzaNameException;
import mk.finki.ukim.mk.lab.model.exceptions.NonVeggieIngredientException;
import mk.finki.ukim.mk.lab.model.exceptions.PizzaDoesntExistException;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService {
    private final PizzaRepository pizzaRepo;

    public PizzaServiceImpl(PizzaRepository pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    @Override
    public List<Pizza> listPizzas() {
        return this.pizzaRepo.findAll();
    }

    @Override
    public String createPizza(Pizza pizza) {
        if (this.pizzaRepo.existsById(pizza.getName()))
            throw new DuplicatePizzaNameException();

        boolean isVeggie = pizza.getIngredients().stream().allMatch(Ingredient::isVeggie);

        if (pizza.isVeggie() && isVeggie)
            throw new NonVeggieIngredientException();

        pizza.setVeggie(isVeggie);

        return this.pizzaRepo.save(pizza).getName();
    }

    @Override
    public Pizza editPizza(String id, Pizza pizza) {
        if (!this.pizzaRepo.existsById(id))
            throw new PizzaDoesntExistException();
        return this.pizzaRepo.save(pizza);
    }

    @Override
    public void deletePizza(String id) {
        if (!this.pizzaRepo.existsById(id))
            throw new PizzaDoesntExistException();
        this.pizzaRepo.deleteById(id);
    }

    @Override
    public List<Pizza> getAllPizzas(int totalIngredients) {
        if (totalIngredients <= 0)
            return this.pizzaRepo.findAll();

        return this.pizzaRepo.findByIngredientCount(totalIngredients);
    }

    @Override
    public Pizza getPizza(String id) {
        return this.pizzaRepo.findById(id)
                .orElseThrow(PizzaDoesntExistException::new);
    }

    @Override
    public List<Ingredient> getCommonIngredients(String pizzaId1, String pizzaId2) {
        List<Ingredient> ingredients = this.getPizza(pizzaId1).getIngredients();
        return this.getPizza(pizzaId2).getIngredients()
                .stream()
                .filter(ingredients::contains)
                .collect(Collectors.toList());
    }

    @Override
    public List<Pizza> getPizzaContaining(String ingredient) {
        return this.pizzaRepo.findPizzaByIngredientsContains(ingredient);
    }
}
