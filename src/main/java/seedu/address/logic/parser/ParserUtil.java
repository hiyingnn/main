package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.booking.BookingSize;
import seedu.address.model.booking.BookingWindow;
import seedu.address.model.ingredient.IngredientName;
import seedu.address.model.ingredient.IngredientQuantity;
import seedu.address.model.ingredient.IngredientUnit;
import seedu.address.model.ingredient.IngredientWarningAmount;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.member.LoyaltyPoints;
import seedu.address.model.person.staff.Appointment;
import seedu.address.model.person.staff.Shift;
import seedu.address.model.recipe.RecipeIngredientSet;
import seedu.address.model.recipe.RecipeName;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";
    public static final String MESSAGE_INVALID_QUANTITY_IN_RECIPE =
            "Ingredient quantity in recipe should be a non-zero unsigned integer, between 1 and "
            + Integer.toString(Integer.MAX_VALUE)
            + " inclusive.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     *
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String appointment} into a {@code Appointment}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code appointment} is invalid.
     */
    public static Appointment parseAppointment(String appointment) throws ParseException {
        requireNonNull(appointment);
        String trimmedAppointment = appointment.trim();
        if (!Appointment.isValidAppointmentName(trimmedAppointment)) {
            throw new ParseException(Appointment.MESSAGE_CONSTRAINTS);
        }
        return new Appointment(trimmedAppointment);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String loyaltyPoints} into an {@code LoyaltyPoints}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code loyaltyPoints} is invalid.
     */
    public static LoyaltyPoints parseLoyaltyPoints(String loyaltyPoints) throws ParseException {
        requireNonNull(loyaltyPoints);
        String trimmedLoyaltyPoints = loyaltyPoints.trim();
        if (!LoyaltyPoints.isValidLoyaltyPoints(trimmedLoyaltyPoints)) {
            throw new ParseException(LoyaltyPoints.MESSAGE_CONSTRAINTS);
        }
        return new LoyaltyPoints(Integer.parseInt(trimmedLoyaltyPoints));
    }

    /**
     * Parses a {@code String name} into an {@code IngredientName}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static IngredientName parseIngredientName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedIngredientName = name.trim();
        if (!IngredientName.isValidIngredientName(trimmedIngredientName)) {
            throw new ParseException(IngredientName.MESSAGE_CONSTRAINTS);
        }
        return new IngredientName(trimmedIngredientName);
    }

    /**
     * Parses a {@code String quantity} into an {@code IngredientQuantity}.
     * Leading and trailing whitespaces will be trimmed.
     */

    public static IngredientQuantity parseIngredientQuantity(String quantity) throws ParseException {
        requireNonNull(quantity);
        String trimmedIngredientQuantity = quantity.trim();
        if (!IngredientQuantity.isValidIngredientQuantity(trimmedIngredientQuantity)) {
            throw new ParseException(IngredientQuantity.MESSAGE_CONSTRAINTS);
        }
        return new IngredientQuantity(Integer.parseInt(trimmedIngredientQuantity));
    }

    /**
     * Parses a {@code String unit} into an {@code IngredientUnit}.
     * Leading and trailing whitespaces will be trimmed.
     */

    public static IngredientUnit parseIngredientUnit(String unit) throws ParseException {
        requireNonNull(unit);
        String trimmedIngredientUnit = unit.trim();
        if (!IngredientUnit.isValidIngredientUnit(trimmedIngredientUnit)) {
            throw new ParseException(IngredientUnit.MESSAGE_CONSTRAINTS);
        }
        return new IngredientUnit(trimmedIngredientUnit);
    }

    /**
     * Parses a {@code String warningAmount} into an {@code IngredientWarningAmount}.
     * Leading and trailing whitespaces will be trimmed.
     */

    public static IngredientWarningAmount parseIngredientWarningAmount(String warningAmount) throws ParseException {
        requireNonNull(warningAmount);
        String trimmedWarningAmount = warningAmount.trim();
        if (!IngredientWarningAmount.isValidIngredientWarningAmount(trimmedWarningAmount)) {
            throw new ParseException(IngredientWarningAmount.MESSAGE_CONSTRAINTS);
        }
        return new IngredientWarningAmount(Integer.parseInt(trimmedWarningAmount));
    }

    /**
     * Parses a {@code String name} into an {@code RecipeName}.
     * Leading and trailing whitespaces will be trimmed.
     */
    public static RecipeName parseRecipeName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedRecipeName = name.trim();
        if (!RecipeName.isValidRecipeName(trimmedRecipeName)) {
            throw new ParseException(RecipeName.MESSAGE_CONSTRAINTS);
        }
        return new RecipeName(trimmedRecipeName);
    }

    /**
     * Parses a {@code String quantity} into an {@code IngredientQuantity}.
     * Leading and trailing whitespaces will be trimmed.
     */

    public static IngredientQuantity parseIngredientQuantityInRecipe(String quantity) throws ParseException {
        requireNonNull(quantity);
        String trimmedIngredientQuantity = quantity.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(quantity)) {
            throw new ParseException(MESSAGE_INVALID_QUANTITY_IN_RECIPE);
        }
        return new IngredientQuantity(Integer.parseInt(trimmedIngredientQuantity));
    }

    /**
     * Parses a {@code Collection<String> pairs} into an {@code Set<Pair<Index, IngredientQuantity>>}.
     * Each string is split by the '&'.
     * If '&' symbol not present, or there are more than 1 '&' symbols, ParseException is thrown.
     * Index and IngredientQuantity is parsed, and if fail format, ParseException is also thrown.
     */
    public static Map<Index, IngredientQuantity>
        parseRecipeIngredientSet(Collection<String> ingredsToSplit) throws ParseException {

        requireNonNull(ingredsToSplit);
        final Map<Index, IngredientQuantity> ingredientSet = new HashMap<>();
        Set<Index> indexSet = new HashSet<>();
        for (String ingred : ingredsToSplit) {
            try {
                String[] ingredValues = ingred.split("&");
                if (ingredValues.length != 2) {
                    throw new ParseException(RecipeIngredientSet.MESSAGE_CONSTRAINTS_GENERAL);
                }
                Index index = parseIndex(ingredValues[0]);
                if (indexSet.contains(index)) {
                    throw new ParseException(RecipeIngredientSet.MESSAGE_CONSTRAINTS_NO_DUPLICATE_INGREDIENT);
                } else {
                    indexSet.add(index);
                }
                IngredientQuantity qty = parseIngredientQuantityInRecipe(ingredValues[1]);
                ingredientSet.put(index, qty);
            } catch (ParseException e) {
                throw e;
            }
        }
        return ingredientSet;
    }


    /**
     * Creates a new BookingWindow object that parses the time. Uses the yyyy-MM-dd HH:mm format.
     * For example, 2011-12-03 10:15
     */
    public static BookingWindow parseBookingWindow(String time) throws ParseException {
        requireNonNull(time);
        String trimmedTime = time.trim();
        try {
            return new BookingWindow(trimmedTime);
        } catch (IllegalArgumentException e) {
            throw new ParseException(BookingWindow.MESSAGE_CONSTRAINTS);
        }
    }

    /**
     * Parses a {@code String bookingSize} into a {@code BookingSize}.
     */
    public static BookingSize parseBookingSize(String bookingSize) throws ParseException {
        requireNonNull(bookingSize);
        String trimmedBookingSize = bookingSize.trim();
        try {
            return new BookingSize(trimmedBookingSize);
        } catch (IllegalArgumentException e) {
            throw new ParseException(BookingSize.MESSAGE_CONSTRAINTS);
        }
    }

    /**
     * Parses a {@code String dayOfWeek} into a {@code DayOfWeek}.
     */
    public static DayOfWeek parseDayOfWeek(String dayOfWeek) throws ParseException {
        requireNonNull(dayOfWeek);
        String trimmedDayOfWeek = dayOfWeek.trim();
        try {
            return DayOfWeek.valueOf(trimmedDayOfWeek);
        } catch (IllegalArgumentException e) {
            throw new ParseException(Shift.MESSAGE_CONSTRAINTS);
        }
    }

    /**
     * Parses a {@code String time} into a {@code LocalTime}.
     */
    public static LocalTime parseTime(String time) throws ParseException {
        requireNonNull(time);
        String trimmedTime = time.trim();
        try {
            return LocalTime.parse(trimmedTime);
        } catch (DateTimeParseException e) {
            throw new ParseException(Shift.MESSAGE_CONSTRAINTS);
        }
    }

    /**
     * Creates a new Shift object that parses the shift.
     */
    public static Shift parseShift(DayOfWeek startDayOfWeek, LocalTime startTime,
                                   DayOfWeek endDayOfWeek, LocalTime endTime) throws ParseException {
        requireNonNull(startDayOfWeek);
        requireNonNull(startTime);
        requireNonNull(endDayOfWeek);
        requireNonNull(endTime);
        if (!Shift.isValidShift(startDayOfWeek, startTime, endDayOfWeek, endTime)) {
            throw new ParseException(String.format(Shift.MESSAGE_CONSTRAINTS));
        }
        return new Shift(startDayOfWeek, startTime, endDayOfWeek, endTime);
    }
}
