package Itog_2etap_Knyazev.mainprogramm;

import java.util.ArrayList;
import java.util.List;

public class Dog extends Animal {
    private List<String> commands = new ArrayList<>();

    public Dog(String name, int age) {
        super(name, age, "Dog");
        commands.add("Лаять");
        commands.add("Принести палку");
        commands.add("Сидеть");
    }

    @Override
    public void showCommands() {
        System.out.println("Команды собаки: " + String.join(", ", commands));
    }

    @Override
    public void learnCommand(String command) {
        commands.add(command);
        System.out.println("Собака выучила новую команду: " + command);
    }
}