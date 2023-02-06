package com.example.demo.external;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseAPI {
    private int responseCode;
    private String description;
    private Long elapsedTime;
    private CountResult result;
}
