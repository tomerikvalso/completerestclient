package com.example.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Builder
@Jacksonized
public class Greeting2 {
    String id;
    String name;

    @Override
    public String toString() {
        return "Greeting{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
