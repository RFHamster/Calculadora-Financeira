package com.ufu.calculadoraFin.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufu.calculadoraFin.entities.JurosSimples;

@RestController
@RequestMapping(value="jsimples/")
public class JurosSimplesResource {
	
	@PostMapping("/calcular")
    public String calcular(@RequestBody JurosSimples requestBody) {
		String missing = requestBody.isMissing();
		Double resultado = requestBody.calculate(missing);
        return missing + " = " + resultado.toString();
    }
	
}
