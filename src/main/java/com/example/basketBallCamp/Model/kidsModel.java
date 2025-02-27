package com.example.basketBallCamp.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class kidsModel {
    private Long kidId;
    private String kidName;
    private String kidAddress;
    private String kidEmail;
    private Long kidAge;
}
