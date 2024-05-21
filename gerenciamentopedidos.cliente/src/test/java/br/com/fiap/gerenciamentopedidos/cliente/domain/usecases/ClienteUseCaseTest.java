package br.com.fiap.gerenciamentopedidos.cliente.domain.usecases;

import br.com.fiap.gerenciamentopedidos.cliente.application.exception.ClienteNaoEncontradoException;
import br.com.fiap.gerenciamentopedidos.cliente.application.gateway.ClienteDbGateway;
import br.com.fiap.gerenciamentopedidos.cliente.domain.entity.ClienteEntity;
import br.com.fiap.gerenciamentopedidos.cliente.domain.usecases.repository.ClienteRepository;
import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.ClienteDbEntity;
import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.ClienteDbRepository;
import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.lib.mapstruct.mapper.ClienteMapper;
import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.lib.mapstruct.mapper.ClienteMapperImpl;
import br.com.fiap.gerenciamentopedidos.cliente.utils.ClienteHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {ClienteMapperImpl.class})
public class ClienteUseCaseTest {

    private ClienteUseCases clienteUseCase;

    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Mock
    private ClienteDbRepository clienteDbRepository;
    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        this.openMocks = MockitoAnnotations.openMocks(this);
        this.clienteRepository = new ClienteDbGateway(clienteDbRepository, clienteMapper);
        this.clienteUseCase = new ClienteUseCasesImpl(clienteRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Nested
    class SalvarCliente {

        @Test
        void devePermitirSalvarCliente() {
            // Arrange
            ClienteEntity clienteEntity = ClienteHelper.getClienteEntity();
            when(clienteDbRepository.save(any(ClienteDbEntity.class)))
                    .thenAnswer(i -> i.getArgument(0));

            when(clienteRepository.salvarCliente(any(ClienteEntity.class)))
                    .thenAnswer(i -> i.getArgument(0));

            // Act
            ClienteEntity clienteEntityArmazenada = clienteUseCase.salvarCliente(clienteEntity);
            // Assert
            verify(clienteDbRepository, times(1)).save(
                    clienteMapper.toClienteDbEntity(clienteEntity));

            assertThat(clienteEntityArmazenada)
                    .isInstanceOf(ClienteEntity.class)
                    .isNotNull()
                    .isEqualTo(clienteEntity);
            assertThat(clienteEntityArmazenada)
                    .extracting(ClienteEntity::getId)
                    .isEqualTo(clienteEntity.getId());
            assertThat(clienteEntityArmazenada)
                    .extracting(ClienteEntity::getNome)
                    .isEqualTo(clienteEntity.getNome());
            assertThat(clienteEntityArmazenada)
                    .extracting(ClienteEntity::getCpf)
                    .isEqualTo(clienteEntity.getCpf());
            assertThat(clienteEntityArmazenada)
                    .extracting(ClienteEntity::getDataNascimento)
                    .isEqualTo(clienteEntity.getDataNascimento());
            assertThat(clienteEntityArmazenada)
                    .extracting(ClienteEntity::getEmail)
                    .isEqualTo(clienteEntity.getEmail());
            assertThat(clienteEntityArmazenada)
                    .extracting(ClienteEntity::getTelefone)
                    .isEqualTo(clienteEntity.getTelefone());
        }
    }

    @Nested
    class AtualizarCliente {

        @Test
        void devePermitirAtualizarCliente() {
            // Arrange
            UUID id = UUID.randomUUID();
            ClienteEntity clienteEntity = ClienteHelper.getClienteEntity();
            clienteEntity.setId(id);

            when(clienteDbRepository.save(any(ClienteDbEntity.class)))
                    .thenAnswer(i -> i.getArgument(0));

            when(clienteDbRepository.findById(any(UUID.class)))
                    .thenReturn(Optional.of(clienteMapper.toClienteDbEntity(clienteEntity)));

            when(clienteRepository.atualizarCliente(any(ClienteEntity.class)))
                    .thenAnswer(i -> i.getArgument(0));

            ClienteEntity clienteEntityAtualizar = ClienteHelper.getClienteEntity();
            clienteEntityAtualizar.setId(id);
            clienteEntityAtualizar.setEmail("juscelino.silva@teste.com.br");
            clienteEntityAtualizar.setTelefone("1900000000");

            // Act
            ClienteEntity clienteEntityArmazenada = clienteUseCase.atualizarCliente(clienteEntityAtualizar);
            // Assert
            verify(clienteDbRepository, times(1)).save(
                    clienteMapper.toClienteDbEntity(clienteEntityArmazenada));

            assertThat(clienteEntityArmazenada)
                    .isInstanceOf(ClienteEntity.class)
                    .isNotNull();
            assertThat(clienteEntityArmazenada)
                    .extracting(ClienteEntity::getId)
                    .isEqualTo(clienteEntity.getId());
            assertThat(clienteEntityArmazenada)
                    .extracting(ClienteEntity::getNome)
                    .isEqualTo(clienteEntity.getNome());
            assertThat(clienteEntityArmazenada)
                    .extracting(ClienteEntity::getCpf)
                    .isEqualTo(clienteEntity.getCpf());
            assertThat(clienteEntityArmazenada)
                    .extracting(ClienteEntity::getDataNascimento)
                    .isEqualTo(clienteEntity.getDataNascimento());
            assertThat(clienteEntityArmazenada)
                    .extracting(ClienteEntity::getEmail)
                    .isNotEqualTo(clienteEntity.getEmail());
            assertThat(clienteEntityArmazenada)
                    .extracting(ClienteEntity::getTelefone)
                    .isNotEqualTo(clienteEntity.getTelefone());
        }

        @Test
        void devePermitirAtualizarCliente_geraExcecaoSeClienteNaoEncontrado() {
            // Arrange

            when(clienteDbRepository.save(any(ClienteDbEntity.class)))
                    .thenAnswer(i -> i.getArgument(0));

            when(clienteRepository.atualizarCliente(any(ClienteEntity.class)))
                    .thenAnswer(i -> i.getArgument(0));

            // Assert
            assertThrows(ClienteNaoEncontradoException.class, () -> {

                ClienteEntity clienteEntityAtualizar = ClienteHelper.getClienteEntity();
                clienteEntityAtualizar.setId(UUID.randomUUID());

                clienteUseCase.atualizarCliente(clienteEntityAtualizar);
            });
        }
    }

    @Nested
    class ApagarCliente {

        @Test
        void devePermitirApagarCliente() {
            // Arrange
            UUID id = UUID.randomUUID();
            ClienteEntity clienteEntity = ClienteHelper.getClienteEntity();
            clienteEntity.setId(id);

            when(clienteDbRepository.findById(any(UUID.class)))
                    .thenReturn(Optional.of(clienteMapper.toClienteDbEntity(clienteEntity)));
            doNothing()
                    .when(clienteDbRepository).deleteById(id);

            clienteUseCase.deletarCliente(id);

            verify(clienteDbRepository, times(1)).findById(any(UUID.class));
            verify(clienteDbRepository, times(1)).deleteById(any(UUID.class));
        }

        @Test
        void devePermitirApagarCliente_geraExcecaoSeClienteNaoEncontrado() {
            // Arrange
            UUID id = UUID.randomUUID();

            doNothing()
                    .when(clienteDbRepository).deleteById(id);

            assertThrows(ClienteNaoEncontradoException.class, () -> {
                clienteUseCase.deletarCliente(id);

            });

        }

    }

    @Nested
    class BuscarCliente {

        @Test
        void devePermitirBuscarClientePorId() {
            // Arrange
            UUID id = UUID.randomUUID();
            ClienteEntity clienteEntity = ClienteHelper.getClienteEntity();
            clienteEntity.setId(id);

            when(clienteDbRepository.findById(any(UUID.class)))
                    .thenReturn(Optional.of(clienteMapper.toClienteDbEntity(clienteEntity)));
            // Act
            ClienteEntity clienteDbEntity = clienteUseCase.buscarClientePorId(id);
            // Assert
            verify(clienteDbRepository, times(1)).findById(id);
            assertThat(clienteDbEntity)
                    .isInstanceOf(ClienteEntity.class)
                    .isNotNull()
                    .isEqualTo(clienteEntity);
            assertThat(clienteDbEntity)
                    .extracting(ClienteEntity::getId)
                    .isEqualTo(clienteEntity.getId());
            assertThat(clienteDbEntity)
                    .extracting(ClienteEntity::getNome)
                    .isEqualTo(clienteEntity.getNome());
            assertThat(clienteDbEntity)
                    .extracting(ClienteEntity::getCpf)
                    .isEqualTo(clienteEntity.getCpf());
            assertThat(clienteDbEntity)
                    .extracting(ClienteEntity::getDataNascimento)
                    .isEqualTo(clienteEntity.getDataNascimento());
            assertThat(clienteDbEntity)
                    .extracting(ClienteEntity::getEmail)
                    .isEqualTo(clienteEntity.getEmail());
            assertThat(clienteDbEntity)
                    .extracting(ClienteEntity::getTelefone)
                    .isEqualTo(clienteEntity.getTelefone());

        }

        @Test
        void devePermitirBuscarClientePorEmail() {
            // Arrange
            ClienteEntity clienteEntity = ClienteHelper.getClienteEntity();

            when(clienteDbRepository.findByEmail(any(String.class)))
                    .thenReturn(clienteMapper.toClienteDbEntity(clienteEntity));
            // Act
            ClienteEntity clienteDbEntity = clienteUseCase.buscarClientePorEmail(clienteEntity.getEmail());
            // Assert
            verify(clienteDbRepository, times(1)).findByEmail(clienteEntity.getEmail());
            assertThat(clienteDbEntity)
                    .isInstanceOf(ClienteEntity.class)
                    .isNotNull()
                    .isEqualTo(clienteEntity);
            assertThat(clienteDbEntity)
                    .extracting(ClienteEntity::getId)
                    .isEqualTo(clienteEntity.getId());
            assertThat(clienteDbEntity)
                    .extracting(ClienteEntity::getNome)
                    .isEqualTo(clienteEntity.getNome());
            assertThat(clienteDbEntity)
                    .extracting(ClienteEntity::getCpf)
                    .isEqualTo(clienteEntity.getCpf());
            assertThat(clienteDbEntity)
                    .extracting(ClienteEntity::getDataNascimento)
                    .isEqualTo(clienteEntity.getDataNascimento());
            assertThat(clienteDbEntity)
                    .extracting(ClienteEntity::getEmail)
                    .isEqualTo(clienteEntity.getEmail());
            assertThat(clienteDbEntity)
                    .extracting(ClienteEntity::getTelefone)
                    .isEqualTo(clienteEntity.getTelefone());

        }

        @Test
        void devePermitirBuscarClientes() {
            // Arrange
            ClienteDbEntity clienteDbEntity1 = ClienteHelper.getClienteDbEntity();
            ClienteDbEntity clienteDbEntity2 = ClienteHelper.getClienteDbEntity();
            List<ClienteDbEntity> clienteDbEntityList = Arrays.asList(clienteDbEntity1, clienteDbEntity2);

            when(clienteDbRepository.findAll()).thenReturn(clienteDbEntityList);

            // Act
            List<ClienteEntity> resultado = clienteUseCase.buscarClientes();

            // Assert
            verify(clienteDbRepository, times(1)).findAll();
            assertThat(resultado)
                    .hasSize(2)
                    .asList()
                    .allSatisfy(cliente->{
                        assertThat(cliente).isNotNull();
                        assertThat(cliente).isInstanceOf(ClienteEntity.class);
                    });
        }

    }
}
