package seedu.address.model.ingredient;

import static seedu.address.commons.util.AppUtil.checkArgument;

import seedu.address.commons.util.StringUtil;

/**
 * A class to represent the ingredientWarningAmount in an ingredient
 */
public class IngredientWarningAmount {

    public static final String MESSAGE_CONSTRAINTS =
            "Ingredient's warning amount should be non-negative integer.";

    // Identity fields
    private int ingredientWarningAmount;

    /**
     * Constructs a {@code IngredientWarningAmount}.
     *
     * @param warningAmount A valid warningAmount, an integer that is non-negative.
     */
    public IngredientWarningAmount(int warningAmount) {
        checkArgument(isValidIngredientWarningAmount(Integer.toString(warningAmount)), MESSAGE_CONSTRAINTS);
        this.ingredientWarningAmount = warningAmount;
    }

    public int getWarningAmount() {
        return ingredientWarningAmount;
    }


    /**
     * Returns true if ingredientWarningAmount is valid.
     * @param test
     * @return
     */
    public static boolean isValidIngredientWarningAmount(String test) {
        if (StringUtil.isUnsignedInteger(test)) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean equals(Object other) {
        boolean isitEquals = other == this // short circuit if same object
            || (other instanceof IngredientWarningAmount// instanceof handles nulls
            && ingredientWarningAmount == ((IngredientWarningAmount) other).getWarningAmount()); // state check
        return isitEquals;
    }

    @Override
    public String toString() {
        return Integer.toString(ingredientWarningAmount);
    }
}
