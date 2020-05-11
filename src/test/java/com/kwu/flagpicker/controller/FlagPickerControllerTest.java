package com.kwu.flagpicker.controller;

import com.kwu.flagpicker.model.Continents;
import com.kwu.flagpicker.model.Countries;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class FlagPickerControllerTest extends AbstractTest {
   @Override
    @Before
   public void setUp(){
       super.setUp();
   }

    @Test
    public void testGetAllContinents() throws Exception{
        String uri = "/flagpicker/v1/continent";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Continents[] continentsList = super.mapFromJson(content,Continents[].class);
        assertTrue(continentsList.length>0);
    }

    @Test
    public void testgetAllContinents() throws Exception{
        String uri = "/flagpicker/v1/countries/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Countries[] countriesList = super.mapFromJson(content,Countries[].class);
        assertTrue(countriesList.length>0);
    }
}
