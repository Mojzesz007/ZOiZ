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


import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.CoreMatchers.is;

//@RunWith(SpringRunner.class)
//@SpringBootTest(
//		webEnvironment = SpringBootTest.WebEnvironment.MOCK,
//		classes = BackendApplication.class)
//@AutoConfigureMockMvc
//@TestPropertySource(
//		locations = "classpath:application-integrationtest.properties")
//public class TaskRestControllerIntegrationTest {
//
//	@Autowired
//	private MockMvc mvc;
//
//	@Autowired
//	private TaskRepository taskRepository;
//
//	@After
//	public void resetDb() {
//		taskRepository.deleteAll();
//	}
//
//	@Test
//	public void givenTasks_thenGetTasks_thenStatus200() throws Exception {
//
//		String message = "wiadomosc testowa";
//		String subject = "jakis temat";
//		createTestTask(message, subject);
//		createTestTask("m", "s");
//
//		mvc.perform(get("/tasks/all")
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(content()
//						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
//				.andExpect(jsonPath("$[0].message", is(message)))
//				.andExpect(jsonPath("$[0].subject", is(subject)))
//				.andExpect(jsonPath("$[1].message", is("m")))
//				.andExpect(jsonPath("$[1].subject", is("s")));
//	}
//
//	@Test
//	public void whenValidInput_createTask() throws Exception {
//		Task task = new Task("hmm", "yeah");
//		mvc.perform(
//				post("/tasks/add")
//						.contentType(MediaType.APPLICATION_JSON)
//						.content(JsonUtil.toJson(task)));
//
//		List<Task> found = taskRepository.findAll();
//		assertThat(found).extracting(Task::getMessage).containsOnly("hmm");
//	}
//
//	private void createTestTask(String message, String subject) {
//		Task task = new Task(message, subject);
//		taskRepository.saveAndFlush(task);
//	}
//
//}
