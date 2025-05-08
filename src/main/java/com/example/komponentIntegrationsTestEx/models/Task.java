package com.example.komponentIntegrationsTestEx.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long userId;

    private String taskTitle;

    private String taskComment;

    private boolean isDone = false;

    public Task(Long id, Long userId, String taskTitle, String taskComment, boolean isDone) {
        this.id = id;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
                ", userId=" + userId +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskComment='" + taskComment + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
