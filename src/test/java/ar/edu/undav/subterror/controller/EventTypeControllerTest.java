package ar.edu.undav.subterror.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Sol on 7/9/17.
 */
public class EventTypeControllerTest {
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
        mockMvc.perform(MockMvcRequestBuilders.get("/eventtype")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void getEventById() throws Exception {
        String id = "1";
        mockMvc.perform(MockMvcRequestBuilders.get("/eventtype/" + id))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void getEventWrongId() throws Exception {
        String id = "-1";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/eventtype/" + id))
                .andExpect(MockMvcResultMatchers.status().isNotFound()).andReturn();

        String responseBodyContent = result.getResponse().getContentAsString();

        Assert.assertEquals(String.valueOf("null"),responseBodyContent);
    }
}
