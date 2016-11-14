package com.facebook.login;

public enum DefaultAudience {
    NONE(null),
    ONLY_ME("only_me"),
    FRIENDS("friends"),
    EVERYONE("everyone");
    
    private final String e;

    private DefaultAudience(String protocol) {
        this.e = protocol;
    }

    public String a() {
        return this.e;
    }
}
