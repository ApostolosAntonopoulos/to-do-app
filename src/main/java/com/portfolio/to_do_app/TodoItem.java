package com.portfolio.to_do_app;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String status; // "PENDING" or "DONE"

    public TodoItem() {
        this.status = "PENDING";
    }

    public TodoItem(String title, String status) {
        this.title = title;
        this.status = status != null ? status : "PENDING";
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
