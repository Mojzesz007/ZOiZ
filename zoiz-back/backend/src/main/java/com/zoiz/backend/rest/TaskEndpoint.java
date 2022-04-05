package com.zoiz.backend.rest;

import com.zoiz.backend.models.Task;
import com.zoiz.backend.repository.TaskRepository;
import com.zoiz.backend.service.TaskService;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskEndpoint {
    private final TaskService taskService;

    public TaskEndpoint(TaskService taskService,TaskRepository ts) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    @ResponseBody
    ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/bydate")
    @ResponseBody
    ResponseEntity<List<Task>> getTasksByStartAndEndDate(
            @RequestParam("start") Date start,
            @RequestParam("end") Date end) {
        return new ResponseEntity<>(
                taskService.findByStartDateAndEndDate(start, end),
                HttpStatus.OK);
    }

    @GetMapping("/done")
    @ResponseBody
    ResponseEntity<List<Task>> getDoneTasks(
            @RequestParam("done") Boolean done)
    {
        return new ResponseEntity<>(
                taskService.findDone(done),
                HttpStatus.OK);
    }
}
