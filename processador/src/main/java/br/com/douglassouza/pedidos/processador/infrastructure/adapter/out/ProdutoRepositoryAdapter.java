package br.com.douglassouza.pedidos.processador.infrastructure.adapter.out;

import br.com.douglassouza.pedidos.processador.domain.model.Produto;
import br.com.douglassouza.pedidos.processador.infrastructure.repository.ProdutoRepository;
import br.com.douglassouza.pedidos.processador.port.out.ProdutoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {

    private final ProdutoRepository produtoRepository;

    @Override
    public void save(Produto produto) {
        produtoRepository.save(produto);
    }
}
