package br.espm.invest.rest;

import br.espm.invest.datatype.CurrencyBean;
import br.espm.invest.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
public class CurrencyResource {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping(path="/")
    public Map<String, CurrencyBean> listAll() { return currencyService.listAll(); }
}
