package net.treXis.tipsy.security.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "/api/user_login")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_acct;
    private String username;
    private String password;
    private boolean enabled;

    public UserLogin() {
    }

    public Long getUser_acct() {
        return user_acct;
    }

    public void setUser_acct(Long user_acct) {
        this.user_acct = user_acct;
    }

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
