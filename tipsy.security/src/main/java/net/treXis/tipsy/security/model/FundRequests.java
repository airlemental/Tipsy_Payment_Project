package net.treXis.tipsy.security.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity(name = "tipsy")
@Table(name = "fund_request_queue")
@JsonIgnoreProperties
public class FundRequests {

    @Id                              //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int from_user_acct;

    private String request_code;
    private Timestamp request_date;
    private BigDecimal amount;
    private String paypal_account;
    private String paypal_response_id;
    private String paypal_invoice;
    private String paypal_status;
    private String description;
    private boolean complete_flag;
    private Timestamp creation_date;
    private boolean enabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "Users", joinColumns = @JoinColumn(name = "from_user_acct"), inverseJoinColumns = @JoinColumn(name = "user_account"))
    private Users users;

    public Users getUsers(){
        return users;
    }


    //begin constructors, getters, and setters


    public FundRequests() {
    }

    public int getFrom_user_acct() {
        return from_user_acct;
    }

    public void setFrom_user_acct(int from_user_acct) {
        this.from_user_acct = from_user_acct;
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
