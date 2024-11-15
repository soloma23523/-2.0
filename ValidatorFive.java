import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

class ValidatorFive {

    // Метод для создания валидатора пользователя
    public UserValidator user() {
        return new UserValidator();
    }

    // Вложенный класс для проверки полей пользователя
    class UserValidator {
        private final Map<String, Predicate<Object>> fieldValidators = new HashMap<>();

        // Метод для задания структуры валидации
        public UserValidator shape(Map<String, Predicate<Object>> validators) {
            fieldValidators.putAll(validators);
            return this;
        }

        // Метод для проверки объекта
        public boolean isValid(Map<String, Object> userData) {
            for (Map.Entry<String, Predicate<Object>> entry : fieldValidators.entrySet()) {
                String field = entry.getKey();
                Predicate<Object> validator = entry.getValue();
                Object value = userData.get(field);

                // Если поле отсутствует или не проходит проверку
                if (value == null || !validator.test(value)) {
                    return false;
                }
            }
            return true;
        }
    }

    // Пример реализации валидатора номера телефона
    public PhoneValidator phone() {
        return new PhoneValidator();
    }

    class PhoneValidator {
        private int phoneLengthConstraint;

        public PhoneValidator setPhoneLengthConstraint(int length) {
            this.phoneLengthConstraint = length;
            return this;
        }

        public Predicate<Object> build() {
            return value -> {
                if (value instanceof String phone) {
                    return phone.startsWith("+") && phone.length() == phoneLengthConstraint + 1; // "+<номер>"
                }
                return false;
            };
        }
    }

    // Пример реализации валидатора рейтинга
    public RatingValidator getRating() {
        return new RatingValidator();
    }

    class RatingValidator {
        private boolean isHighRatingValidator;

        public RatingValidator setHighRatingValidator() {
            this.isHighRatingValidator = true;
            return this;
        }

        public Predicate<Object> build() {
            return value -> {
                if (value instanceof Double rating) {
                    return isHighRatingValidator ? rating >= 8 : rating >= 0 && rating <= 10;
                }
                return false;
            };
        }
    }
}
