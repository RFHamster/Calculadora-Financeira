package com.ufu.calculadoraFin.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufu.calculadoraFin.entities.TaxaCapDifComposta;
import com.ufu.calculadoraFin.entities.TaxaEquivalenteComposta;
import com.ufu.calculadoraFin.entities.TaxaSimples;

@RestController
@RequestMapping(value="taxa/")
public class TaxaResource {
	@PostMapping("/simples")
    public String calcularSimples(@RequestBody TaxaSimples requestBody) {
		String missing = requestBody.isMissing();
		Double resultado = requestBody.calculate(missing);
		resultado = resultado * 100;
        return missing + " = " + resultado.toString() + " %";
    }
	
	@PostMapping("/composto/capDif")
    public String calcularComposto(@RequestBody TaxaCapDifComposta requestBody) {
		String missing = requestBody.isMissing();
		Double resultado = requestBody.calculate(missing);
		resultado = resultado * 100;
        return missing + " = " + resultado.toString() + " % a.a";
    }
	
	@PostMapping("/composto/equivalente")
    public String calcularComposto(@RequestBody TaxaEquivalenteComposta requestBody) {
		String missing = requestBody.isMissing();
		Double resultado = requestBody.calculate(missing);
		resultado = resultado * 100;
        return missing + " = " + resultado.toString() + " %";
    }


}
