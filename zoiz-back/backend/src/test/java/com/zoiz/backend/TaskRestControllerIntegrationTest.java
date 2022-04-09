package com.zoiz.backend;

import com.zoiz.backend.models.Task;
import com.zoiz.backend.repository.TaskRepository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.MOCK,
		classes = BackendApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
		locations = "classpath:application-integrationtest.properties")
public class TaskRestControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private TaskRepository taskRepository;

	@After
	public void resetDb() {
		taskRepository.deleteAll();
	}

	@Test
	public void givenTasks_thenGetTasks_thenStatus200() throws Exception {

		String message = "wiadomosc testowa";
		String subject = "jakis temat";
		createTestTask(message, subject);

		mvc.perform(get("/tasks/all")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].message", is(message)))
				.andExpect(jsonPath("$[0].subject", is(subject)));
	}

	private void createTestTask(String message, String subject) {
		Task task = new Task(message, subject);
		taskRepository.saveAndFlush(task);
	}

}
