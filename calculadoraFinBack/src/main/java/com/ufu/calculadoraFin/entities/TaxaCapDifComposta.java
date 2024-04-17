package com.ufu.calculadoraFin.entities;

public class TaxaCapDifComposta {
	private Double taxaEfetiva;
	private Double taxaNominal;
	private Double tempo;
	
	public TaxaCapDifComposta(Double taxaEfetiva, Double taxaNominal, Double tempo) {
		this.taxaEfetiva = taxaEfetiva/100;
		this.taxaNominal = taxaNominal/100;
		this.tempo = tempo;
	}
	
	public String isMissing() {
		if(taxaEfetiva == 0) {
			return "Taxa Efetiva";
		}
		if(taxaNominal == 0) {
			return "Taxa Nominal";
		}
		
		return null;
	}
	
	public Double calculate(String target) {
		Double value = 0.0;
		switch(target) {
			case "Taxa Efetiva":
				value = taxaNominal/tempo;
				value = Math.pow((1+value), tempo) - 1;
				break;
			case "Taxa Nominal":
				taxaEfetiva = Math.pow((1+taxaEfetiva), 1.0/tempo) - 1;
				value = taxaEfetiva*tempo;
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

	public Double gettaxaNominal() {
		return taxaNominal;
	}

	public void settaxaNominal(Double taxaNominal) {
		this.taxaNominal = taxaNominal;
	}

	@Override
	public String toString() {
		return "TaxaSimples [taxaEfetiva=" + taxaEfetiva + ", taxaNominal=" + taxaNominal + ", tempo=" + tempo
				+ "]";
	}
	
	
	
	
}
