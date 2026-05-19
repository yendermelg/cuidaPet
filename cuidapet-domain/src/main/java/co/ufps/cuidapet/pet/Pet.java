package co.ufps.cuidapet.pet;

public class Pet {
    private String raza;
    private String especie;

    public Pet() {
    }

    public Pet(String raza, String especie) {
        this.raza = raza;
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
