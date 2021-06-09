package br.espm.invest.exchange;

import br.espm.invest.exchange.common.controller.ExchangeController;
import br.espm.invest.exchange.common.datatype.Currency;
import br.espm.invest.exchange.common.datatype.Quotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@EnableFeignClients
@RestController
public class ExchangeResource implements ExchangeController {

    @Autowired
    private CurrencyService currencyService;

    @Override
    public List<Currency> currencies() {
        return currencyService.listAll();
    }

    @Override
    public Currency currency(String s) {
        return currencyService.findBySymbol(s);
    }

    @Override
    public Quotation quotation(String s) {
        return null;
    }

    @Override
    public List<Quotation> quotations(String symbol, String start, String end) {
        return null;
    }
}
