package net.treXis.tipsy.security.model;

public class Authorities {

    private Long user_account;
    private String username;
    private String authority;


    public Long getUser_account() {
        return user_account;
    }

    public void setUser_account(Long user_account) {
        this.user_account = user_account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
