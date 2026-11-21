package com.example.restservice;

import lombok.Builder;
import lombok.Value;

@Builder
public class Greeting  {
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
