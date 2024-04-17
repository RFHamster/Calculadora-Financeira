package com.ufu.calculadoraFin.entities;

public class TaxaSimples {
	private Double taxaEfetiva;
	private Double taxaComercial;
	private Double tempo;
	
	public TaxaSimples(Double taxaEfetiva, Double taxaComercial, Double tempo) {
		this.taxaEfetiva = taxaEfetiva/100;
		this.taxaComercial = taxaComercial/100;
		this.tempo = tempo;
	}
	
	public String isMissing() {
		if(taxaEfetiva == 0) {
			return "Taxa Efetiva";
		}
		if(taxaComercial == 0) {
			return "Taxa Comercial";
		}
		
		return null;
	}
	
	public Double calculate(String target) {
		Double value = 0.0;
		switch(target) {
			case "Taxa Efetiva":
				value = taxaComercial/(1-(taxaComercial*tempo));	
				break;
			case "Taxa Comercial":
				value = taxaEfetiva/(1+(taxaEfetiva*tempo));
				break;
		}
		return value;
	}

	public Double getTaxaEfetiva() {
		return taxaEfetiva;
	}

	public void setTaxaEfetiva(Double taxaEfetiva) {
		this.taxaEfetiva = taxaEfetiva;
	}

	public Double getTaxaComercial() {
		return taxaComercial;
	}

	public void setTaxaComercial(Double taxaComercial) {
		this.taxaComercial = taxaComercial;
	}

	@Override
	public String toString() {
		return "TaxaSimples [taxaEfetiva=" + taxaEfetiva + ", taxaComercial=" + taxaComercial + ", tempo=" + tempo
				+ "]";
	}
	
	
	
	
}
