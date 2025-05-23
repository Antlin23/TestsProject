package com.example.komponentIntegrationsTestEx.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonBackReference
    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id", nullable = false,referencedColumnName = "id")
    private User user;
    private String taskTitle;

    private String taskComment;

    private boolean isDone = false;

    public Task(Long id, String taskTitle, String taskComment, boolean isDone) {
        this.id = id;
        this.taskTitle = taskTitle;
        this.taskComment = taskComment;
        this.isDone = isDone;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskComment() {
        return taskComment;
    }

    public void setTaskComment(String taskComment) {
        this.taskComment = taskComment;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskComment='" + taskComment + '\'' +
                ", isDone=" + isDone +
                '}';
    }


    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }
}
