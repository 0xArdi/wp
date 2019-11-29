package mk.finki.ukim.mk.lab.model.transferable.dtos;

import java.util.List;

public class SimplePizzaDTO {
    private String name;
    private String desc;
    private List<String> ingredients;
    private boolean veggie;

    public SimplePizzaDTO() {
    }

    public SimplePizzaDTO(String name, String desc, List<String> ingredients, boolean veggie) {
        this.name = name;
        this.desc = desc;
        this.ingredients = ingredients;
        this.veggie = veggie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isVeggie() {
        return veggie;
    }

    public void setVeggie(boolean veggie) {
        this.veggie = veggie;
    }

}
