package br.espm.invest.exchange;

import br.espm.invest.exchange.common.datatype.Currency;
import br.espm.invest.exchange.common.datatype.Quotation;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quotation")
public class QuotationModel {

    @Column(name = "id_quotation")
    private String idQuotation;

    @Column(name = "id_currency")
    private String idCurrency;

    @Column(name = "nr_value")
    private double nrValue;

    @Column(name = "dt_date")
    @Temporal(TemporalType.DATE)
    private Date dtDate;

    public QuotationModel(){}

    public QuotationModel(Quotation q) {
        this.idQuotation = q.getId();
        this.idCurrency = q.getCurrency().getId();
        this.dtDate = q.getDate();
        this.nrValue = q.getValue();
    }

    public Quotation to() {
        Currency c = new Currency();
        c.setId(idCurrency);

        Quotation q = new Quotation();
        q.setId(idQuotation);
        q.setCurrency(c);
        q.setDate(dtDate);
        q.setValue(nrValue);
        return q;
    }
}
