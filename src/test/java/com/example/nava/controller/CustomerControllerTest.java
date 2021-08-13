package com.example.nava.controller;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import com.example.nava.AbstractTest;
//import com.example.nava.model.Customer;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.List;

public class CustomerControllerTest {// extends AbstractTest {

//    @Override
//    @Before
//    public void setUp() {
//        super.setUp();
//    }
//
//    @Test
//    public void getCustomerList() throws Exception {
//        String uri = "/customers";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        List<Customer> customerList = super.mapFromJson(content, List.class);
//        assertTrue(customerList.size() > 0);
//    }
}
