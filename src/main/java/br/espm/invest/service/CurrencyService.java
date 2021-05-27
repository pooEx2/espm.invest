package br.espm.invest.service;

import br.espm.invest.datatype.CurrencyBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CurrencyService {

    private static Map<String, CurrencyBean> moedas = new HashMap<>();

    static{
        CurrencyBean m1 = new CurrencyBean("USD", 3.5, "05/04/2019");
        CurrencyBean m2 = new CurrencyBean("USD", 5.27);
        CurrencyBean m3 = new CurrencyBean("EUR", 6.42, "27/05/2021");
        CurrencyBean m4 = new CurrencyBean("JPY", 0.04);

        moedas.put(m1.getCurrency(), m1);
        moedas.put(m2.getCurrency(), m2);
        moedas.put(m3.getCurrency(), m3);
        moedas.put(m4.getCurrency(), m4);
    }

    public Map<String, CurrencyBean> listAll() {
        return moedas;
    }
}
