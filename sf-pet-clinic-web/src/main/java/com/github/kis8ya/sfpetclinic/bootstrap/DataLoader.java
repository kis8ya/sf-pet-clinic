package com.github.kis8ya.sfpetclinic.bootstrap;

import com.github.kis8ya.sfpetclinic.model.*;
import com.github.kis8ya.sfpetclinic.services.*;
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
    private final String logPrefix = "DATA LOADER: ";

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    public DataLoader(
            OwnerService ownerService,
            VetService vetService,
            PetTypeService petTypeService,
            SpecialtiesService specialtiesService,
            VisitService visitService
    ) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    private void log(String message) {
        System.out.println(logPrefix + message);
    }

    private <T> T randomFromSet(Set<T> items) {
        int targetIndex = new Random().nextInt(items.size());
        int i = 0;
        for (T obj : items) {
            if (i == targetIndex) {
                return obj;
            }
            ++i;
        }
        return null;
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
        long maxDay = LocalDate.of(2022, 1, 20).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private int randomFromRange(int min, int max) {
        return (int)(Math.random() * (max - min) + min);
    }

    private Set<Pet> randomPets(Set<PetType> petTypes, Owner owner) {
        int petTypesSize = petTypes.size();
        Set<Pet> result = new HashSet<>();
        for (int petsCount = randomFromRange(MIN_PETS, MAX_PETS); petsCount > 0; --petsCount) {
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

    private Set<Speciality> randomSpecialties(Set<Speciality> specialities) {
        int specialtiesSize = specialities.size();
        final int MIN_SPECIALTIES = 1;
        Set<Speciality> result = new HashSet<>();
        for (int specialtyCount = randomFromRange(MIN_SPECIALTIES, specialtiesSize);
             specialtyCount > 0;
             --specialtyCount) {
            Speciality speciality = null;
            int targetIndex = new Random().nextInt(specialtiesSize);
            int i = 0;
            for (Speciality cur : specialities) {
                if (i == targetIndex) {
                    speciality = cur;
                }
                ++i;
            }

            if (result.contains(speciality)) {
                continue;
            }
            result.add(speciality);
        }
        return result;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        Set<PetType> petTypes = new HashSet<>();
        String[] petTypesNames = {"dog", "cat"};
        for (String petTypeName : petTypesNames) {
            PetType petType = PetType.of(petTypeName);
            petTypeService.save(petType);
            petTypes.add(petType);
        }

        Set<Speciality> specialities = new HashSet<>();
        String[][] specialtiesNames = {
                {"Cat-General", "Basic cat vet"},
                {"Cat-Watcher", "Just watching for cats"},
                {"Dog-General", "Basic dog vet"},
                {"Dog-Watcher", "Just watching for dogs"},
                {"Healer", "Can heal anyone from easy and medium injuries"},
                {"Bird-General", "Useless: there are no birds in this world"}};
        for (String[] specialtyInfo : specialtiesNames) {
            Speciality spec = new Speciality(specialtyInfo[0], specialtyInfo[1]);
            specialtiesService.save(spec);
            specialities.add(spec);
            log(spec.getId() + ": " + spec.getName());
        }

        String[][] ownersData = {
                {"Homyak", "Pushistyak", "Saint-Petersburg", "home sweet home", "7"},
                {"Lisa", "Pushistyak", "Saint-Petersburg", "home sweet home", "8"},
                {"Guy", "Bad", "Moscow", "street", "351"},
                {"Lover", "Cat", "LA", "LA St", "2"},
                {"Hater", "Cat", "Miami", "hit", "1"}
        };
        for (String[] ownerData : ownersData) {
            Owner owner = Owner.builder()
                    .firstName(ownerData[0])
                    .lastName(ownerData[1])
                    .city(ownerData[2])
                    .address(ownerData[3])
                    .telephone(ownerData[4]).build();
            Set<Pet> pets = randomPets(petTypes, owner);
            owner.setPets(pets);
            ownerService.save(owner);

            Visit visit = new Visit();
            visit.setDate(LocalDate.of(2022, 1, new Random().nextInt(20) + 1));
            visit.setDescription("Ordinary visit by " + ownerData[0]);
            visit.setPet(randomFromSet(pets));
            visitService.save(visit);
        }

        visitService.findAll().forEach(
                v -> System.out.println(v.getId() + ": Visit{description=" + v.getDescription() + "; pet=" + v.getPet().getName() + "}")
        );

        String[][] vetsData = {
                {"Psycho", "Cat"},
                {"Carer", "Dog"},
                {"Healer", "Dog"}
        };
        for (String[] vetData : vetsData) {
            Vet vet = new Vet();
            vet.setFirstName(vetData[0]);
            vet.setLastName(vetData[1]);
            Set<Speciality> specs = randomSpecialties(specialities);
            vet.setSpecialities(specs);
            vetService.save(vet);
            log(vet.getId() + ": " + vet.getLastName() + " got:");
            for (Speciality spec : specs) {
                log("  " + spec.getName());
            }
        }


    }
}
