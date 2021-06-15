package br.espm.invest.exchange;

import br.espm.invest.exchange.common.datatype.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class CurrencyModel {

    @Id
    @Column(name = "id_currency")
    private String idCurrency;

    @Column(name = "txt_name")
    private String txtName;

    @Column(name = "txt_symbol")
    private String txtSymbol;

    public CurrencyModel(){}

    public CurrencyModel(Currency currency) {
        this.idCurrency = currency.getId();
        this.txtName = currency.getName();
        this.txtSymbol = currency.getSymbol();
    }

    public Currency to() {
        Currency c = new Currency();
        c.setId(idCurrency);
        c.setName(txtName);
        c.setSymbol(txtSymbol);
        return c;
    }
}
