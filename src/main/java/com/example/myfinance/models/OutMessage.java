package com.example.myfinance.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OutMessage {

    private String message;
    private Object result;

}