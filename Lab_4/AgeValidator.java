public class AgeValidator {

    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 120;

    public static void validateAge(int age) throws CustomAgeException {
        if (age < MIN_AGE || age > MAX_AGE) {
            // ИСПРАВЛЕНО: Добавлен шаблон строки форматирования (%d)
            String message = String.format(
                "Недопустимый возраст: %d. Возраст должен быть в диапазоне от %d до %d.", 
                age, MIN_AGE, MAX_AGE
            );
            throw new CustomAgeException(message);
        }
    }
}