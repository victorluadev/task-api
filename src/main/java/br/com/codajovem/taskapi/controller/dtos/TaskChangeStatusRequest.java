package br.com.codajovem.taskapi.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskChangeStatusRequest {

    @NotNull
    @Pattern(regexp = "TODO|DOING|DONE")
    private String status;

}
