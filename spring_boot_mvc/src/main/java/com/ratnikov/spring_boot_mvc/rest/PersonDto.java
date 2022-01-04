package com.ratnikov.spring_boot_mvc.rest;

import com.ratnikov.spring_boot_mvc.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;

@SuppressWarnings("all")
@Data
@AllArgsConstructor
public class PersonDto {
    private long id;
    private String name;

    public static Person toDomainObject(PersonDto dto) {
        return new Person(dto.getId(), dto.getName());
    }

    public static PersonDto toDto(Person account) {
        return new PersonDto(account.getId(), account.getName());
    }
}
