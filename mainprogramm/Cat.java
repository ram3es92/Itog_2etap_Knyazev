package Itog_2etap_Knyazev.mainprogramm;

import java.util.ArrayList;
import java.util.List;

public class Cat extends Animal {
    private List<String> commands = new ArrayList<>();

    public Cat(String name, int age) {
        super(name, age, "Cat");
        commands.add("Ловить мышь");
        commands.add("Мяукать");
    }

    @Override
    public void showCommands() {
        System.out.println("Команды кота: " + String.join(", ", commands));
    }

    @Override
    public void learnCommand(String command) {
        commands.add(command);
        System.out.println("Кот выучил новую команду: " + command);
    }
}