package com.ratnikov.spring_boot_web_flow.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private PersonalInfo personalInfo;
    private BillingInfo billingInfo;
}
