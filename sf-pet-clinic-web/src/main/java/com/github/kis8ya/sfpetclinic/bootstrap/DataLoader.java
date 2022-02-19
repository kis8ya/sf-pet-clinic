package com.github.kis8ya.sfpetclinic.bootstrap;

import com.github.kis8ya.sfpetclinic.model.Owner;
import com.github.kis8ya.sfpetclinic.model.Vet;
import com.github.kis8ya.sfpetclinic.services.OwnerService;
import com.github.kis8ya.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        String[][] ownersData = {
                {"Homyak", "Pushistyak"},
                {"Lisa", "Pushistyak"},
                {"Guy", "Bad"},
                {"Lover", "Cat"},
                {"Hater", "Cat"}
        };
        for (String[] ownerData : ownersData) {
            Owner owner = new Owner();
            owner.setFirstName(ownerData[0]);
            owner.setLastName(ownerData[1]);
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
