package com.shubham.bootstrap;

import com.shubham.domain.*;
import com.shubham.repositories.CategoryRepository;
import com.shubham.repositories.RecipeRepository;
import com.shubham.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
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
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
        log.debug("Loading Bootstrap Data");
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

        Optional<Category> fastFoodCategoryOptional = categoryRepository.findByDescription("Fast Food");
        if (!fastFoodCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found!!!");
        }

        Category bihariCategory = bihariCategoryOptional.get();
        Category punjabiCategory = punjabiCategoryOptional.get();
        Category fastFoodCategory = fastFoodCategoryOptional.get();



        //-----------------------------------------------  R E C I P E S  ----------------------------------------------------

        //---------------- Aloo Bhujiya -----------------
        Recipe alooBhujiyaRecipe = new Recipe();
        alooBhujiyaRecipe.setDescription("Bihari Aloo Bhujiya");
        alooBhujiyaRecipe.setPrepTime(10);
        alooBhujiyaRecipe.setCookTime(20);
        alooBhujiyaRecipe.setDifficulty(Difficulty.EASY);
        alooBhujiyaRecipe.setServings(2);
        alooBhujiyaRecipe.setUrl("https://www.archanaskitchen.com/bihari-aloo-ki-bhujiya-recipe");
        alooBhujiyaRecipe.setSource("Archana's Kitchen");
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
        alooParathaRecipe.setServings(4);
        alooParathaRecipe.setUrl("https://www.archanaskitchen.com/aloo-parathas-spiced-indian-potato-flat-bread");
        alooParathaRecipe.setSource("Archana's Kitchen");
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


        //---------------- Litti Chokha -----------------
        Recipe littiChokha = new Recipe();
        littiChokha.setDescription("Litti Chokha");
        littiChokha.setPrepTime(45);
        littiChokha.setCookTime(60);
        littiChokha.setDifficulty(Difficulty.MODERATE);
        littiChokha.setServings(4);
        littiChokha.setUrl("https://www.archanaskitchen.com/traditional-bihari-litti-chokha-recipe");
        littiChokha.setSource("Archana's Kitchen");
        littiChokha.setDirections("1. To begin making the Traditional Bihari Litti Chokha Recipe, we will first get all the ingredients ready and keep it by the aside. \n" +
                "\n" +
                "2. In a large mixing bowl, sieve flour, salt and baking soda in a large bowl. Add ajwain and ghee and mix everything well until you get coarse crumbs. Add warm water little at a time and knead to make a firm dough and smooth dough. \n" +
                "\n" +
                "3. Cover the dough in a wet muslin cloth and keep aside for 20 minutes.\n" +
                "\n" +
                "4. While the dough is resting, we will prepare the filling (pitti)\n" +
                "\n" +
                "5. In a large mixing bowl, mix sattu, ajwain, kalonji, fennel seeds, mustard oil, grated ginger, garlic, green chilies, coriander, salt and lemon juice. Stir well to combine all the ingredients. Check the salt and spices and adjust to suit your taste. If you find the mixture too dry, add a little water to make a lumpy mix (which is still dry and not completely wet).\n" +
                "\n" +
                "6. Keep this pitti mixture aside.\n" +
                "\n" +
                "7. The final step is to make the Litti. \n" +
                "\n" +
                "8. Place the rested dough on a flat counter and knead again for 5 minutes. \n" +
                "\n" +
                "9. Make small lemon sized balls from the dough and roll it like pooris. Hold the poori between your palm and fill 1 large tablespoon of pitti-sattu filling mixture into the dough.\n" +
                "\n" +
                "10. Gather the sides of the poori and bring them together on top and seal the ball. Press the ball gently to flatten it.\n" +
                "\n" +
                "11. Proceed to make Litti balls the similar way and arrange them on a greased baking sheet. Brush the litti with ghee, so the tops get crisp while baking.\n" +
                "\n" +
                "12. Preheat the oven to 180 C. Once the oven is preheated, place place the litti tray on the middle rack and bake the littis till golden in color. Different ovens have different heating times - it an take anywhere between 20 to 30 minutes to bake and turn golden completely.\n" +
                "\n" +
                "13. Once baked, remove the Litti from the oven and allow them to cool a bit before serving. \n" +
                "\n" +
                "14. Serve the Litti Chokha along with Aloo Choka and Baingan (Choka) Bharta, Yogurt & Pickled Green Chilies for lunch or dinner.");

        Notes littiChokhaNotes = new Notes();
        littiChokhaNotes.setRecipeNotes("Litti is a snack food found in India's Bihar  and Nepalese state of Madhesh. It consists of wheat and sattu combined along with spiced and stuffed into maida balls and deep fried in ghee or baked in the oven.\n" +
                "\n" +
                "It can be eaten with yogurt, baigan bharta, alu bharta, and papad. The litti are traditionally baked over a cow-dung fire, but you can either deep fry the littis or bake it in the oven.\n" +
                "\n" +
                "Serve the Litti Chokha along with Aloo Choka and Baingan (Choka) Bharta, Yogurt & Pickled Green Chilies for lunch or dinner.");


        littiChokha.setNotes(littiChokhaNotes);

        littiChokha.addIngredient(new Ingredient("Whole Wheat Flour", new BigDecimal(3.5), cupUOM));
        littiChokha.addIngredient(new Ingredient("Ghee", new BigDecimal(0.75), cupUOM));
        littiChokha.addIngredient(new Ingredient("Baking Soda", new BigDecimal(0.3), teaspoonUOM));
        littiChokha.addIngredient(new Ingredient("Curd", new BigDecimal(2), tablespoonUOM));
        littiChokha.addIngredient(new Ingredient("Ajwain (Carom seeds)", new BigDecimal(1), teaspoonUOM));
        littiChokha.addIngredient(new Ingredient("Salt", new BigDecimal(1), teaspoonUOM));
        littiChokha.addIngredient(new Ingredient("Lukewarm Water", new BigDecimal(2), cupUOM));
        littiChokha.addIngredient(new Ingredient("Roasted Gram Flour (Sattu Ka Atta)", new BigDecimal(1.5), cupUOM));
        littiChokha.addIngredient(new Ingredient("Ginger , grated", new BigDecimal(1), smallUOM));
        littiChokha.addIngredient(new Ingredient("Garlic , grated", new BigDecimal(2), smallUOM));
        littiChokha.addIngredient(new Ingredient("Green Chillies , finely chopped", new BigDecimal(2), smallUOM));
        littiChokha.addIngredient(new Ingredient("Coriander (Dhania) Leaves", new BigDecimal(1), smallUOM));
        littiChokha.addIngredient(new Ingredient("Kalonji (Onion Nigella Seeds)", new BigDecimal(0.5), teaspoonUOM));
        littiChokha.addIngredient(new Ingredient("Fennel seeds (Saunf)", new BigDecimal(0.5), teaspoonUOM));
        littiChokha.addIngredient(new Ingredient("Mustard oil", new BigDecimal(1), tablespoonUOM));
        littiChokha.addIngredient(new Ingredient("Lemon juice", new BigDecimal(1), teaspoonUOM));

        littiChokha.getCategories().add(bihariCategory);
        littiChokha.getCategories().add(fastFoodCategory);

        recipes.add(littiChokha);


        //-----------------------------------------------  R E T U R N  ----------------------------------------------------

        return recipes;

    }
}
