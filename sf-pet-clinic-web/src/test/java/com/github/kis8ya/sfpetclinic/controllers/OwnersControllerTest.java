package com.github.kis8ya.sfpetclinic.controllers;

import com.github.kis8ya.sfpetclinic.model.Owner;
import com.github.kis8ya.sfpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnersControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnersController controller;

    MockMvc mockedMvc;

    @BeforeEach
    void setUp() {
        when(ownerService.findAll()).thenReturn(Collections.singleton(Owner.builder().id(1L).build()));
        mockedMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void listOwners() throws Exception {
        mockedMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/list"))
                .andExpect(model().attribute("owners", hasSize(1)));
    }
}
