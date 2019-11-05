package mk.finki.ukim.mk.lab.bootstrap;

import mk.finki.ukim.mk.lab.model.Pizza;

import java.util.LinkedList;
import java.util.List;

public class DataHolder {
    private static List<Pizza> pizzas;

    static {
        pizzas = new LinkedList<>();
        pizzas.add(new Pizza("Margherita", "tomato sauce, mozzarella"));
        pizzas.add(new Pizza("Carbonara", "fresh cream, mozzarella, bacon"));
        pizzas.add(new Pizza("Vegetariana", "tomato sauce, mushrooms"));
        pizzas.add(new Pizza("Calzone", "Pizza dough, ricotta, pepperoni, pizza sauce, olive oil"));
        pizzas.add(new Pizza("Cheddar", "cheddar, tomato sauce"));
        pizzas.add(new Pizza("Capricciosa", "tomato sauce, cheese, ham"));
        pizzas.add(new Pizza("Burger Classic", "barbecue sauce, beef, mozzarella, onions"));
        pizzas.add(new Pizza("Burger Barbecue", "ham, chicken meat, onions"));
        pizzas.add(new Pizza("Pepperoni", "tomato sauce, mozzarella, sausage"));
        pizzas.add(new Pizza("Quattro Formaggi", "Taleggio, Mascarpone, Gorgonzola, Parmesan"));
    }
}
