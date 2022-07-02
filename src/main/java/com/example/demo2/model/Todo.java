package com.example.demo2.model;
import javax.persistence.*;

@Entity
@Table(name="todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private  String title;
    @Column
    private String description;
    @Column
    private TodoStatus todoStatus;

    public Todo() {
    }
    public Todo(String title, String description, TodoStatus todoStatus) {
        super();
        this.title = title;
        this.description = description;
        this.todoStatus = todoStatus;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public TodoStatus getTodoStatus() {
        return todoStatus;
    }
    public void setTodoStatus(TodoStatus todoStatus) {
        this.todoStatus = todoStatus;
    }
}
