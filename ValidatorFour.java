class ValidatorFour {

    class RatingValidator {
        private boolean isHighRatingValidator = false;

        // Метод проверки рейтинга
        public boolean isValid(double rating) {
            if (isHighRatingValidator) {
                return rating >= 8;
            }
            return rating >= 0 && rating <= 10; // Предполагаем диапазон допустимых рейтингов
        }

        // Метод для установки проверки на "высокий" рейтинг
        public RatingValidator setHighRatingValidator() {
            this.isHighRatingValidator = true;
            return this;
        }
    }

    // Метод для получения экземпляра валидатора рейтинга
    public RatingValidator getRating() {
        return new RatingValidator();
    }
}
