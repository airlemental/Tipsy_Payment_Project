package net.treXis.tipsy.viewer.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OneFundRequest {

    private Long id;

    private Integer user_acct;
    private String request_code;
    private Timestamp request_date;
    private BigDecimal amount;
    private String paypal_account;
    private String paypal_response_id;
    private String paypal_invoice;
    private String paypal_status;
    private String description;
    private boolean complete_flag;
    private Timestamp complete_date;
    private boolean enabled;

}
