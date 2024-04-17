package com.ufu.calculadoraFin.entities;

import java.util.Objects;

public abstract class Juros {
	protected Double resultado;
	public Integer resultadoType;
	protected Double capitalInicial;
	protected Double taxa;
	public Integer taxaType;
	protected Double tempo;
	public Integer tempoType;

	public void converterTaxaPDia() {
		switch(taxaType) {
			case 1:
				taxa = taxa/30;
				break;
			case 2:
				taxa = taxa/90;
				break;
			case 3:
				taxa = taxa/180;
				break;
			case 4:
				taxa = taxa/360;
				break;
		}
		taxaType = 0;
	}
	
	public void converterTaxa(Integer newTaxaType) {
		converterTaxaPDia();
		switch(newTaxaType) {
			case 1:
				taxa = taxa*30;
				break;
			case 2:
				taxa = taxa*60;
				break;
			case 3:
				taxa = taxa*90;
				break;
			case 4:
				taxa = taxa*360;
				break;
		}
		taxaType = newTaxaType;
	}
	
	public void converterTempoPDia() {
		switch(tempoType) {
			case 1:
				tempo = tempo*30;
				break;
			case 4:
				tempo = tempo*360;
				break;
		}
		tempoType = 0;
	}
	
	public void converterTempo(Integer newTempoType) {
		converterTempoPDia();
		switch(newTempoType) {
			case 1:
				tempo = tempo/30;
				break;
			case 4:
				tempo = tempo/360;
				break;
		}
		tempoType = newTempoType;
	}

	public String isMissing() {
		if(resultado == 0) {
			return "Resultado";
		}
		if(capitalInicial == 0) {
			return "Capital Inicial";
		}
		if(taxa == 0) {
			return "Taxa";
		}
		if(tempo == 0) {
			return "Tempo";
		}
		return null;
	}
	
	public abstract Double calculate(String target);

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double juros) {
		this.resultado = juros;
	}

	public Double getCapitalInicial() {
		return capitalInicial;
	}

	public void setCapitalInicial(Double capitalInicial) {
		this.capitalInicial = capitalInicial;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public Double getTempo() {
		return tempo;
	}

	public void setTempo(Double tempo) {
		this.tempo = tempo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capitalInicial, resultado, taxa, tempo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juros other = (Juros) obj;
		return Objects.equals(capitalInicial, other.capitalInicial) && Objects.equals(resultado, other.resultado)
				&& Objects.equals(taxa, other.taxa)	&& Objects.equals(tempo, other.tempo);
	}
	
	
}
