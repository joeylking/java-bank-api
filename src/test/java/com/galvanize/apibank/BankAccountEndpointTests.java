package com.galvanize.apibank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest
public class BankAccountEndpointTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void bankAccountWithIdReturnsBankAccount() throws Exception{
        mockMvc.perform(get("/api/bankaccount/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("Zach"))
                .andExpect(jsonPath("$.balance").value(9.99));
    }

    @Test
    void addNewBankAccount() throws Exception{
        String json = "{ \"id\": \"4\", \"name\": \"Joey\", \"balance\": \"0.99\" }";
        mockMvc.perform(post("/api/bankaccount/add").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print())
                .andExpect(status().isCreated());
        mockMvc.perform(get("/api/bankaccount/4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.name").value("Joey"))
                .andExpect(jsonPath("$.balance").value(0.99));

    }
}
