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
    private String id;

    @Column(name = "txt_name")
    private String name;

    @Column(name = "txt_symbol")
    private String symbol;

    public CurrencyModel(){}

    public CurrencyModel(Currency currency) {
        this.id = currency.getId();
        this.name = currency.getName();
        this.symbol = currency.getSymbol();
    }

    public Currency to() {
        Currency c = new Currency(id, name, symbol);
        return c;
    }
}
