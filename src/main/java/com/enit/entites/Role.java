package com.enit.entites;

public enum Role {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER"),
    ;

    private final String text;

    /**
     * @param text
     */
    private Role(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}



