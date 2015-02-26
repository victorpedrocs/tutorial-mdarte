package br.mdarte.exemplo.academico.util;

public class PaginationDisplaytag extends PaginationStrategy {
	
	public PaginationDisplaytag(Integer paginaAtual) {
		super(paginaAtual);
	}

	public PaginationDisplaytag(Integer paginaAtual, Integer linhas, Integer paginas) {
		super(paginaAtual, linhas, paginas);
	}
	
	public void paginateResult(org.hibernate.Query res) {
	
		if (paginaAtual != null){
				int extra = 0;
				if (paginaAtual % paginas == 0 && paginaAtual != 0)  extra = 1;
				res.setFirstResult(((paginaAtual)/paginas - extra)*linhas*paginas);
				res.setMaxResults(linhas*paginas + 1);
		}
		
	}
	
	public void paginateResult(org.hibernate.Criteria res) {
	
		if (paginaAtual != null){
				int extra = 0;
				if (paginaAtual % paginas == 0 && paginaAtual != 0)  extra = 1;
				res.setFirstResult(((paginaAtual)/paginas - extra)*linhas*paginas);
				res.setMaxResults(linhas*paginas + 1);
		}
		
	}

}