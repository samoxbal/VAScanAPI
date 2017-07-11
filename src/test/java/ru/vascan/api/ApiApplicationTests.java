package ru.vascan.api;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ru.vascan.api.repositories.UserRepository;
import ru.vascan.api.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApiApplication.class)
@SpringBootTest
public class ApiApplicationTests {

    @Autowired
    private UserRepository userService;

	private MockMvc mockMvc;

	@Autowired
    private WebApplicationContext wac;

	@Before
	public void init() {
        this.mockMvc = MockMvcBuilders
				.webAppContextSetup(wac)
				.build();
        userService.deleteAll();
        User mockUser = new User("123", "7805382@mail.ru", "d9d1b168eac8f197e0576b56cfc23ece");
        userService.save(mockUser);
	}

	@Test
	public void testTokenQueryWithoutBody() throws Exception {
		mockMvc
			.perform(MockMvcRequestBuilders.post("/token/"))
			.andExpect(status().is(400));
	}

	@Test
	public void testGenerateToken() throws Exception {
	    mockMvc
            .perform(MockMvcRequestBuilders.post("/token/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"email\" : \"7805382@mail.ru\", \"password\" : \"gfhjkm\" }"))
            .andExpect(status().isOk());
    }
}
