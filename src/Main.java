import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Виберіть завдання:");
        System.out.println("1. Операції з державами");
        System.out.println("2. Операції з комплексними числами (абстрактний клас)");
        System.out.println("3. Операції з раціональними числами (абстрактний клас)");
        System.out.println("4. Операції з комплексними числами (інтерфейс)");
        System.out.println("5. Операції з раціональними числами (інтерфейс)");
        int taskChoice = scanner.nextInt();
        scanner.nextLine();

        switch (taskChoice) {
            case 1:
                System.out.print("Введіть назву держави: ");
                String name = scanner.nextLine();

                System.out.print("Введіть кількість населення: ");
                int population = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Введіть тип держави (1 - республіка, 2 - монархія, 3 - королівство): ");
                int stateType = scanner.nextInt();
                scanner.nextLine();

                if (stateType == 1) {
                    System.out.print("Введіть ім'я президента: ");
                    String president = scanner.nextLine();
                    Republic republic = new Republic(name, population, president);
                    System.out.println("\n" + republic);
                    republic.Show();
                } else if (stateType == 2) {
                    System.out.print("Введіть ім'я короля: ");
                    String king = scanner.nextLine();
                    Monarchy monarchy = new Monarchy(name, population, king);
                    System.out.println("\n" + monarchy);
                    monarchy.Show();
                } else if (stateType == 3) {
                    System.out.print("Введіть ім'я короля: ");
                    String king = scanner.nextLine();
                    System.out.print("Введіть кількість провінцій: ");
                    int provinces = scanner.nextInt();
                    Kingdom kingdom = new Kingdom(name, population, king, provinces);
                    System.out.println("\n" + kingdom);
                    kingdom.Show();
                } else {
                    System.out.println("Невірний вибір типу держави.");
                }
                break;

            case 2:
                System.out.print("Введіть дійсну та уявну частини першого комплексного числа: ");
                double real1 = scanner.nextDouble();
                double imaginary1 = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Введіть дійсну та уявну частини другого комплексного числа: ");
                double real2 = scanner.nextDouble();
                double imaginary2 = scanner.nextDouble();
                scanner.nextLine();

                DefaultPair complex1 = new DefaultComplex(real1, imaginary1);
                DefaultPair complex2 = new DefaultComplex(real2, imaginary2);

                System.out.println("Перше комплексне число: " + complex1);
                System.out.println("Друге комплексне число: " + complex2);

                System.out.println("Сума: " + complex1.add(complex2));
                System.out.println("Різниця: " + complex1.subtract(complex2));
                System.out.println("Добуток: " + complex1.multiply(complex2));
                break;

            case 3:
                System.out.print("Введіть чисельник та знаменник першого раціонального числа: ");
                int numerator1 = scanner.nextInt();
                int denominator1 = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Введіть чисельник та знаменник другого раціонального числа: ");
                int numerator2 = scanner.nextInt();
                int denominator2 = scanner.nextInt();
                scanner.nextLine();

                DefaultPair rational1 = new DefaultRational(numerator1, denominator1);
                DefaultPair rational2 = new DefaultRational(numerator2, denominator2);

                System.out.println("Перше раціональне число: " + rational1);
                System.out.println("Друге раціональне число: " + rational2);

                System.out.println("Сума: " + rational1.add(rational2));
                System.out.println("Різниця: " + rational1.subtract(rational2));
                System.out.println("Добуток: " + rational1.multiply(rational2));
                break;

            case 4:
                System.out.print("Введіть дійсну та уявну частини першого комплексного числа: ");
                double realPart1 = scanner.nextDouble();
                double imaginaryPart1 = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Введіть дійсну та уявну частини другого комплексного числа: ");
                double realPart2 = scanner.nextDouble();
                double imaginaryPart2 = scanner.nextDouble();
                scanner.nextLine();

                Pair complexNumber1 = new Complex(realPart1, imaginaryPart1);
                Pair complexNumber2 = new Complex(realPart2, imaginaryPart2);

                System.out.println("Перше комплексне число: " + complexNumber1);
                System.out.println("Друге комплексне число: " + complexNumber2);

                System.out.println("Сума: " + complexNumber1.add(complexNumber2));
                System.out.println("Різниця: " + complexNumber1.subtract(complexNumber2));
                System.out.println("Добуток: " + complexNumber1.multiply(complexNumber2));
                break;

            case 5:
                System.out.print("Введіть чисельник та знаменник першого раціонального числа: ");
                int num1 = scanner.nextInt();
                int den1 = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Введіть чисельник та знаменник другого раціонального числа: ");
                int num2 = scanner.nextInt();
                int den2 = scanner.nextInt();
                scanner.nextLine();

                Pair rationalNumber1 = new Rational(num1, den1);
                Pair rationalNumber2 = new Rational(num2, den2);

                System.out.println("Перше раціональне число: " + rationalNumber1);
                System.out.println("Друге раціональне число: " + rationalNumber2);

                System.out.println("Сума: " + rationalNumber1.add(rationalNumber2));
                System.out.println("Різниця: " + rationalNumber1.subtract(rationalNumber2));
                System.out.println("Добуток: " + rationalNumber1.multiply(rationalNumber2));
                break;

            default:
                System.out.println("Невірний вибір.");
                break;
        }

        scanner.close();
    }
}
