package com.venmo.view;

public enum ArrowAlignment {
    START(0),
    CENTER(1),
    END(2),
    ANCHORED_VIEW(3);
    
    private final int e;

    private ArrowAlignment(int value) {
        this.e = value;
    }

    public static ArrowAlignment a(int value) {
        for (ArrowAlignment alignment : values()) {
            if (value == alignment.a()) {
                return alignment;
            }
        }
        throw new IllegalArgumentException("No matching ArrowAlignment with value: " + value);
    }

    public int a() {
        return this.e;
    }
}
