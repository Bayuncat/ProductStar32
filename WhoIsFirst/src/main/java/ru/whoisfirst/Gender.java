package ru.whoisfirst;

import java.util.Objects;
import java.util.stream.Stream;

public enum Gender {
    MALE("M"),
    FEMALE("F");

    private final String code;

    Gender(String code) {
        this.code = code;
    }

    public static Gender of(String code) {
        return Stream.of(values())
                .filter(g -> Objects.equals(g.code, code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown gender: " + code));
    }
}
