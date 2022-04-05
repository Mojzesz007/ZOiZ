package com.zoiz.backend.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@MappedSuperclass
@JsonIgnoreProperties(value={
        "entityType",
        "createdAt",
        "updatedAt",
        "contextable",
        "entityDescription"
}, allowGetters=true)
public abstract class StandardEntity implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Version
    @Column(name = "version")
    private int version;

    @JsonProperty(access=Access.READ_ONLY)
    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @JsonProperty(access=Access.READ_ONLY)
    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(nullable=false)
    private boolean draft = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    protected void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    protected void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    @PrePersist
    public void setCreationDate() {
        setCreatedAt(new Date());
    }

    @PreUpdate
    public void setChangeDate() {
        setUpdatedAt(new Date());
    }
}
