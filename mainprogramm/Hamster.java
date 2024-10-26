package Itog_2etap_Knyazev.mainprogramm;

import java.util.ArrayList;
import java.util.List;

public class Hamster extends Animal {
    private List<String> commands = new ArrayList<>();

    public Hamster(String name, int age) {
        super(name, age, "Hamster");
        commands.add("Крутить колесо");
        commands.add("Есть семечки");
    }

    @Override
    public void showCommands() {
        System.out.println("Команды хомяка: " + String.join(", ", commands));
    }

    @Override
    public void learnCommand(String command) {
        commands.add(command);
        System.out.println("Хомяк выучил новую команду: " + command);
    }
}