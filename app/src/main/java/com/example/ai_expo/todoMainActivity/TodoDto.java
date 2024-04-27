package com.example.ai_expo.todoMainActivity;

public class TodoDto {
    private String todoTitle;
    private String todoBody;

    public TodoDto(String todoTitle, String todoBody) {
        this.todoTitle = todoTitle;
        this.todoBody = todoBody;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getTodoBody() {
        return todoBody;
    }

    public void setTodoBody(String todoBody) {
        this.todoBody = todoBody;
    }
}
