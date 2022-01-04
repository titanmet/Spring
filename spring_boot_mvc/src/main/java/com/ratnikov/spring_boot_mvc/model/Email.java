package com.ratnikov.spring_boot_mvc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

@Data
@KeySpace("email")
public class Email {
    @Id
    private long Id;
    private String email;
}
