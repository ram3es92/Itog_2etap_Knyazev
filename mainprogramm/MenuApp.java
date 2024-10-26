package Itog_2etap_Knyazev.mainprogramm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuApp {
    private List<Animal> animals = new ArrayList<>();
    private final Counter counter = new Counter();

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nМеню:\n1. Завести новое животное\n2. Посмотреть команды животного\n3. Обучить новое команды\n4. Выход");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> addNewAnimal();
                    case 2 -> showCommands();
                    case 3 -> learnCommand();
                    case 4 -> { System.out.println("Выход из программы."); return; }
                    default -> System.out.println("Неверный выбор, попробуйте еще раз.");
                }
            }
        }
    }

    private void addNewAnimal() {
        try (counter) { // try-with-resources
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Введите имя животного: ");
                String name = scanner.nextLine();
                System.out.print("Введите возраст животного: ");
                int age = scanner.nextInt();
                System.out.print("Введите тип животного (Dog/Cat/Hamster): ");
                String type = scanner.next();

                Animal animal;
                switch (type.toLowerCase()) {
                    case "dog" -> animal = new Dog(name, age);
                    case "cat" -> animal = new Cat(name, age);
                    case "hamster" -> animal = new Hamster(name, age);
                    default -> {
                        System.out.println("Неизвестный тип животного.");
                        return;
                    }
                }
                animals.add(animal);
            }
            counter.add();
            System.out.println("Животное добавлено.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void showCommands() {
        if (animals.isEmpty()) {
            System.out.println("Нет зарегистрированных животных.");
            return;
        }
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " - " + animal.getSpecies());
            animal.showCommands();
        }
    }

    private void learnCommand() {
        if (animals.isEmpty()) {
            System.out.println("Нет зарегистрированных животных.");
            return;
        }
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите имя животного, которое хотите обучить: ");
            String name = scanner.nextLine();
            for (Animal animal : animals) {
                if (animal.getName().equalsIgnoreCase(name)) {
                    System.out.print("Введите новую команду: ");
                    String command = scanner.nextLine();
                    animal.learnCommand(command);
                    return;
                }
            }
        }
        System.out.println("Животное не найдено.");
    }
}