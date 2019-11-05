package mk.finki.ukim.mk.lab.repository.impl;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;

import java.util.List;

public class PizzaInMemoryRepository implements PizzaRepository {
    @Override
    public List<Pizza> getAllPizzas() {
        return DataHolder.pizzas;
    }
}
