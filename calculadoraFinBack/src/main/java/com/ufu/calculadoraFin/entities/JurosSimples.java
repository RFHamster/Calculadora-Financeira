package com.ufu.calculadoraFin.entities;

public class JurosSimples extends Juros{

	public JurosSimples(Double resultado, Integer resultadoType, Double capitalInicial, Double taxa, Integer taxaType,
			Double tempo, Integer tempoType) {
		this.resultado = resultado;
		this.resultadoType = resultadoType;
		this.capitalInicial = capitalInicial;
		this.taxa = taxa/100;
		this.taxaType = taxaType;
		this.tempo = tempo;
		this.tempoType = tempoType;
	}


	@Override
	public Double calculate(String target) {
		Double value = null;	
		switch(target) {
			case "Resultado":
				converterTaxaPDia();
				converterTempoPDia();
				if(resultadoType == 0) {
					resultado = tempo * taxa * capitalInicial;
				}else {
					resultado = capitalInicial * (1 + (tempo * taxa));
				}
				value = resultado;
				break;
			case "Capital Inicial":
				converterTaxaPDia();
				converterTempoPDia();
				if(resultadoType == 0) {
					capitalInicial = resultado/(tempo*taxa);
				}else {
					capitalInicial = resultado/((1+(tempo*taxa)));
				}
				value = capitalInicial;
				break;
			case "Taxa":
				if(resultadoType == 0) {
					taxa = (resultado)/(tempo*capitalInicial);
				}else {
					taxa = (resultado - capitalInicial)/(tempo*capitalInicial);
				}
		
				Integer prevTaxaType = taxaType;
				taxaType = tempoType;
				converterTaxa(prevTaxaType);
				value = taxa;
				break;
			case "Tempo":
				if(resultadoType == 0) {
					tempo = (resultado)/(taxa*capitalInicial);
				}else {
					tempo = (resultado - capitalInicial)/(taxa*capitalInicial);
				}
				
				tempoType = taxaType;
				Integer prevTempoType = tempoType;
				tempoType = taxaType;
				converterTaxa(prevTempoType);
				value = tempo;
				break;
		}
		return value;
	}


	@Override
	public String toString() {
		return "JurosSimples [resultado=" + resultado + ", resultadoType=" + resultadoType + ", capitalInicial="
				+ capitalInicial + ", taxa=" + taxa + ", taxaType=" + taxaType + ", tempo=" + tempo + ", tempoType="
				+ tempoType + "]";
	}
	
	
	
}
