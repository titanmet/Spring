package com.ratnikov.springbootandreact.rest.dto;

import com.ratnikov.springbootandreact.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDto {
    private long id = -1;
    private String name;

    public static PersonDto toDto(Person person) {
        return new PersonDto(person.getId(), person.getName());
    }
}
