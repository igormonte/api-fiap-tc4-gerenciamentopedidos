package br.com.fiap.gerenciamentopedidos.cliente.utils;

import br.com.fiap.gerenciamentopedidos.cliente.application.dto.AtualizarClienteRequestDto;
import br.com.fiap.gerenciamentopedidos.cliente.application.dto.SalvarClienteRequestDto;
import br.com.fiap.gerenciamentopedidos.cliente.domain.entity.ClienteEntity;
import br.com.fiap.gerenciamentopedidos.cliente.domain.entity.Endereco;
import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.ClienteDbEntity;

import java.time.LocalDate;
import java.util.UUID;

public class ClienteHelper {

    public static ClienteEntity getClienteEntity() {
        String nome = "Juscelino Rodrigues da Silva";
        String cpf = "725.862.340-06";
        LocalDate dataNascimento = LocalDate.of(1990,3,5);
        String email = "juscelino.silva@exemplo.com.br";
        String telefone = "19999999999";
        Endereco endereco = new Endereco("",
                0,
                "",
                "",
                "",
                ""
        );
        return new ClienteEntity(
                nome,
                cpf,
                dataNascimento,
                email,
                telefone,
                endereco
        );
    }
    public static ClienteDbEntity getClienteDbEntity() {
        UUID id = UUID.randomUUID();
        String nome = "Juscelino Rodrigues da Silva";
        String cpf = "725.862.340-06";
        LocalDate dataNascimento = LocalDate.of(1990,3,5);
        String email = "juscelino.silva@exemplo.com.br";
        String telefone = "19999999999";
        Endereco endereco = new Endereco("",
                0,
                "",
                "",
                "",
                ""
        );
        ClienteDbEntity clienteDb = new ClienteDbEntity();
        clienteDb.setId(id);
        clienteDb.setNome(nome);
        clienteDb.setCpf(cpf);
        clienteDb.setDataNascimento(dataNascimento);
        clienteDb.setEmail(email);
        clienteDb.setTelefone(telefone);
        clienteDb.setEndereco(endereco);
        return clienteDb;
    }

    public static SalvarClienteRequestDto getSalvarClienteRequestDto() {
        String nome = "Juscelino Rodrigues da Silva";
        String cpf = "725.862.340-06";
        LocalDate dataNascimento = LocalDate.of(1990,3,5);
        String email = "juscelino.silva@exemplo.com.br";
        String telefone = "19999999999";
        Endereco endereco = new Endereco("",
                0,
                "",
                "",
                "",
                ""
        );
        return new SalvarClienteRequestDto(
                nome,
                cpf,
                dataNascimento,
                email,
                telefone,
                endereco
        );
    }

    public static AtualizarClienteRequestDto getAtualizarClienteRequestDto() {
        UUID id = UUID.randomUUID();
        String nome = "Juscelino Rodrigues da Silva";
        String cpf = "725.862.340-06";
        LocalDate dataNascimento = LocalDate.of(1990,3,5);
        String email = "juscelino.silva@exemplo.com.br";
        String telefone = "19999999999";
        Endereco endereco = new Endereco("",
                0,
                "",
                "",
                "",
                ""
        );
        return new AtualizarClienteRequestDto(
                id,
                nome,
                cpf,
                dataNascimento,
                email,
                telefone,
                endereco
        );
    }

}
