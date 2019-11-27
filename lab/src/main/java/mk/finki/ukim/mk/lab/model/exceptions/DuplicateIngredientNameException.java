package mk.finki.ukim.mk.lab.model.exceptions;

public class DuplicateIngredientNameException extends RuntimeException {
    public DuplicateIngredientNameException() {
        super("Ingredient with the same name already exists!");
    }
}
