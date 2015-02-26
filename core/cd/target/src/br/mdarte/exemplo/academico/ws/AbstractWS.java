package br.mdarte.exemplo.academico.ws;

public abstract class AbstractWS implements java.io.Serializable{

	// Isto garante que todos os WSDatas tenham o getId,
	// contudo somente aqueles que realmente o implemetam terao
	// valor valido.	
	public Long getId() {
		return null;
	}
}