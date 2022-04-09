package com.zoiz.backend.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "tasks")
public class Task extends StandardEntity {
    @Column(name = "date_from")
    @Temporal(TemporalType.TIMESTAMP)
    public Date dateFrom = java.sql.Date.valueOf(LocalDate.now());

    @Column(name = "date_to")
    @Temporal(TemporalType.TIMESTAMP)
    public Date dateTo;

    @Column(name = "subject")
    public String subject;

    @Column(name = "message", length = 2048)
    public String message;


    @Column
    public boolean done;

    @Column
    private Long parentToken;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column
    private Boolean sendNotification;

    public Task(String message, String subject) {
        this.message = message;
        this.subject = subject;
    }

    public Task() {
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Long getParentToken() {
        return parentToken;
    }

    public void setParentToken(Long parentToken) {
        this.parentToken = parentToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getSendNotification() {
        return sendNotification;
    }

    public void setSendNotification(Boolean sendNotification) {
        this.sendNotification = sendNotification;
    }

    public String getEntityDescription() {
        return subject;
    }
}

