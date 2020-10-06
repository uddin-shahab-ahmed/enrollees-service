package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.DependantController;
import com.example.demo.controller.FrontController;
import com.example.demo.model.Dependent;
import com.example.demo.service.DependentService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DependantController.class)
public class DependentTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    private DependentService dependentService;
	
	@Test
	public void getAllEnrollees() throws Exception {
		String uri = "/dependents/getAll";
		// may need to mock service..

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Dependent[] dependentList = mapFromJson(content, Dependent[].class);
		assertTrue(dependentList.length > 0);
	}
	
	@Test
	public void getEnrollee() throws Exception {
		String uri = "/dependents/get/123";
		// may need to mock service..

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Dependent dependent = mapFromJson(content, Dependent.class);

	}
	
	@Test
	public void addEnrollees() throws Exception{
		String uri = "/dependents/add/123";
		// may need to mock service..

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}
	
	@Test
	public void modifyDependant() throws Exception{
		String uri = "/dependents/modify/123";
		// may need to mock service..

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Dependent dependent = mapFromJson(content, Dependent.class);
	}
	
	@Test
	public void deleteEnrollee() throws Exception {
		String uri = "/dependents/delete/123";
		// may need to mock service..

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}
	
}
