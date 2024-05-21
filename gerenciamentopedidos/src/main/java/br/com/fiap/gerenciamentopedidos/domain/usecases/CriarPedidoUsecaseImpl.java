package br.com.fiap.gerenciamentopedidos.domain.usecases;

import br.com.fiap.gerenciamentopedidos.domain.entity.EnderecoEntity;
import br.com.fiap.gerenciamentopedidos.domain.entity.ItemEntity;
import br.com.fiap.gerenciamentopedidos.domain.entity.PedidoEntity;
import br.com.fiap.gerenciamentopedidos.domain.entity.StatusPedido;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.ClienteRepository;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.PedidoRepository;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.ProdutoRepository;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.TrajetoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
public class CriarPedidoUsecaseImpl implements CriarPedidoUsecase {

    private final PedidoRepository pedidoRepository;

    private final ProdutoRepository produtoRepository;
    private final TrajetoRepository trajetoRepository;
    private final ClienteRepository clienteRepository;

    public CriarPedidoUsecaseImpl(
            PedidoRepository pedidoRepository,
            ProdutoRepository produtoRepository, TrajetoRepository trajetoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.trajetoRepository = trajetoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public PedidoEntity executar(PedidoEntity pedido) {

        if(!this.verificaSeClienteExiste(pedido.getIdCliente())) {
            throw new RuntimeException("Cliente não encontrado!");
        }

        EnderecoEntity endereco = this.buscaEnderecoCliente(pedido.getIdCliente());

        pedido.setEnderecoEntrega(endereco);
        pedido.setStatus(StatusPedido.INICIADO);
        pedido.setDataCriacao(LocalDateTime.now());

        List<ItemEntity> itemEntityList = this.adicionarProdutos(pedido.getItem());
        pedido.setItem(itemEntityList);

        PedidoEntity pedidoSalvo = this.pedidoRepository.salvarPedido(pedido);

        if(!this.baixarProdutos(pedidoSalvo.getItem())) {
            this.pedidoRepository.deletaPedidoPorId(pedidoSalvo.getId());
            throw new RuntimeException("Ocorreu um problema ao concretizar o pedido!");

        }

        this.criaTrajeto(pedidoSalvo);

        return pedidoSalvo;
    }

    private Boolean verificaSeClienteExiste(UUID idCliente) {

        UUID id = this.clienteRepository.verificaSeClienteExiste(idCliente);

        if(id != null) {
            return true;
        }

        return false;

    }

    private EnderecoEntity buscaEnderecoCliente(UUID idCliente) {
        return this.clienteRepository.buscarEnderecoClientePorId(idCliente);
    }

    private List<ItemEntity> adicionarProdutos(List<ItemEntity> itemEntityList) {

        return itemEntityList.stream().map(item->{

            if(!this.produtoRepository.verificarDisponibilidadeProduto(
                    item.getIdProduto(),
                    item.getQuantidade())) {
                throw new RuntimeException(String.format("Produto: %s indisponível!", item.getNomeProduto()));
            }

            ItemEntity itemSalvo = this.produtoRepository.buscarProdutoPorId(item.getIdProduto());

            item.setId(itemSalvo.getId());
            item.setValor(itemSalvo.getValor());
            item.setNomeProduto(itemSalvo.getNomeProduto());

            return item;

        }).toList();

    }

    private Boolean baixarProdutos(List<ItemEntity> itemEntityList) {

        return itemEntityList.stream().map(item->
            this.produtoRepository.baixarProduto(
                    item.getIdProduto(),
                    item.getQuantidade()
            )
         )
        .filter(i-> !i)
        .findAny().isEmpty();
    }

    private Boolean criaTrajeto(PedidoEntity pedido) {
        return this.trajetoRepository.criaTrajeto(pedido);
    }


}
