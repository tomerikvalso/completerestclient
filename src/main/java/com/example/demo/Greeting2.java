package com.example.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
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
