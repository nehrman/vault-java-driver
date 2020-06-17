package com.bettercloud.vault.api.activedirectory;

public class ActiveDirectoryCredential {

    private String username;
    private String current_password;

    /**
     * @return Returns the Username associated with the retrieved Credential
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return Returns the Current Password associated with the retrieved Credential
     */
    public String getCurrentPassword() {
        return current_password;
    }

    public ActiveDirectoryCredential username(String username) {
        this.username = username;
        return this;
    }

    public ActiveDirectoryCredential current_password(String current_password) {
        this.current_password = current_password;
        return this;
    }
}
