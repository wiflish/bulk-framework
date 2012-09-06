package org.bulkframework.core.domain.typehandler;

import org.bulkframework.common.model.BaseModel;

public class User extends BaseModel<UserFeatureJson> {
    private static final long serialVersionUID = 5945595186897644723L;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
