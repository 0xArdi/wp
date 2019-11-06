package mk.finki.ukim.mk.lab.repository.impl;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaInMemoryRepository implements PizzaRepository {
    @Override
    public List<Pizza> getAllPizzas() {
        return DataHolder.pizzas;
    }
}