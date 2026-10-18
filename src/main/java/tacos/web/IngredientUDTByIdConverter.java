package tacos.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Ingredient;
import tacos.IngredientUDT;
import tacos.TacoUDRUtils;
import tacos.data.IngredientRepository;

@Component
public class IngredientUDTByIdConverter implements Converter<String, IngredientUDT> {

    private final IngredientRepository ingredientRepo;

    public IngredientUDTByIdConverter(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public IngredientUDT convert(String id) {
        Ingredient ingredient = ingredientRepo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Unknown ingredient id: " + id));
        return TacoUDRUtils.toIngredientUDT(ingredient);
    }
}
