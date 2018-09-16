import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    long[] numbers = new long[5];

    String numbersString = scanner.nextLine();
    numbers = getNumbers(numbersString);

    long smallestValue = -1;
    long biggestValue = -1;

    for (long number : numbers) {
      if (!isInputValid(number)) {
        return;
      }
    }

    long total = 0;
    for (int i = 0; i < numbers.length; i++) {
      total += numbers[i];
    }

    long[] values = new long[numbers.length];
    for (int i = 0; i < 5; i++) {
      values[i] = total - numbers[i];
    }

    smallestValue = values[0];
    biggestValue = values[0];
    for (int i = 0; i < values.length - 1; i++) {
      if (smallestValue > values[i + 1]) {
        smallestValue = values[i + 1];
      }
      if (biggestValue < values[i + 1]) {
        biggestValue = values[i + 1];
      }
    }
    System.out.println(smallestValue + " " + biggestValue);
  }

  private static long[] getNumbers(String numbersString) {
    String[] numbersInString = numbersString.split(" ");
    long[] numbers = new long[numbersInString.length];
    for (int i = 0; i < numbersInString.length; i++) {
      numbers[i] = Long.parseLong(numbersInString[i]);
    }
    return numbers;
  }

  private static boolean isInputValid(long value) {
    return (value >= 1 && value <= Math.pow(10, 9));
  }

}
