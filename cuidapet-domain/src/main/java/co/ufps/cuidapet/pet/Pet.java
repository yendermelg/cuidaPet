package co.ufps.cuidapet.pet;

import java.util.Objects;

public class Pet {
    private PetId petId;
    private String name;
    private double size;
    private Race race;
    private int edad;
    private Animal animal;
    private Food food;
    private Hygiene hygiene;
    private Behavior behavior;

    private Pet(PetId petId,
               String name,
               double size,
               Race race,
               int edad,
               Animal animal,
               Food food,
               Hygiene hygiene
    ){
        this.petId = Objects.requireNonNull(petId, "contentId es obligatorio");
        this.name = name;
        this.size = size;
        this.race = race;
        this.edad = edad;
        this.food = food;
        this.animal = animal;
        this.hygiene = hygiene;
        this.behavior = Behavior.NORMAL;
    }

    //Creacion objeto
    public static Pet create(String name,
                   double size,
                   Race race,
                   int edad,
                   Animal animal,
                   Food food,
                   Hygiene hygiene){
        return new Pet(PetId.generate(), name, size, race, edad, animal, food, hygiene);
    }

    //Para reconstruccion del objeto desde la persistencia
    public static Pet of(PetId petId,
                         String name,
                         double size,
                         Race race,
                         int edad,
                         Animal animal,
                         Food food,
                         Hygiene hygiene,
                         Behavior behavior){

        Pet pet = new Pet(petId, name, size, race, edad, animal, food, hygiene);
        pet.behavior = behavior;
        return pet;
    }

    //Mostrar la informacion de la mascota
    public String showInformation(){
        return "Nombre: " + this.getName() + "\n" +
               "Tamaño: " + this.getSize() + "\n" +
               "Animal: " + this.animal + "\n" +
               "Raza: " + this.getRace() + "\n" +
               "Edad: " + this.getEdad() + "\n" +
               "Comida: " + this.getFood().toString() + "\n" +
               "Higiene: " + this.getHygiene().toString() + "\n" +
               "Comportamiento: " + this.getBehavior();
    }

    public PetId getPetId() {
        return petId;
    }

    public void setPetId(PetId petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Hygiene getHygiene() {
        return hygiene;
    }

    public void setHygiene(Hygiene hygiene) {
        this.hygiene = hygiene;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }
}
