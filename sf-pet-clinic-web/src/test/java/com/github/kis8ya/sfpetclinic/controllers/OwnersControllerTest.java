package com.github.kis8ya.sfpetclinic.controllers;

import com.github.kis8ya.sfpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


class OwnersControllerTest {

    @Mock
    OwnerService ownerService;

    OwnersController controller;
    MockMvc mockedMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new OwnersController(ownerService);
        mockedMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void listOwners() throws Exception {
        mockedMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/list"));
    }
}