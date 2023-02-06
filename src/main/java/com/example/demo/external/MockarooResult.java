package com.example.demo.external;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MockarooResult {
    private List<MockarooItem> items;
}
