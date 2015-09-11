package br.com.compra.combinada.dao;

import br.com.compra.combinada.bean.ListaCotacao;
import br.com.compra.combinada.bean.ListaProdutoCotacao;
import br.com.compra.combinada.bean.ListaProdutoCotacaoAudit;

public interface ListaProdutoCotacaoAuditDAO {

	public void salvar(ListaProdutoCotacaoAudit listaProdutoCotacaoAudit);
	
	public void update(ListaProdutoCotacaoAudit listaProdutoCotacao);
	
	public ListaCotacao carregar(Integer idListaProdutoCotacao);
}
