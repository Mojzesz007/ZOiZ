package com.zoiz.backend.rest;

import com.zoiz.backend.models.Activity;
import com.zoiz.backend.models.Task;
import com.zoiz.backend.service.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityEndpoint {
    private final ActivityService activityService;

    public ActivityEndpoint(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/all")
    @ResponseBody
    ResponseEntity<List<Activity>> getAll() {
        return new ResponseEntity<>(activityService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    ResponseEntity<Activity> create(
            @RequestBody Activity activity
    ) {
        return new ResponseEntity<>(activityService.create(activity), HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    ResponseEntity<Activity> update(
            @RequestBody Activity activity
    ) {
        return new ResponseEntity<>(activityService.update(activity), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    void delete(
            @PathVariable Long id
    ) {
        activityService.delete(id);
    }

}
