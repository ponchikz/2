public class Main {

    static String[][] arrayDataException = {{"7", "5", "1", "8"}, {"7", "1", "1", "8"}, {"9", "1", "5", "8"}, {"5", "5", "7", "8"}};
    static String[][] arraySizeException = {{"1", "8", "7"}, {"1", "7", "9"}, {"9", "6", "6"}, {"5", "6", "2"}};
    static String[][] arrayErrorException = {{"1", "8", "7", "1"}, {"1", "4", "k", "7"}, {"9", "6", "6", "1"}, {"5", "6", "2", "7"}};

    static int sizeA = 4;
    static int sizeB = 4;

    public static void main(String[] args) {

        try {
            System.out.println("Сумма массива: " + getSumm(arrayDataException));
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Сумма массива: " + getSumm(arraySizeException));
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Сумма массива: " + getSumm(arrayErrorException));
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }
    static Integer getSumm(String[][] array) throws MyArrayDataException, MyArraySizeException {
        checkValue(array);
        Integer result = 0;
        int i = 0;
        int j = 0;
        try {
            for (; i < array.length; i++) {
                j = 0;
                for (; j < array.length; j++) {
                    result = result + Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException ex) {
            throw new MyArrayDataException("Ошибка в позиции: " + i + "," + j);
        }

        return result;
    }
    static void checkValue(String[][] array) throws MyArraySizeException {
        if (array.length != sizeA || array[0].length != sizeB) throw new MyArraySizeException();
    }
}



