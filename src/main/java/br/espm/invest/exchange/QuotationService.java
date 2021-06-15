package br.espm.invest.exchange;

import br.espm.invest.exchange.common.datatype.Quotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class QuotationService {

    @Autowired
    private QuotationRepository quotationRepository;

    @Autowired
    private CurrencyService currencyService;

    public List<Quotation> listAll() {
        return StreamSupport
                .stream(quotationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(QuotationModel::to)
                .collect(Collectors.toList());
    }

    public Quotation findById(String id) {
        return fill(
                quotationRepository
                    .findById(id)
                    .map(QuotationModel::to)
                    .orElse(null)
        );
    }

    public Quotation findBy(String idCurrency, Date date) {
        Quotation quotation = quotationRepository
                .findByDate(idCurrency, date).stream()
                .map(QuotationModel::to)
                .findFirst()
                .orElse(null);
        return fill(quotation);
    }

    public List<Quotation> findByInterval(String idCurrency, Date dtStart, Date dtEnd) {
        return quotationRepository
                .findByInterval(idCurrency, dtStart, dtEnd).stream()
                .map(QuotationModel::to)
                .collect(Collectors.toList());
    }

    private Quotation fill(Quotation q) {
        if (q != null) {
            q.setCurrency(currencyService.findById(UUID.fromString(q.getCurrency().getId())));
        }
        return q;
    }
}
