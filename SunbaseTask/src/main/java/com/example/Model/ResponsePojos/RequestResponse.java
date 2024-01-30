package com.example.Model.ResponsePojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestResponse {
    private Integer statusCode;
    private String message;
}
