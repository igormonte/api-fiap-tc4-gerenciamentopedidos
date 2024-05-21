package br.com.fiap.gerenciamentopedidos.cliente.domain.entity;

import br.com.fiap.gerenciamentopedidos.cliente.utils.ClienteHelper;
import lombok.Data;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Data
public class ClienteEntityTest {

    @Test
    void deveCriarCliente() {
        ClienteEntity clienteEntity = ClienteHelper.getClienteEntity();
        assertThat(clienteEntity).isNotNull();
        assertThat(clienteEntity.getCpf()).isNotBlank();
        assertThat(clienteEntity.getDataNascimento()).isNotNull();
        assertThat(clienteEntity.getEmail()).isNotBlank();
        assertThat(clienteEntity.getTelefone()).isNotBlank();
        assertThat(clienteEntity.getEndereco()).isNotNull();
    }


    @Test
    void deveCriarCliente_GeraInstanciaSeNomeNulo() {

        assertThrows(Exception.class, () -> {
            ClienteEntity model = ClienteHelper.getClienteEntity();
            ClienteEntity testEntity =  new ClienteEntity(
                null,
                model.getCpf(),
                model.getDataNascimento(),
                model.getEmail(),
                model.getTelefone(),
                model.getEndereco()
            );
        });
    }

    @Test
    void deveCriarCliente_GeraInstanciaSeCpfNulo() {
        assertThrows(Exception.class, () -> {
            ClienteEntity model = ClienteHelper.getClienteEntity();
            ClienteEntity testEntity =  new ClienteEntity(
                model.getNome(),
                null,
                model.getDataNascimento(),
                model.getEmail(),
                model.getTelefone(),
                model.getEndereco()
            );
        });
    }

    @Test
    void deveCriarCliente_GeraInstanciaSeDataNascimentoNulo() {
        assertThrows(Exception.class, () -> {
            ClienteEntity model = ClienteHelper.getClienteEntity();
            ClienteEntity testEntity =  new ClienteEntity(
                model.getNome(),
                model.getCpf(),
                null,
                model.getEmail(),
                model.getTelefone(),
                model.getEndereco()
            );
        });
    }

    @Test
    void deveCriarCliente_GeraInstanciaSeEmailNulo() {
        assertThrows(Exception.class, () -> {
            ClienteEntity model = ClienteHelper.getClienteEntity();
            ClienteEntity testEntity =  new ClienteEntity(
                model.getNome(),
                model.getCpf(),
                model.getDataNascimento(),
                null,
                model.getTelefone(),
                model.getEndereco()
            );
        });
    }

    @Test
    void deveCriarCliente_GeraInstanciaSeTelefoneNulo() {
        assertThrows(Exception.class, () -> {
            ClienteEntity model = ClienteHelper.getClienteEntity();
            ClienteEntity testEntity =  new ClienteEntity(
                model.getNome(),
                model.getCpf(),
                model.getDataNascimento(),
                model.getEmail(),
                null,
                model.getEndereco()
            );
        });
    }

    @Test
    void deveCriarCliente_GeraInstanciaSeEnderecoNulo() {
        assertThrows(Exception.class, () -> {
            ClienteEntity model = ClienteHelper.getClienteEntity();
            ClienteEntity testEntity =  new ClienteEntity(
                model.getNome(),
                model.getCpf(),
                model.getDataNascimento(),
                model.getEmail(),
                model.getTelefone(),
                null
            );
        });
    }

}
