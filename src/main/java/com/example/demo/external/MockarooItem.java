package com.example.demo.external;

import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MockarooItem {
    private String name;
    private MockarooDetail detail;
}
