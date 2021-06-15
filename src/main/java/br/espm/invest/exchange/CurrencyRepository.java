package br.espm.invest.exchange;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface CurrencyRepository extends CrudRepository<CurrencyModel, String> {

    @Override
    Iterable<CurrencyModel> findAll();

    @Override
    Optional<CurrencyModel> findById(String s);

    // SQL customizado
    @Query("SELECT c FROM CurrencyModel c WHERE UPPER(c.txtSymbol) = UPPER(:symbol)")
    Optional<CurrencyModel> findBySymbol(@Param("symbol") String symbol);
}
