package utils;

public class Utils {

    // Проверяем действие на соответствие
    public static String checkAction(String act) {
        if (act.equals("addition") ||
            act.equals("subtraction") ||
            act.equals("multiplication") ||
            act.equals("division")) {
            return "ok";
        } else {
            return "The action is incorrect! You need to specify action parameter: addition, subtraction, multiplication or division";
        }
    }

    // проверяем аргументы на их наличие и на соответствие дробному или целому числу
    public static String checkArgumentA(String aa) {
        if (aa.equals("no value")) {
            return "Argument Value1 is undefined!";
        } else {
            try {
                double a = Double.parseDouble(aa);
            } catch (IllegalArgumentException e) {
                return "Argument Value1 is incorrect! Integer or double number required.";
            }
            return "ok";
        }
    }

    public static String checkArgumentB(String bb) {
        if (bb.equals("no value")) {
            return "Argument Value2 is undefined.";
        }
        try {
            double b = Double.parseDouble(bb);
        } catch (IllegalArgumentException e) {
            return "Argument Value2 is incorrect! Integer or double number required.";
        }
        return "ok";
    }

    // Удаляем ноль после запятой, если результат - целое число
    public static String truncate(String res) {
        if (res.length() > 2)
            if (res.substring(res.length()-2, res.length()).equals(".0")) {
                res = res.substring(0, res.length() - 2);
            }
        return res;
    }

    // Функция округления до нужного количества знаков
    public static double round(double d, int nums) {
        double exponentiation = Math.pow(10, nums);
        return Math.round(d * exponentiation) / exponentiation;
    }

}
