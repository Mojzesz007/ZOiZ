package com.zoiz.backend.rest;

import com.zoiz.backend.models.Task;
import com.zoiz.backend.repository.TaskRepository;
import com.zoiz.backend.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskEndpoint {
    private final TaskService taskService;

    public TaskEndpoint(TaskService taskService, TaskRepository ts) {
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
            @RequestParam("end") Date end,
            @RequestParam("id") Long id
            ) {
        return new ResponseEntity<>(
                taskService.findByStartDateAndEndDate(start, end,id),
                HttpStatus.OK);
    }

    @GetMapping("/done")
    @ResponseBody
    ResponseEntity<List<Task>> getDoneTasks(
            @RequestParam("done") Boolean done,
            @RequestParam("id") Long id
    ) {
        return new ResponseEntity<>(
                taskService.findDone(done,id),
                HttpStatus.OK);
    }

    @GetMapping("/overdue")
    @ResponseBody
    ResponseEntity<List<Task>> getOverdueTasks(
            @RequestParam("id") Long id
    ) {
        return new ResponseEntity<>(
                taskService.findOverdue(id),
                HttpStatus.OK);
    }

    @GetMapping("/insevendays")
    @ResponseBody
    ResponseEntity<List<Task>> getInSevendaysTasks(
            @RequestParam("id") Long id
    ) {
        return new ResponseEntity<>(
                taskService.findInSevenDays(id),
                HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    ResponseEntity<Task> createTask(
            @RequestBody Task task
    ) {
        return new ResponseEntity<>(
                taskService.createTask(task),
                HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    ResponseEntity<Task> updateTask(
            @RequestBody Task task
    ) {
        return new ResponseEntity<>(
                taskService.updateTask(task),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    void deleteTask(
            @PathVariable long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    ResponseEntity<Task> getTask(
            @PathVariable long id
    ) {
        return new ResponseEntity<>(
                taskService.findById(id),
                HttpStatus.OK);
    }
}
