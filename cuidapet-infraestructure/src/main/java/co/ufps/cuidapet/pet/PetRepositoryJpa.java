package co.ufps.cuidapet.pet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

public class PetRepositoryJpa implements IPetRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pet save(Pet pet){
        PetJpa petJpa = toEntity(pet);
        entityManager.merge(petJpa);
        return pet;
    }

    @Override
    public List<Pet> buscarTodas(){
        return entityManager.createQuery(
                "SELECT pj FROM PetJpa pj ORDER BY pj.name ASC",
                PetJpa.class)
                .getResultList()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Optional<Pet> buscarId(PetId petId){
        entityManager.createQuery(
                "SELECT pj.name, pj.race, pj.animal FROM PetJpa pj WHERE pj.petId = :id" , Pet.class
        ).setParameter("id", petId.value());

        return Optional.empty();
    }

    @Override
    public boolean existeId(PetId petId){
        Long count = entityManager.createQuery(
                "SELECT COUNT(pj) FROM PetJpa pj WHERE pj.petId = :id" , Long.class
        ).setParameter("id", petId.value()).getSingleResult();

        return count>0;
    }

    @Override
    public int borrar(PetId petId){return 0;}

    //Pasar dominio a jpa
    private PetJpa toEntity(Pet pet){
        PetJpa petJpa = new PetJpa();

        petJpa.setPetId(pet.getPetId().value());
        petJpa.setName(pet.getName());
        petJpa.setSize(pet.getSize());
        petJpa.setRace(pet.getRace().toString());
        petJpa.setEdad(pet.getEdad());
        petJpa.setAnimal(pet.getAnimal().toString());
        petJpa.setFood(pet.getFood().toString());
        petJpa.setHygiene(pet.getHygiene().toString());
        petJpa.setBehavior(pet.getBehavior().toString());

        return petJpa;

    }
// Pasa de jpa a dominio
    private Pet toDomain(PetJpa petJpa){
        return Pet.of(
                PetId.of(petJpa.getPetId()),
                petJpa.getName(),
                petJpa.getSize(),
                Race.valueOf(petJpa.getRace()),
                petJpa.getEdad(),
                Animal.valueOf(petJpa.getAnimal()),
                Food.of(petJpa.getFood()),
                Hygiene.of(petJpa.getHygiene()),
                Behavior.valueOf(petJpa.getBehavior())
        );
    }
}

