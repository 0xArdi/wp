package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.model.exceptions.DuplicatePizzaNameException;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return this.pizzaRepo.save(pizza).getName();
    }

    @Override
    public Pizza editPizza(String id, Pizza pizza) {
        return null;
    }

    @Override
    public void deletePizza(String id) {

    }

    @Override
    public List<Pizza> getAllPizzas() {
        return null;
    }

    @Override
    public Pizza getPizza(String id) {
        return null;
    }

    @Override
    public List<Pizza> getPizzasWithLessIngredients(int n) {
        return null;
    }

    @Override
    public List<Ingredient> getCommonIngredients(String pizzaId1, String pizzaId2) {
        return null;
    }
}
