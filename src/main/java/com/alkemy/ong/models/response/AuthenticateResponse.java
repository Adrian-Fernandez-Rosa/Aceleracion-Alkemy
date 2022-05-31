/*
 Clases Reponse
 */
package com.alkemy.ong.models.response;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
@Setter
public class AuthenticateResponse {

    private String token;
    private String email;
    private Collection<? extends GrantedAuthority> roleName;
}
