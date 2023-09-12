import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();
        String[] data;
        char action;
        if (exp.contains(" + ")) {
            data = exp.split(" \\+ ");
            action = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");
            action = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");
            action = '*';
        } else if (exp.contains(" / ")) {
            data = exp.split(" / ");
            action = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }

        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) {
                throw new Exception("Строчку можно делить или умножать только на число");
            }
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        String result = "";

        if (action == '+') {
            result = data[0] + data[1];
        } else if (action == '*') {
            int multiplier = Integer.parseInt(data[1]);
            for (int i = 0; i < multiplier; i++) {
                result += data[0];
            }
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                result = data[0];
            } else {
                result = data[0].substring(0, index) + data[0].substring(index + data[1].length());
            }
        } else {
            int newLen = data[0].length() / Integer.parseInt(data[1]);
            result = data[0].substring(0, newLen);
        }

        if (result.length() > 40) {
            result = result.substring(0, 40) + "...";
        }

        printInQuotes(result);
    }

    static void printInQuotes(String text) {
        System.out.println("\"" + text + "\"");
    }
}
