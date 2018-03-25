package guru.springframework.services;

import guru.springframework.domian.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getAllRecipes();
}
