package com.example.TaskManagerREST.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Task {

    private int id;
    @NotBlank(message = "Title required")
    private String title;
    private String description;
    @NotNull(message = "Status required")
    private Status status;
//    private static int maxId = 1;

    public Task(String title, String description, Status status) {
//        this.id = maxId++;
        this.title = title;
        this.description = description;
        this.status = status;
    }

}



