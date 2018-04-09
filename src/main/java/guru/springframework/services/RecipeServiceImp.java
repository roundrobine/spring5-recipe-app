package guru.springframework.services;

import guru.springframework.domian.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class RecipeServiceImp implements RecipeService{

    private RecipeRepository recipeRepository;

    public RecipeServiceImp(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getAllRecipes() {
        log.debug("I am using a service!!!");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
       Optional<Recipe> recipe = recipeRepository.findById(id);

       if(!recipe.isPresent()){
           throw  new RuntimeException("Recipe not found");
       }

       return recipe.get();
    }
}
