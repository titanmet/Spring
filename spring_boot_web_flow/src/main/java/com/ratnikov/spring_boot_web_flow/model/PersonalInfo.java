package com.ratnikov.spring_boot_web_flow.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;

@Data
public class PersonalInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private byte[] imageContent;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    public String getImageBase64() {
        return Base64.getEncoder().encodeToString(imageContent);
    }

    public void setImage(MultipartFile image) throws IOException {
        this.imageContent = image.getBytes();
    }
}
