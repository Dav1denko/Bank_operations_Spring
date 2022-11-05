package com.Bank.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class BillRequestDTO {

    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("isDefault")
    private Boolean isDefault;

    public BigDecimal getAmount() {
        return amount;
    }

    public Boolean getDefault() {
        return isDefault;
    }
}
