package net.treXis.tipsy.viewer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;

@Entity(name = "fund_requests")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class FundRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //GenerationType.IDENTITY)    GenerationType.AUTO)
    private Long id;

    //possible Json formatting for date if necessary
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")

    private Integer user_acct;
    private String request_code;
//    @CreationTimestamp
    private Timestamp request_date;
    private BigDecimal amount;
    private String paypal_account;
    private String paypal_response_id;
    private String paypal_invoice;
    private String paypal_status;
    private String description;
    private boolean complete_flag;
//    @UpdateTimestamp
    private Timestamp complete_date;
    private boolean enabled;

//    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinTable(name = "Users", joinColumns = @JoinColumn(name = "fund_request_queue.from_user_acct"), inverseJoinColumns = @JoinColumn(name = "user_account"))
//    private User user;
//
//    public User getUser(){
//        return user;
//    }


    //begin constructors, getters, and setters


    public FundRequests() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUser_acct() {
        return user_acct;
    }

    public void setUser_acct(Integer user_acct) {
        this.user_acct = user_acct;
    }

    public String getRequest_code() {
        return request_code;
    }

    public void setRequest_code(String request_code) {
        this.request_code = request_code;
    }

    public Timestamp getRequest_date() {
        return request_date;
    }

    public void setRequest_date(Timestamp request_date) {
        this.request_date = request_date;
    }

    public void setRequest_date(String trigger) {
        if(trigger == "current_date"){
            Date date = new Date();
            setRequest_date((new Timestamp(date.getTime())));
        }
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaypal_account() {
        return paypal_account;
    }

    public void setPaypal_account(String paypal_account) {
        this.paypal_account = paypal_account;
    }

    public String getPaypal_response_id() {
        return paypal_response_id;
    }

    public void setPaypal_response_id(String paypal_response_id) {
        this.paypal_response_id = paypal_response_id;
    }

    public String getPaypal_invoice() {
        return paypal_invoice;
    }

    public void setPaypal_invoice(String paypal_invoice) {
        this.paypal_invoice = paypal_invoice;
    }

    public String getPaypal_status() {
        return paypal_status;
    }

    public void setPaypal_status(String paypal_status) {
        this.paypal_status = paypal_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete_flag() {
        return complete_flag;
    }

    public void setComplete_flag(boolean complete_flag) {
        this.complete_flag = complete_flag;
    }

    public Timestamp getComplete_date() {
        return complete_date;
    }

    public void setComplete_date(Timestamp complete_date) {
        this.complete_date = complete_date;
    }

    public void setComplete_date(String trigger) {
        if(trigger == "current_date"){
            Date date = new Date();
            setComplete_date((new Timestamp(date.getTime())));
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
