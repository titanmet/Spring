package com.ratnikov.beanslifecycleexercise.domain;

import org.springframework.stereotype.Component;

@Component
public class GirlfriendPhoneNumber extends PhoneNumber {
    @Override
    public String getOwnerName() {
        return "Подруга";
    }
}
