package ar.edu.undav.subterror.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Sol on 7/9/17.
 */

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.test.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventControllerTest {

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    //GET Test

    @Test
    public void getAllEvents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/event")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void getEventById() throws Exception {
        String id = "1";
        mockMvc.perform(MockMvcRequestBuilders.get("/event/" + id))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void getEventWrongId() throws Exception {
        String id = "-1";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/event/" + id))
                .andExpect(MockMvcResultMatchers.status().isNotFound()).andReturn();

        String responseBodyContent = result.getResponse().getContentAsString();

        Assert.assertEquals(String.valueOf("null"),responseBodyContent);
    }

    // POST Test

    @Test
    public void saveEventNotPost() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/event"))
                .andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    }

    @Test
    public void saveEventPost() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/event"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void saveCompanyPostParams() throws Exception {
        String sense = "Destino a Plaza";
        String eventType = "9";
        String station = "11";

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/event").param("sense", sense).param("eventType", eventType).param("station",station))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andReturn();

        String responseBodyContent = result.getResponse().getContentAsString();

        System.out.println(responseBodyContent);

        Assert.assertEquals("{\"id\": 7, \"date\": 1499616384787, \"sense\": \"Destino\", \"eventType\": { \"id\": 9, \"description\": \"Demora\"}, " +
                        "\"station\": {\"id\": 8, \"line\": \"Linea E\", \"station\": \"Retiro\"}}",
                responseBodyContent);
    }
}