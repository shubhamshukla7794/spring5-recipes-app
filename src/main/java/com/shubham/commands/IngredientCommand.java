package com.shubham.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
    private Long id;
    private Long recipeId;

    @NotBlank
    @Size(min = 3, max = 255)
    private String description;

    @Min(1)
    @Max(999)
    private BigDecimal amount;
    private UnitOfMeasureCommand unitOfMeasure;
}
