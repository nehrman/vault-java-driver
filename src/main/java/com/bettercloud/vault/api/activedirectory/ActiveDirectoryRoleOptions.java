package com.bettercloud.vault.api.activedirectory;

public class ActiveDirectoryRoleOptions {
    private String name;
    private String saName;
    private String ttl = "3600";

    public String getName() {
        return name;
    }

    public String getSaName() {
        return saName;
    }

    public String getTtl() {
        return ttl;
    }

    /**
     * @param name {@code String} – Specifies the name of the role to create. This is specified as part of the URL.
     * @return This object, with name populated, ready for other builder methods or immediate use.
     */
    public ActiveDirectoryRoleOptions name(final String name) {
        this.name = name;
        return this;
    }

    /**
     * @param saName {@code String} - The name of the Service Account Name to use for this role.
     * @return This object, with dbName populated, ready for other builder methods or immediate use.
     */
    public ActiveDirectoryRoleOptions saName(final String saName) {
        this.saName = saName;
        return this;
    }

    /**
     * @param ttl (string/int: 0) - Specifies the TTL for the leases associated with this role. Accepts time suffixed strings ("1h") or an integer number of seconds. Defaults to system/engine default TTL time.
     * @return This object, with ttl populated, ready for other builder methods or immediate use.
     */
    public ActiveDirectoryRoleOptions ttl(final String ttl) {
        this.ttl = ttl;
        return this;
    }
}
