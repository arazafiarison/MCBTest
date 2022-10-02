package com.mcb.test.Test.model.collection.authentication;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Login {
    @Id
    private String id;
    @Indexed(name="login_username_index",direction = IndexDirection.DESCENDING)
    private String login;
    @Indexed(name="login_email_index",direction = IndexDirection.DESCENDING)
    private String email;
    private String password;
    @Indexed(name="login_user_id_index",direction = IndexDirection.DESCENDING)
    private String userId;
    private Boolean lockedAccount;
    private List<RoleEmbeded> roles;
}
