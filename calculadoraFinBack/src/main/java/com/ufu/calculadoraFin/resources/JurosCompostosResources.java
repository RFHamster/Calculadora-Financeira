package com.ufu.calculadoraFin.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufu.calculadoraFin.entities.JurosCompostos;

@RestController
@RequestMapping(value="jcompostos/")
public class JurosCompostosResources {
	
	@PostMapping("/calcular")
    public String calcular(@RequestBody JurosCompostos requestBody) {
		String missing = requestBody.isMissing();
		Double resultado = requestBody.calculate(missing);
        return missing + " = " + resultado.toString();
    }
}
