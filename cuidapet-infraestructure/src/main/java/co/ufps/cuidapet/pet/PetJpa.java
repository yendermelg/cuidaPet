package co.ufps.cuidapet.pet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet")
public class PetJpa{
    @Id
    @Column(name = "pet_id", length = 36, nullable = false)
    private String petId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "size", precision = 5, scale = 2, nullable = false)
    private double size;

    @Column(name = "race", length = 50, nullable = false)
    private String race;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "animal", length = 50, nullable = false)
    private String animal;

    @Column(name = "food", columnDefinition = "TEXT", nullable = false)
    private String food;

    @Column(name = "hygiene", columnDefinition = "TEXT", nullable = false)
    private String hygiene;

    @Column(name = "behavior", length = 50, nullable = false)
    private String behavior;

    public PetJpa(){
    }


    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
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

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getHygiene() {
        return hygiene;
    }

    public void setHygiene(String hygiene) {
        this.hygiene = hygiene;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }
}

