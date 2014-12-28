package com.xu.friendBook.controller.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({
	 @ContextConfiguration(name = "parent", locations = "classpath:spring/spring-config.xml"),
     @ContextConfiguration(name = "child", locations = "classpath:spring/spring-mvc.xml")
})
public class FriendsListTest  {

	@Autowired
	public WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void listTest() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/list"))
				.andExpect(MockMvcResultMatchers.view().name("/user/list"))
				.andDo(MockMvcResultHandlers.print())
				.andReturn();
		
		Assert.assertNotNull(result.getModelAndView().getModel().get("user"));
	}
}
