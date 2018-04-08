package guru.springframework.services;

import guru.springframework.domian.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImpTest {

    RecipeServiceImp recipeServiceImp;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeServiceImp = new RecipeServiceImp(recipeRepository);
    }

    @Test
    public void getAllRecipes() {

        Recipe recipe = new Recipe();
        Set<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(recipeServiceImp.getAllRecipes()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeServiceImp.getAllRecipes();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}