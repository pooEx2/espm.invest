package br.espm.invest.exchange;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CurrencyRepository extends CrudRepository<CurrencyModel, String> {

    @Override
    Iterable<CurrencyModel> findAll();

    @Override
    Optional<CurrencyModel> findById(String s);

    Optional<CurrencyModel> findBySymbol(String symbol);
}
