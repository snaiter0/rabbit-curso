package br.com.douglassouza.pedidos.processador.port.out;

import br.com.douglassouza.pedidos.processador.domain.model.Produto;
import jakarta.transaction.Transactional;

public interface ProdutoRepositoryPort {
    
    @Transactional
    void save(Produto produto);
}
