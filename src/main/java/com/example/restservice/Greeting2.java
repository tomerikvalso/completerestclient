package com.example.restservice;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Greeting2 {
    private Long id;
    String name;

    @Override
    public String toString() {
        return "Greeting{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
