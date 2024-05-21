package br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.repository;

import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.ClienteDbEntity;
import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.ClienteDbRepository;
import br.com.fiap.gerenciamentopedidos.cliente.utils.ClienteHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ClienteDbRepositoryTest {

    @Mock
    private ClienteDbRepository clienteDbRepository;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void devePermitirRegistrarCliente() {
        // Arrange
        var clienteDbEntity = ClienteHelper.getClienteDbEntity();
        when(clienteDbRepository.save(any(ClienteDbEntity.class))).thenReturn(clienteDbEntity);
        // Act
        var clienteDbEntityArmazenada = clienteDbRepository.save(clienteDbEntity);
        // Assert
        verify(clienteDbRepository, times(1)).save(clienteDbEntity);
        assertThat(clienteDbEntityArmazenada)
                .isInstanceOf(ClienteDbEntity.class)
                .isNotNull()
                .isEqualTo(clienteDbEntity);
        assertThat(clienteDbEntityArmazenada)
                .extracting(ClienteDbEntity::getId)
                .isEqualTo(clienteDbEntity.getId());
        assertThat(clienteDbEntityArmazenada)
                .extracting(ClienteDbEntity::getNome)
                .isEqualTo(clienteDbEntity.getNome());
        assertThat(clienteDbEntityArmazenada)
                .extracting(ClienteDbEntity::getCpf)
                .isEqualTo(clienteDbEntity.getCpf());
        assertThat(clienteDbEntityArmazenada)
                .extracting(ClienteDbEntity::getDataNascimento)
                .isEqualTo(clienteDbEntity.getDataNascimento());
        assertThat(clienteDbEntityArmazenada)
                .extracting(ClienteDbEntity::getEmail)
                .isEqualTo(clienteDbEntity.getEmail());
        assertThat(clienteDbEntityArmazenada)
                .extracting(ClienteDbEntity::getTelefone)
                .isEqualTo(clienteDbEntity.getTelefone());
    }

    @Test
    void devePermitirConsultarCliente() {
        // Arrange
        var id = UUID.randomUUID();
        var clienteDbEntity = ClienteHelper.getClienteDbEntity();
        clienteDbEntity.setId(id);

        when(clienteDbRepository.findById(any(UUID.class)))
                .thenReturn(Optional.of(clienteDbEntity));
        // Act
        var clienteDbEntityOptional = clienteDbRepository.findById(id);
        // Assert
        verify(clienteDbRepository, times(1)).findById(id);
        assertThat(clienteDbEntityOptional)
                .isPresent()
                .containsSame(clienteDbEntity);
        clienteDbEntityOptional.ifPresent(clienteDbEntityArmazenada -> {
            assertThat(clienteDbEntityArmazenada)
                    .extracting(ClienteDbEntity::getId)
                    .isEqualTo(clienteDbEntity.getId());
            assertThat(clienteDbEntityArmazenada)
                    .extracting(ClienteDbEntity::getNome)
                    .isEqualTo(clienteDbEntity.getNome());
            assertThat(clienteDbEntityArmazenada)
                    .extracting(ClienteDbEntity::getCpf)
                    .isEqualTo(clienteDbEntity.getCpf());
            assertThat(clienteDbEntityArmazenada)
                    .extracting(ClienteDbEntity::getDataNascimento)
                    .isEqualTo(clienteDbEntity.getDataNascimento());
            assertThat(clienteDbEntityArmazenada)
                    .extracting(ClienteDbEntity::getEmail)
                    .isEqualTo(clienteDbEntity.getEmail());
            assertThat(clienteDbEntityArmazenada)
                    .extracting(ClienteDbEntity::getTelefone)
                    .isEqualTo(clienteDbEntity.getTelefone());
        });
    }

    @Test
    void devePermitirApagarCliente() {
        // Arrange
        var id = UUID.randomUUID();
        doNothing().when(clienteDbRepository).deleteById(id);
        // Act
        clienteDbRepository.deleteById(id);
        // Assert
        verify(clienteDbRepository, times(1)).deleteById(id);
    }

    @Test
    void devePermitirListarClientes() {
        // Arrange
        var clienteDbEntity1 = ClienteHelper.getClienteDbEntity();
        var clienteDbEntity2 = ClienteHelper.getClienteDbEntity();
        var clienteDbEntityList = Arrays.asList(clienteDbEntity1, clienteDbEntity2);

        when(clienteDbRepository.findAll()).thenReturn(clienteDbEntityList);

        // Act
        var resultado = clienteDbRepository.findAll();

        // Assert
        verify(clienteDbRepository, times(1)).findAll();
        assertThat(resultado)
                .hasSize(2)
                .containsExactlyInAnyOrder(clienteDbEntity1, clienteDbEntity2);
    }
}
