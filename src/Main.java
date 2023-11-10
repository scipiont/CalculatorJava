import java.util.*;
//calc//
class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите операцию: ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            try {
                String result = calc(input);
                System.out.println("Вывод: " + result);
            } catch (Exception e) {
                System.out.println("Вывод: throws Exception");
            }
        }
        scanner.close();
    }

    public static String calc(String input) throws Exception {
        String[] tokens;
        String operator;
        if (input.contains("+")) {
            tokens = input.split("\\+");
            operator = "+";
        } else if (input.contains("-")) {
            tokens = input.split("-");
            operator = "-";
        } else if (input.contains("*")) {
            tokens = input.split("\\*");
            operator = "*";
        } else if (input.contains("/")) {
            tokens = input.split("/");
            operator = "/";
        } else {
            throw new Exception("Неверный ввод");
        }

        if (tokens.length != 2) {
            throw new Exception("Неверный ввод");
        }

        String operand1 = tokens[0].trim();
        String operand2 = tokens[1].trim();
        boolean isRoman = isLatinNumeral(operand1) && isLatinNumeral(operand2);

        if (isRoman) {
            int num1 = latinToArabic(operand1);
            int num2 = latinToArabic(operand2);

            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new Exception("Неверный ввод для римских чисел");
            }

            int result;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new Exception("Деление на ноль");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new Exception("Неверный оператор");
            }
            return arabicToLatin(result);
        } else {
            int num1 = Integer.parseInt(operand1);
            int num2 = Integer.parseInt(operand2);

            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new Exception("Введено число меньше единицы или более десяти для арабских чисел");
            }

            int result;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new Exception("Деление на ноль");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new Exception("Неверный оператор");
            }
            return String.valueOf(result);
        }
    }

    private static String arabicToLatin(int number) {
        if (number < 1) {
            return "Неверный результат для римских чисел";
        }
        StringBuilder result = new StringBuilder();
        while (number >= 10) {
            result.append("X");
            number -= 10;
        }
        while (number >= 9) {
            result.append("IX");
            number -= 9;
        }
        while (number >= 5) {
            result.append("V");
            number -= 5;
        }
        while (number >= 4) {
            result.append("IV");
            number -= 4;
        }
        while (number >= 1) {
            result.append("I");
            number -= 1;
        }
        return result.toString();
    }

    private static int latinToArabic(String input) {
        switch (input) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                return -1;
        }
    }

    private static boolean isLatinNumeral(String input) {
        String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        return Arrays.asList(romanNumerals).contains(input);
    }
}