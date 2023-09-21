package com.example.springapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringappApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

   
 

	@Test
	public void testGetOne() throws Exception {
		int id = 1000;
		mockMvc.perform(MockMvcRequestBuilders.get("/movies/{id}", id)) // Corrected path variable to {id}
				.andExpect(status().isOk());
	}
	

@Test
public void testGetOneByAuthor() throws Exception {
    // Uncomment the lines below and add your test logic:
    String director = "Willam";
    mockMvc.perform(MockMvcRequestBuilders.get("/movies/directors/{director}", director ))
            .andExpect(status().isOk());
}

@Test
public void testGetOneByYear() throws Exception {
    // Uncomment the lines below and add your test logic:
    int year = 1999;
    mockMvc.perform(MockMvcRequestBuilders.get("/movies/year/{year}", year ))
            .andExpect(status().isOk());
}


@Test
void testGetAll() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/movies") // Corrected path from "/moives" to "/movies"
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andReturn();
}


    
}
