package br.com.codajovem.taskapi.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateRequest {

    @NotNull
    private String name;

    @NotNull
    private String description;

}
