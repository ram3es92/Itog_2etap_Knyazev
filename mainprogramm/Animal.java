package Itog_2etap_Knyazev.mainprogramm;

public abstract class Animal {
    private String name;
    private int age;
    private String species;

    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getSpecies() { return species; }

    public abstract void showCommands();
    public abstract void learnCommand(String command);
}