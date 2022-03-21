package br.com.codajovem.taskapi.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorApiDTO<T> {

    private ArrayList<T> errors = new ArrayList<>();

    public void addError(T error) {
        this.errors.add(error);
    }


}
