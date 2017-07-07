package ru.vascan.api;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApiApplication.class)
@SpringBootTest
public class ApiApplicationTests {

	private MockMvc mockMvc;

	@Autowired
    private WebApplicationContext wac;

	@Before
	public void init() {
        this.mockMvc = MockMvcBuilders
				.webAppContextSetup(wac)
				.build();
	}

	@Test
	public void testExperimentsQuery() {

	}
}
