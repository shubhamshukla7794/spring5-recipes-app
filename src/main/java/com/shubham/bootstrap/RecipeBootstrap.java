package com.shubham.bootstrap;

import com.shubham.domain.*;
import com.shubham.repositories.CategoryRepository;
import com.shubham.repositories.RecipeRepository;
import com.shubham.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){

        //-----------------------------------  I N I T I A L I Z A T I O N  --------------------------------------------

        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> teaSpoonUOMOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if (!teaSpoonUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found!!!");
        }

        Optional<UnitOfMeasure> tableSpoonUOMOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if (!tableSpoonUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found!!!");
        }

        Optional<UnitOfMeasure> cupUOMOptional = unitOfMeasureRepository.findByDescription("Cup");
        if (!cupUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found!!!");
        }

        Optional<UnitOfMeasure> pinchUOMOptional = unitOfMeasureRepository.findByDescription("Pinch");
        if (!pinchUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found!!!");
        }

        Optional<UnitOfMeasure> milligramUOMOptional = unitOfMeasureRepository.findByDescription("Milligram");
        if (!milligramUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found!!!");
        }

        Optional<UnitOfMeasure> gramUOMOptional = unitOfMeasureRepository.findByDescription("Gram");
        if (!gramUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found!!!");
        }

        Optional<UnitOfMeasure> kilogramUOMOptional = unitOfMeasureRepository.findByDescription("Kilogram");
        if (!kilogramUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found!!!");
        }

        Optional<UnitOfMeasure> smallUOMOptional = unitOfMeasureRepository.findByDescription("Small");
        if (!smallUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found!!!");
        }

        Optional<UnitOfMeasure> bigUOMOptional = unitOfMeasureRepository.findByDescription("Big");
        if (!bigUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found!!!");
        }

        UnitOfMeasure teaspoonUOM = teaSpoonUOMOptional.get();
        UnitOfMeasure tablespoonUOM = tableSpoonUOMOptional.get();
        UnitOfMeasure cupUOM = cupUOMOptional.get();
        UnitOfMeasure pinchUOM = pinchUOMOptional.get();
        UnitOfMeasure milligramUOM = milligramUOMOptional.get();
        UnitOfMeasure gramUOM = gramUOMOptional.get();
        UnitOfMeasure kilogramUOM = kilogramUOMOptional.get();
        UnitOfMeasure smallUOM = smallUOMOptional.get();
        UnitOfMeasure bigUOM = bigUOMOptional.get();

        Optional<Category> bihariCategoryOptional = categoryRepository.findByDescription("Bihari");
        if (!bihariCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found!!!");
        }

        Optional<Category> punjabiCategoryOptional = categoryRepository.findByDescription("Punjabi");
        if (!punjabiCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found!!!");
        }

        Category bihariCategory = bihariCategoryOptional.get();
        Category punjabiCategory = punjabiCategoryOptional.get();



        //-----------------------------------------------  R E C I P E S  ----------------------------------------------------

        //---------------- Aloo Bhujiya -----------------
        Recipe alooBhujiyaRecipe = new Recipe();
        alooBhujiyaRecipe.setDescription("Bihari Aloo Bhujiya");
        alooBhujiyaRecipe.setPrepTime(10);
        alooBhujiyaRecipe.setCookTime(20);
        alooBhujiyaRecipe.setDifficulty(Difficulty.EASY);
        alooBhujiyaRecipe.setDirections("1. To begin making the Bihari Aloo Bhujiya Recipe, wash potatoes with water.\n" +
                "\n" +
                "2. Cut them into lengthy pieces similar to the one for finger chips. If you don’t prefer to use the skin, peel it and then chop them into pieces\n" +
                "\n" +
                "3. In a non-stick wok, add oil. Once the oil is hot, add cumin seeds and allow it to splutter.\n" +
                "\n" +
                "4. Now, add green chilies and saute it. Stir in the chopped potatoes and turmeric powder. Season it with salt.\n" +
                "\n" +
                "5. Reduce the flame. Cook until the potatoes are cooked completely. Towards the end, when the potatoes have almost cooked, open the lid and allow it to become crispy.\n" +
                "\n" +
                "6. At this stage you can optionally add more mustard oil and then sprinkle some more salt. Ensure you keep stirring occasionally so it gets cooked from all the sides.\n" +
                "\n" +
                "7. Once done, turn off the heat and transfer to as serving bowl.\n" +
                "\n" +
                "8. Serve the Bihari Aloo Bhujiya along with Pudina Paratha, Punjabi Methi Kadhi Recipe for a wholesome weeknight dinner. ");

        Notes alooBhujiyaNotes = new Notes();
        alooBhujiyaNotes.setRecipeNotes("Bihari Aloo Bhujiya is a simple and humble recipe prepared in the households of Bihar. It requires the common ingredients available in the kitchen pantry and doesn’t involve much complex cooking techniques. It can be served as breakfast with parathas or as lunch with rice and curry. \n" +
                "\n" +
                "Serve the Bihari Aloo Bhujiya along with Pudina Paratha, Punjabi Methi Kadhi Recipe for a wholesome weeknight dinner.");

        alooBhujiyaRecipe.setNotes(alooBhujiyaNotes);

//        alooBhujiyaRecipe.getIngredients().add(new Ingredient("Potatoes",new BigDecimal(2), bigUOM, alooBhujiyaRecipe));
//        alooBhujiyaRecipe.getIngredients().add(new Ingredient("Turmeric powder (Haldi)",new BigDecimal(0.5), teaspoonUOM, alooBhujiyaRecipe));
//        alooBhujiyaRecipe.getIngredients().add(new Ingredient("Cumin seeds (Jeera)", new BigDecimal(1), teaspoonUOM, alooBhujiyaRecipe));
//        alooBhujiyaRecipe.getIngredients().add(new Ingredient("Green Chillies , slit into halves", new BigDecimal(2), smallUOM, alooBhujiyaRecipe));
//        alooBhujiyaRecipe.getIngredients().add(new Ingredient("Mustard Oil", new BigDecimal(1), tablespoonUOM, alooBhujiyaRecipe));
//        alooBhujiyaRecipe.getIngredients().add(new Ingredient("Salt", new BigDecimal(2), pinchUOM, alooBhujiyaRecipe));

        alooBhujiyaRecipe.addIngredient(new Ingredient("Potatoes",new BigDecimal(2), bigUOM));
        alooBhujiyaRecipe.addIngredient(new Ingredient("Turmeric powder (Haldi)",new BigDecimal(0.5), teaspoonUOM));
        alooBhujiyaRecipe.addIngredient(new Ingredient("Cumin seeds (Jeera)", new BigDecimal(1), teaspoonUOM));
        alooBhujiyaRecipe.addIngredient(new Ingredient("Green Chillies , slit into halves", new BigDecimal(2), smallUOM));
        alooBhujiyaRecipe.addIngredient(new Ingredient("Mustard Oil", new BigDecimal(1), tablespoonUOM));
        alooBhujiyaRecipe.addIngredient(new Ingredient("Salt", new BigDecimal(2), pinchUOM));

        alooBhujiyaRecipe.getCategories().add(bihariCategory);

        recipes.add(alooBhujiyaRecipe);



        //---------------- Aloo Paratha -----------------
        Recipe alooParathaRecipe = new Recipe();
        alooParathaRecipe.setDescription("Aloo Paratha (Potata Stuffed Paratha)");
        alooParathaRecipe.setPrepTime(15);
        alooParathaRecipe.setCookTime(45);
        alooParathaRecipe.setDifficulty(Difficulty.MODERATE);
        alooParathaRecipe.setDirections("1. To begin making the Aloo Paratha Recipe, first we will make the paratha dough. In a large bowl add in 2 cups of whole wheat flour and some salt.\n" +
                "\n" +
                "2. Use your fingers and stir in the salt into the flour. Add water a little at a time and knead to make soft, pliable paratha dough. Knead paratha dough for a couple of minutes until the dough is smooth and elastic. Use the fold press and knead motion to make the dough smooth.\n" +
                "\n" +
                "3. Next add a teaspoon of oil to coat the paratha dough and knead little more. You want a paratha dough that will be soft smooth and not sticky. Divide the dough into 8 to 10 equal portions. Cover the dough and allow the it to rest until you get the filling ready.\n" +
                "\n" +
                "4. The next step is to make the filling for the aloo parathas.\n" +
                "\n" +
                "5. Mash the potatoes into a coarse lumpy texture with your fingers or a fork.\n" +
                "\n" +
                "6. Once mashed, add in the green chillies, onions, coriander leaves, salt to taste, cumin powder, coriander powder, dry mango powder, garam masala, turmeric powder and finally if you want it extra spicy, the red chilli powder. Using your fingers again, mix all the ingredients into the potatoes until well combined.\n" +
                "\n" +
                "7. Divide the aloo paratha filling into 8 to 10 equal portions. This process of dividing and keeping the portions of aloo paratha dough and filling ready, helps you gauge the number of parathas you can make and if you need more or less of the filling.\n" +
                "\n" +
                "8. The final step is to stuff the filling into the aloo paratha dough.\n" +
                "\n" +
                "9. Dust the paratha dough in dry wheat flour, flatten it with your finger and place it on a flat surface. Roll them out thin to approximately 3 inches in diameter circle.\n" +
                "\n" +
                "10. Take a portion of filling and place it in the center. Next gather the sides of the paratha dough and bring them together. Remove the little excess dough which pops out when you bring the edges together. Press the filled aloo paratha dough down.\n" +
                "\n" +
                "11. Dust the filled aloo paratha dough in some flour and roll it gently applying very little pressure. Roll it to desired thickness and proceed the similar way with the remaining portions of paratha dough and filling.\n" +
                "\n" +
                "12. Preheat a skillet on medium heat and place the filled aloo paratha. Allow it to cook on medium heat for about 30 to 45 seconds and flip over.\n" +
                "\n" +
                "13. Add this stage add a teaspoon of ghee or oil and spread it around. Flip again, so the oiled side can cook on the skillet. Spread a little more ghee and keep pressing the parathas while on the skillet to cook the paratha evenly from inside out.\n" +
                "\n" +
                "14. Do the flipping over process a couple of times until both sides get cooked, browned and crisp evenly. Make sure you cook on medium heat as it allows the aloo parathas to get a crisp on the outside.\n" +
                "\n" +
                "15. Once the aloo paratha is cooked transfer to a plate and serve hot.\n" +
                "\n" +
                "16. Serve the Aloo Paratha along with Aam Ka Achaar Recipe or  homemade curd or Masala Chaas for your Breakfast.");

        Notes alooParathaNotes = new Notes();
        alooParathaNotes.setRecipeNotes("Aloo Paratha Recipe is a classic Spiced Indian Potato paratha made from boiled potatoes flavored with onions, green chillies, coriander. Traditionally these parathas are cooked in ghee and had with a dollop of butter. The addition of Ghee makes these parathas crispy and delicious.\n" +
                "\n" +
                "It is a staple breakfast recipe for most North Indians and the filling of these aloo parathas vary from region to region. It is simple and easy to make and you can also make it for your dinner as well or pack in your office or kids Lunch Box.\n" +
                "\n" +
                "Serve Aloo Paratha along with Aam Ka Achaar Recipe or homemade curd or Masala Chaas for your Breakfast .");


        alooParathaRecipe.setNotes(alooParathaNotes);

//        alooParathaRecipe.getIngredients().add(new Ingredient("Whole Wheat Flour", new BigDecimal(2), cupUOM, alooParathaRecipe));
//        alooParathaRecipe.getIngredients().add(new Ingredient("Salt", new BigDecimal(1), teaspoonUOM, alooParathaRecipe));
//        alooParathaRecipe.getIngredients().add(new Ingredient("Ghee", new BigDecimal(1), tablespoonUOM, alooParathaRecipe));
//        alooParathaRecipe.getIngredients().add(new Ingredient("Potatoes (Aloo) , boiled and mashed", new BigDecimal(4), bigUOM, alooParathaRecipe));
//        alooParathaRecipe.getIngredients().add(new Ingredient("Onions , finely chopped", new BigDecimal(2), bigUOM, alooParathaRecipe));
//        alooParathaRecipe.getIngredients().add(new Ingredient("Ginger , finely chopped", new BigDecimal(1), smallUOM, alooParathaRecipe));
//        alooParathaRecipe.getIngredients().add(new Ingredient("Green Chillies , finely chopped", new BigDecimal(2), smallUOM, alooParathaRecipe));
//        alooParathaRecipe.getIngredients().add(new Ingredient("Turmeric Powder (Haldi)", new BigDecimal(0.5), teaspoonUOM, alooParathaRecipe));
//        alooParathaRecipe.getIngredients().add(new Ingredient("Coriander Powder (Dhania)", new BigDecimal(1), teaspoonUOM, alooParathaRecipe));
//        alooParathaRecipe.getIngredients().add(new Ingredient("Cumin Powder (Jeera)", new BigDecimal(1), teaspoonUOM, alooParathaRecipe));
//        alooParathaRecipe.getIngredients().add(new Ingredient("Red Chilli Powder", new BigDecimal(1), teaspoonUOM, alooParathaRecipe));
//        alooParathaRecipe.getIngredients().add(new Ingredient("Garam Masala Powder", new BigDecimal(1), teaspoonUOM, alooParathaRecipe));
//        alooParathaRecipe.getIngredients().add(new Ingredient("Amchur (Dry Mango Powder)", new BigDecimal(1), teaspoonUOM, alooParathaRecipe));
//        alooParathaRecipe.getIngredients().add(new Ingredient(" Coriander (Dhania) Leaves , finely chopped", new BigDecimal(0.25), cupUOM, alooParathaRecipe));

        alooParathaRecipe.addIngredient(new Ingredient("Whole Wheat Flour", new BigDecimal(2), cupUOM));
        alooParathaRecipe.addIngredient(new Ingredient("Water", new BigDecimal(1), cupUOM));
        alooParathaRecipe.addIngredient(new Ingredient("Salt", new BigDecimal(1), teaspoonUOM));
        alooParathaRecipe.addIngredient(new Ingredient("Ghee", new BigDecimal(1), tablespoonUOM));
        alooParathaRecipe.addIngredient(new Ingredient("Potatoes (Aloo) , boiled and mashed", new BigDecimal(4), bigUOM));
        alooParathaRecipe.addIngredient(new Ingredient("Onions , finely chopped", new BigDecimal(2), bigUOM));
        alooParathaRecipe.addIngredient(new Ingredient("Ginger , finely chopped", new BigDecimal(1), smallUOM));
        alooParathaRecipe.addIngredient(new Ingredient("Green Chillies , finely chopped", new BigDecimal(2), smallUOM));
        alooParathaRecipe.addIngredient(new Ingredient("Turmeric Powder (Haldi)", new BigDecimal(0.5), teaspoonUOM));
        alooParathaRecipe.addIngredient(new Ingredient("Coriander Powder (Dhania)", new BigDecimal(1), teaspoonUOM));
        alooParathaRecipe.addIngredient(new Ingredient("Cumin Powder (Jeera)", new BigDecimal(1), teaspoonUOM));
        alooParathaRecipe.addIngredient(new Ingredient("Red Chilli Powder", new BigDecimal(1), teaspoonUOM));
        alooParathaRecipe.addIngredient(new Ingredient("Garam Masala Powder", new BigDecimal(1), teaspoonUOM));
        alooParathaRecipe.addIngredient(new Ingredient("Amchur (Dry Mango Powder)", new BigDecimal(1), teaspoonUOM));
        alooParathaRecipe.addIngredient(new Ingredient("Coriander (Dhania) Leaves , finely chopped", new BigDecimal(0.25), cupUOM));

        alooParathaRecipe.getCategories().add(punjabiCategory);

        recipes.add(alooParathaRecipe);

        //-----------------------------------------------  R E T U R N  ----------------------------------------------------

        return recipes;

    }
}
