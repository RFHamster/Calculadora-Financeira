package com.ufu.calculadoraFin.entities;

public class TaxaEquivalenteComposta extends Juros{
	private Double taxaEfetiva;
	private Integer taxaEfetivaType;
	private Double taxaEquivalente;
	private Integer taxaEquivalenteType;
	
	public TaxaEquivalenteComposta(Double taxaEfetiva, Integer taxaEfetivaType, Double taxaEquivalente,
			Integer taxaEquivalenteType) {
		this.taxaEfetiva = taxaEfetiva/100;
		this.taxaEfetivaType = taxaEfetivaType;
		this.taxaEquivalente = taxaEquivalente/100;
		this.taxaEquivalenteType = taxaEquivalenteType;
	}

	public String isMissing() {
		if(taxaEfetiva == 0) {
			return "Taxa Efetiva";
		}
		if(taxaEquivalente == 0) {
			return "Taxa Equivalente";
		}
		
		return null;
	}
	
	public Double converterMes(Double taxa, Integer tipo) {
		if(tipo == 0) {
			return taxa;
		}
		if(tipo == 1) {
			return Math.pow((1+taxa), (1.0/6.0)) - 1;
		}
		return Math.pow((1+taxa), 1.0/12.0) - 1;
	}
	
	public Double converterMesPara(Double taxaMes, Integer tipo) {
		if(tipo == 0) {
			return taxaMes;
		}
		if(tipo == 1) {
			return Math.pow((1+taxaMes), 6.0) - 1;
		}
		return Math.pow((1+taxaMes), 12.0) - 1;
	}
	
	public Double calculate(String target) {
		Double value = 0.0;
		switch(target) {
			case "Taxa Efetiva":
				taxaEquivalente = converterMes(taxaEquivalente, taxaEquivalenteType);
				taxaEquivalenteType = 0;
				System.out.println(taxaEquivalente);
				value = converterMesPara(taxaEquivalente, taxaEfetivaType);
				taxaEfetiva = value;
				System.out.println(taxaEfetiva);
				break;
			case "Taxa Equivalente":
				taxaEfetiva = converterMes(taxaEfetiva, taxaEfetivaType);
				taxaEfetivaType = 0;
				System.out.println(taxaEfetiva);
				value = converterMesPara(taxaEfetiva, taxaEquivalenteType);
				taxaEquivalente = value;
				System.out.println(taxaEquivalente);
				break;
		}
		return value;
	}
	
	
	
}
