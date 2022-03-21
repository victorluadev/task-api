package br.com.codajovem.taskapi.controller.dtos;

import br.com.codajovem.taskapi.annotation.EnumNamePattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateRequest {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    @Pattern(regexp="TODO|DOING")
    private String status;
}
