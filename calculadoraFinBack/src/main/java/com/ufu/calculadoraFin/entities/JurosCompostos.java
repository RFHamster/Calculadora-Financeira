package com.ufu.calculadoraFin.entities;

public class JurosCompostos extends Juros {

	public JurosCompostos(Double resultado, Integer resultadoType, Double capitalInicial, Double taxa, Integer taxaType,
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
				if(resultadoType == 0) {
					resultado = (capitalInicial * Math.pow((1+taxa),tempo)) - capitalInicial;
				}else {
					resultado = capitalInicial * Math.pow((1+taxa),tempo);
				}
				value = resultado;
				break;
			case "Capital Inicial":
				if(resultadoType == 0) {
					capitalInicial = (resultado + capitalInicial)/(Math.pow((1+taxa),tempo));
				}else {
					capitalInicial = resultado/(Math.pow((1+taxa),tempo));
				}
				value = capitalInicial;
				break;
			case "Taxa":
				if(resultadoType == 0) {
					taxa = Math.pow(((resultado+capitalInicial)/capitalInicial),1.0/tempo)-1;
				}else {
					taxa = Math.pow((resultado/capitalInicial),1/tempo)-1;
				}
				value = taxa;
				break;
			case "Tempo":
				if(resultadoType == 0) {
					tempo = Math.log((resultado+capitalInicial)/capitalInicial)/Math.log(1+taxa);
				}else {
					tempo = Math.log(resultado/capitalInicial)/Math.log(1+taxa);
				}
				value = tempo;
				break;
		}
		return value;
	}

	@Override
	public String toString() {
		return "JurosCompostos [resultado=" + resultado + ", resultadoType=" + resultadoType + ", capitalInicial="
				+ capitalInicial + ", taxa=" + taxa + ", taxaType=" + taxaType + ", tempo=" + tempo + ", tempoType="
				+ tempoType + "]";
	}
	

}
