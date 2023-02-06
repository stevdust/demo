package com.example.demo.external;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MockarooResponse {

    private int responseCode;
    private String description;
    private MockarooResult result;
}
