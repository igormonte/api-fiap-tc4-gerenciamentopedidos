package br.com.fiap.gerenciamentopedidos.cliente.domain.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ClienteEntity {

    private UUID id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private Endereco endereco;

    public ClienteEntity(
            String nome,
            String cpf,
            LocalDate dataNascimento,
            String email,
            String telefone,
            Endereco endereco
    ) {

        if(nome.isEmpty()) {
            throw new RuntimeException("Nome não pode ser nulo");
        }
        if(cpf.isEmpty()) {
            throw new RuntimeException("Cpf não pode ser nulo");
        }
        if(dataNascimento == null) {
            throw new RuntimeException("Data de Nascimento não pode ser nulo");
        }
        if(email.isEmpty()) {
            throw new RuntimeException("E-mail não pode ser nulo");
        }
        if(telefone.isEmpty()) {
            throw new RuntimeException("Telefone não pode ser nulo");
        }
        if(endereco == null) {
            throw new RuntimeException("Endereço não pode ser nulo");
        }

        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;

    }

}
