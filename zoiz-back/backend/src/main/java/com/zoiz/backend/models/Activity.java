package com.zoiz.backend.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "activities")
@JsonIgnoreProperties(value={"number", "contextNo"}, allowGetters=true)
public class Activity extends StandardEntity {

    @Column(name="activity_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activityStart=java.sql.Date.valueOf(LocalDate.now());

    @Column(name="activity_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activityEnd;


    @Column(length=1024)
    private String subject;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @JsonProperty(access=Access.WRITE_ONLY)
    private String body;

    @Column(length=1024)
    private boolean important;

    public Date getActivityStart() {
        return activityStart;
    }

    public void setActivityStart(Date activityStart) {
        this.activityStart = activityStart;
    }

    public Date getActivityEnd() {
        return activityEnd;
    }

    public void setActivityEnd(Date activityEnd) {
        this.activityEnd = activityEnd;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }
}