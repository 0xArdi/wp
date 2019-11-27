package mk.finki.ukim.mk.lab.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    private long pizzaId;
    private String name;
    private String description;
    private List<Ingredient> ingredients;
    private boolean veggie;

    public Pizza(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Pizza() {
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isVeggie() {
        return veggie;
    }

    public void setVeggie(boolean veggie) {
        this.veggie = veggie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
