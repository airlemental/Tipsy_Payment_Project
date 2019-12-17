package net.treXis.tipsy.security.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;

@Entity(name = "/api/users")
//@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_account;

    private String username;
    private String bcrypt_key;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private Timestamp creation_date;
    private boolean enabled;

    //    @JoinColumn(name = "from_user_account")
    //    @JoinTable(name = "fund_request_queue")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FundRequests> fundRequests;

    public User(){
    }

    // begin constructors, getters, and setters
//    public Users(Set<FundRequests> fundRequests){
//        this.fundRequests = fundRequests;
//    }

    // For Fund Requests
    public Set<FundRequests> getFundRequests(){
        return fundRequests;
    }
    public void setFundRequests(Set<FundRequests> fundRequests) {
        this.fundRequests = fundRequests;
    }

// For Users
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

    public String getBcrypt_key() {
        return bcrypt_key;
    }

    public void setBcrypt_key(String bcrypt_key) {
        this.bcrypt_key = bcrypt_key;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
