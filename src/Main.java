import java.util.*;
///calc///
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
            if (result < 1) {
                throw new Exception("Неверный результат для римских чисел");
            }
            return arabicTolatin(result);
        } else {
            int num1 = Integer.parseInt(operand1);
            int num2 = Integer.parseInt(operand2);
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

    private static String arabicTolatin(int number) {
        if (number < 1 || number > 10) {
            return "";
        }
        return switch (number) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            case 10 -> "X";
            default -> "";
        };
    }

    private static boolean isLatinNumeral(String input) {
        String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        return Arrays.asList(romanNumerals).contains(input);
    }
}
