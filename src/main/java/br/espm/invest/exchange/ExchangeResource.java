package br.espm.invest.exchange;

import br.espm.invest.exchange.common.controller.ExchangeController;
import br.espm.invest.exchange.common.datatype.Currency;
import br.espm.invest.exchange.common.datatype.Quotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ExchangeResource implements ExchangeController {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private QuotationService quotationService;

    @Override
    public List<Currency> currencies() {
        return currencyService.listAll();
    }

    @Override
    public Currency currency(@PathVariable String symbol) {
        return currencyService.findBySymbol(symbol);
    }

    @Override
    public Quotation quotation(@PathVariable String id) {
        return quotationService.findById(id);
    }

    @Override
    public Quotation quotation(@RequestParam String symbol, @RequestParam String date) {
        try {
            Currency currency = currencyService.findBySymbol(symbol);
            if (currency == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, symbol + " not found");
            }
            System.out.println(date);
            System.out.println(sdf.parse(date));
            return quotationService.findBy(currency.getId(), sdf.parse(date));
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public List<Quotation> quotations(
            @RequestParam String symbol,
            @RequestParam String start,
            @RequestParam String end) {
        try {
            Currency currency = currencyService.findBySymbol(symbol);
            if (currency == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, symbol + " not found");
            }
            Date dtStart = start == null ? null : sdf.parse(start);
            Date dtEnd = end == null ? null : sdf.parse(end);
            return quotationService.findByInterval(currency.getId(), dtStart, dtEnd);
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
