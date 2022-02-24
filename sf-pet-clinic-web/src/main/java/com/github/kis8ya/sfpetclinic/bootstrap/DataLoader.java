package com.github.kis8ya.sfpetclinic.bootstrap;

import com.github.kis8ya.sfpetclinic.model.Owner;
import com.github.kis8ya.sfpetclinic.model.Pet;
import com.github.kis8ya.sfpetclinic.model.PetType;
import com.github.kis8ya.sfpetclinic.model.Vet;
import com.github.kis8ya.sfpetclinic.services.OwnerService;
import com.github.kis8ya.sfpetclinic.services.PetTypeService;
import com.github.kis8ya.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class DataLoader  implements CommandLineRunner {

    private final int MAX_PETS = 3;
    private final int MIN_PETS = 1;

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    private String randomString() {
        int minLen = 3;
        int maxLen = 10;

        return new Random().ints('a', 'z')
                .limit((int)(Math.random() * (maxLen - minLen) + minLen))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private LocalDate randomDate() {
        long minDay = LocalDate.of(1980, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2022, 1, 31).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private Set<Pet> randomPets(Set<PetType> petTypes, Owner owner) {
        int petTypesSize = petTypes.size();
        Set<Pet> result = new HashSet<>();
        for (int petsCount = (int)(Math.random() * (MAX_PETS - MIN_PETS) + MIN_PETS); petsCount > 0; --petsCount) {
            PetType type = null;
            int typeIndex = new Random().nextInt(petTypesSize);
            int i = 0;
            for (PetType curType : petTypes) {
                if (i == typeIndex) {
                    type = curType;
                }
                ++i;
            }

            result.add(new Pet(type, owner, randomDate(), randomString()));
        }
        return result;
    }

    @Override
    public void run(String... args) throws Exception {
        Set<PetType> petTypes = new HashSet<>();
        PetType dog = PetType.of("dog");
        petTypeService.save(dog);
        petTypes.add(dog);
        PetType cat = PetType.of("cat");
        petTypeService.save(cat);
        petTypes.add(cat);

        String[][] ownersData = {
                {"Homyak", "Pushistyak", "Saint-Petersburg", "home sweet home", "7"},
                {"Lisa", "Pushistyak", "Saint-Petersburg", "home sweet home", "8"},
                {"Guy", "Bad", "Moscow", "street", "351"},
                {"Lover", "Cat", "LA", "LA St", "2"},
                {"Hater", "Cat", "Miami", "hit", "1"}
        };
        for (String[] ownerData : ownersData) {
            Owner owner = new Owner();
            owner.setFirstName(ownerData[0]);
            owner.setLastName(ownerData[1]);
            owner.setCity(ownerData[2]);
            owner.setAddress(ownerData[3]);
            owner.setTelephone(ownerData[4]);
            owner.setPets(randomPets(petTypes, owner));
            ownerService.save(owner);
        }

        String[][] vetsData = {
                {"Psycho", "Cat"},
                {"Carer", "Dog"},
                {"Healer", "Dog"}
        };
        for (String[] vetData : vetsData) {
            Vet vet = new Vet();
            vet.setFirstName(vetData[0]);
            vet.setLastName(vetData[1]);
            vetService.save(vet);
        }
    }
}
