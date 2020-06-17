package com.bettercloud.vault.response;

import com.bettercloud.vault.api.Logical;
import com.bettercloud.vault.api.activedirectory.ActiveDirectoryCredential;
import com.bettercloud.vault.api.activedirectory.ActiveDirectoryRoleOptions;
import com.bettercloud.vault.json.JsonArray;
import com.bettercloud.vault.json.JsonObject;
import com.bettercloud.vault.rest.RestResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActiveDirectoryResponse extends LogicalResponse {

    private ActiveDirectoryCredential credential;

    private ActiveDirectoryRoleOptions roleOptions;

    public ActiveDirectoryCredential getCredential() {
        return credential;
    }

    public ActiveDirectoryRoleOptions getRoleOptions() {
        return roleOptions;
    }

    /**
     * @param restResponse The raw HTTP response from Vault.
     * @param retries      The number of retry attempts that occurred during the API call (can be zero).
     */
    public ActiveDirectoryResponse(RestResponse restResponse, int retries) {
        super(restResponse, retries, Logical.logicalOperations.authentication);
        credential = buildCredentialFromData(this.getData());
        roleOptions = buildRoleOptionsFromData(this.getData(), this.getDataObject());
    }

    private ActiveDirectoryRoleOptions buildRoleOptionsFromData(final Map<String, String> data, final JsonObject jsonObject) {
        if (data == null || data.size() == 0) {
            return null;
        }

        final String saName = data.get("service_account_name");
        final String ttl = data.get("ttl");

        if (saName == null && ttl == null) {
            return null;
        }

        return new ActiveDirectoryRoleOptions()
                .saName(saName)
                .ttl(ttl);
    }

    private ActiveDirectoryCredential buildCredentialFromData(final Map<String, String> data) {
        if (data == null) {
            return null;
        }
        final String username = data.get("username");
        final String current_password = data.get("current_password");

        if (username == null && current_password == null) {
            return null;
        }

        return new ActiveDirectoryCredential()
                .username(username)
                .current_password(current_password);
    }

    private JsonArray safeGetJsonArray(JsonObject source, String key) {
        if (source == null || source.get(key) == null || source.get(key) == null || !source.get(key).isArray()) {
            return new JsonArray();
        }

        return source.get(key).asArray();
    }

    private List<String> extractFromJsonArray(JsonArray array) {
        List<String> result = new ArrayList<>();

        array.forEach(entry -> result.add(entry.asString()));

        return result;
    }
}
