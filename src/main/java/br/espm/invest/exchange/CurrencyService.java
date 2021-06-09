package br.espm.invest.exchange;

import br.espm.invest.exchange.common.datatype.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public List<Currency> listAll() {
        return StreamSupport
                .stream(currencyRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(CurrencyModel::to)
                .collect(Collectors.toList());
    }

    public Currency findById(UUID id) {
        return currencyRepository
                .findById(id.toString())
                .map(CurrencyModel::to)
                .orElse(null);
    }

    public Currency findBySymbol(String symbol) {
        return currencyRepository
                .findBySymbol(symbol)
                .map(CurrencyModel::to)
                .orElse(null);
    }
}
