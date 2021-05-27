package br.espm.invest.datatype;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class CurrencyBean {
    private String currency;
    private double value;
    private String date;

    public CurrencyBean(String currency, double value) {
        this.currency = currency;
        this.value = value;

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        this.date = formatarDate.format(date);
    }

    public CurrencyBean(String currency, double value, String date) {
        this.currency = currency;
        this.value = value;
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
