package com.zoiz.backend.service;

import com.zoiz.backend.models.Activity;
import com.zoiz.backend.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public Activity create(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity update(Activity activity) {
        return activityRepository.save(activity);
    }

    public void delete(Long id) {
        activityRepository.deleteActivityById(id);
    }
}
