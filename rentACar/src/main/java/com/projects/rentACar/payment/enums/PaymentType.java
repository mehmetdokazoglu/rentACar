package com.projects.rentACar.payment.enums;

public enum PaymentType {

    CREDIT_CARD(1, "Kredi Kartı");

    private Integer id;
    private String detail;

    PaymentType(Integer id, String detail){
        this.id = id;
        this.detail = detail;
    }

    public Integer getId(){
        return this.id;
    }

    public String getDetail(){
        return this.detail;
    }
}
