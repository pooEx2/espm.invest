package br.espm.invest.exchange;

import br.espm.invest.exchange.common.controller.ExchangeController;
import br.espm.invest.exchange.common.datatype.Currency;
import br.espm.invest.exchange.common.datatype.Quotation;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ExchangeResource implements ExchangeController {
    @Override
    public List<Currency> listAll() {
        // TODO: falta acessar o database
        List<Currency> moedas = new ArrayList<>();
        moedas.add(new Currency(UUID.randomUUID().toString(), "Yen", "YENE"));
        moedas.add(new Currency(UUID.randomUUID().toString(), "Euro", "EUR"));
        return moedas;
    }

    @Override
    public Quotation quotation(String s) {
        return null;
    }

    @Override
    public List<Quotation> quotations(String s) {
        return null;
    }
}
