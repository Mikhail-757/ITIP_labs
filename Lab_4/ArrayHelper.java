public class ArrayHelper {

    public static double calculateAverage(String[] dataArray, int expectedLength) {
        if (dataArray == null || dataArray.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым или null.");
        }

        int sum = 0;
        int count = 0;
        
        for (int i = 0; i < expectedLength; i++) {
            try {
                String element = dataArray[i].trim();
                
                int number = Integer.parseInt(element);
                
                sum += number;
                count++;
            
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.printf(
                    " Обработано исключение: Выход за границы массива при индексе [%d]. Расчет завершен.\n", 
                    i
                );
                break; 
                
            } catch (NumberFormatException e) {
                System.err.printf(
                    " Ошибка данных: Элемент по индексу [%d] не является числом. Игнорируем.\n", 
                    i
                );
            }
        }
        
        if (count == 0) {
            System.err.println(" Не удалось найти ни одного корректного числа для расчета.");
            return 0.0;
        }

        return (double) sum / count;
    }
}