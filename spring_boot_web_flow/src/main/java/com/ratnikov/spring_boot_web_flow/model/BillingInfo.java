package com.ratnikov.spring_boot_web_flow.model;

import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

@Data
public class BillingInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    private String address;
}
