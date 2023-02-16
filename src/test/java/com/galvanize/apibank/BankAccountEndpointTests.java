package com.galvanize.apibank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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
                .andExpect(jsonPath("$.name").value("zach"))
                .andExpect(jsonPath("$.balance").value(9.99));
    }
}
