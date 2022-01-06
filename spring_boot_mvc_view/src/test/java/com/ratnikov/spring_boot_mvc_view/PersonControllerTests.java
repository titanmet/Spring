package com.ratnikov.spring_boot_mvc_view;

import com.ratnikov.spring_boot_mvc_view.rest.PersonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonController personController;


    @Test
    public void contextLoads() throws Exception {
        assertThat(personController).isNotNull();
    }

    @Test
    void test() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());

    }

}
