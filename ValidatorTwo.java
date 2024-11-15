class ValidatorTwo {
    private int minLength;
    private int maxLength;

    // Метод для задания минимальной и максимальной длины номера телефона
    public ValidatorTwo setPhoneLengthConstraint(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        return this;
    }

    // Метод для проверки корректности номера
    public boolean isValid(String phoneNumber) {
        if (!phoneNumber.startsWith("+")) {
            return false; // Номер должен начинаться с '+'
        }

        int length = phoneNumber.length() - 1; // Исключаем '+'
        return length >= minLength && length <= maxLength;
    }
}