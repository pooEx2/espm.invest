package br.espm.invest.exchange;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public interface QuotationRepository extends CrudRepository<QuotationModel, String> {

    @Override
    Iterable<QuotationModel> findAll();

    @Override
    Optional<QuotationModel> findById(String id);

    @Query("SELECT q from QuotationModel q WHERE q.idCurrency = :idCurrency AND q.dtDate <= :date ORDER BY q.dtDate DESC")
    List<QuotationModel> findByDate(
            @Param("idCurrency") String idCurrency,
            @Param("date") Date date
    );

    @Query("SELECT q FROM QuotationModel q " +
            "WHERE " +
            "(q.idCurrency is null or q.idCurrency = :idCurrency) AND " +
            "(q.dtDate is null or q.dtDate >= :dtStart) AND " +
            "(q.dtDate is null or q.dtDate <= :dtEnd)"
    )
    List<QuotationModel> findByInterval(
            @Param("idCurrency") String idCurrency,
            @Param("dtStart") Date dtStart,
            @Param("dtEnd") Date dtEnd);
}
