package com.example.basketBallCamp.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ResponseModel {
    private HttpStatus status;
    private String message;
    private Object data;

}