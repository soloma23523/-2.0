import javax.xml.validation.Validator;

public class ValidatorThree {
    public RatingValidator getRating() {
        return new RatingValidator();
    }

    class RatingValidator {
        // Метод для проверки допустимости рейтинга
        public boolean isValid(Object rating) {
            // Проверка, является ли входное значение числом
            if (rating instanceof Double || rating instanceof Integer) {
                double value = ((Number) rating).doubleValue();
                return value >= 1 && value <= 10; // Проверка диапазона от 1 до 10 включительно
            }
            return false; // Если не число, возвращаем false
        }
    }

    class Validator {

        public RatingValidator getRating() {
            return new RatingValidator();
        }

        class RatingValidator {
            // Метод для проверки допустимости рейтинга
            public boolean isValid(Object rating) {
                // Проверка, является ли входное значение числом
                if (rating instanceof Double || rating instanceof Integer) {
                    double value = ((Number) rating).doubleValue();
                    return value >= 1 && value <= 10; // Проверка диапазона от 1 до 10 включительно
                }
                return false; // Если не число, возвращаем false
            }
        }
    }
}
