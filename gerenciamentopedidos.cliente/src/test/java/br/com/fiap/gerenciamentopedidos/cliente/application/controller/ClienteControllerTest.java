package br.com.fiap.gerenciamentopedidos.cliente.application.controller;

import br.com.fiap.gerenciamentopedidos.cliente.application.dto.AtualizarClienteRequestDto;
import br.com.fiap.gerenciamentopedidos.cliente.application.dto.DeletarClienteRequestDto;
import br.com.fiap.gerenciamentopedidos.cliente.application.dto.SalvarClienteRequestDto;
import br.com.fiap.gerenciamentopedidos.cliente.application.handler.GlobalExceptionHandler;
import br.com.fiap.gerenciamentopedidos.cliente.domain.entity.ClienteEntity;
import br.com.fiap.gerenciamentopedidos.cliente.domain.usecases.ClienteUseCases;
import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.lib.mapstruct.mapper.ClienteMapper;
import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.lib.mapstruct.mapper.ClienteMapperImpl;
import br.com.fiap.gerenciamentopedidos.cliente.utils.ClienteHelper;
import com.callibrity.logging.test.LogTracker;
import com.callibrity.logging.test.LogTrackerStub;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {ClienteMapperImpl.class})
public class ClienteControllerTest {

    private MockMvc mockMvc;

    @RegisterExtension
    LogTrackerStub logTracker = LogTrackerStub.create().recordForLevel(LogTracker.LogLevel.INFO)
            .recordForType(ClienteMapper.class);

    @Mock
    private ClienteUseCases clienteUseCases;

    @Autowired
    private ClienteMapper clienteMapper;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        ClienteApi clienteApi = new ClienteController(
                this.clienteUseCases,
                this.clienteMapper);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteApi)
                .setControllerAdvice(new GlobalExceptionHandler())
                .addFilter((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                }, "/*")
                .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }


    @Test
    void devePermitirSalvarCliente() throws Exception {
        SalvarClienteRequestDto salvarClienteRequestDto = ClienteHelper.getSalvarClienteRequestDto();
        when(clienteUseCases.salvarCliente(any(ClienteEntity.class)))
                .thenAnswer(i -> i.getArgument(0));

        mockMvc.perform(post("/api/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(salvarClienteRequestDto)))
//                    .andDo(print())
                .andExpect(status().isCreated());
        verify(clienteUseCases, times(1))
                .salvarCliente(any(ClienteEntity.class));
    }


    @Test
    void devePermitirBuscarClientes() throws Exception {
        ClienteEntity clienteEntity = this.clienteMapper.toClienteEntity(ClienteHelper.getClienteDbEntity());
        List<ClienteEntity> clienteEntityList = List.of(clienteEntity);

        when(clienteUseCases.buscarClientes()).thenReturn(clienteEntityList);

        mockMvc.perform(get("/api/cliente")
                        .contentType(MediaType.APPLICATION_JSON))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(clienteEntity.getId().toString()))
                .andExpect(jsonPath("$[0].cpf").value(clienteEntity.getCpf()))
                .andExpect(jsonPath("$[0].nome").value(clienteEntity.getNome()))
                .andExpect(jsonPath("$[0].email").value(clienteEntity.getEmail()))
                .andExpect(jsonPath("$[0].telefone").value(clienteEntity.getTelefone()))
                .andExpect(jsonPath("$[0].dataNascimento").exists())
                .andExpect(jsonPath("$[0].endereco").exists());
        verify(clienteUseCases, times(1)).buscarClientes();

    }

    @Test
    void devePermitirBuscarClientePorId() throws Exception {
        UUID id = UUID.randomUUID();
        ClienteEntity clienteEntity = this.clienteMapper.toClienteEntity(ClienteHelper.getClienteDbEntity());
        clienteEntity.setId(id);

        when(clienteUseCases.buscarClientePorId(any(UUID.class))).thenReturn(clienteEntity);

        mockMvc.perform(get("/api/cliente?id={id}", id)
                .contentType(MediaType.APPLICATION_JSON))
//                    .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(clienteEntity.getId().toString()))
                .andExpect(jsonPath("$.cpf").value(clienteEntity.getCpf()))
                .andExpect(jsonPath("$.nome").value(clienteEntity.getNome()))
                .andExpect(jsonPath("$.email").value(clienteEntity.getEmail()))
                .andExpect(jsonPath("$.telefone").value(clienteEntity.getTelefone()))
                .andExpect(jsonPath("$.dataNascimento").exists())
                .andExpect(jsonPath("$.endereco").exists());
        verify(clienteUseCases, times(1)).buscarClientePorId(any(UUID.class));

    }

    @Test
    void devePermitirBuscarClientePorEmail() throws Exception {
        ClienteEntity clienteEntity = this.clienteMapper.toClienteEntity(ClienteHelper.getClienteDbEntity());

        when(clienteUseCases.buscarClientePorEmail(any(String.class))).thenReturn(clienteEntity);

        mockMvc.perform(get("/api/cliente?email={email}", clienteEntity.getEmail())
                        .contentType(MediaType.APPLICATION_JSON))
//                    .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(clienteEntity.getId().toString()))
                .andExpect(jsonPath("$.cpf").value(clienteEntity.getCpf()))
                .andExpect(jsonPath("$.nome").value(clienteEntity.getNome()))
                .andExpect(jsonPath("$.email").value(clienteEntity.getEmail()))
                .andExpect(jsonPath("$.telefone").value(clienteEntity.getTelefone()))
                .andExpect(jsonPath("$.dataNascimento").exists())
                .andExpect(jsonPath("$.endereco").exists());
        verify(clienteUseCases, times(1)).buscarClientePorEmail(any(String.class));

    }

    @Test
    void devePermitirAtualizarCliente() throws Exception {
        AtualizarClienteRequestDto atualizarClienteRequestDto = ClienteHelper.getAtualizarClienteRequestDto();
        when(clienteUseCases.atualizarCliente(any(ClienteEntity.class)))
                .thenAnswer(i -> i.getArgument(0));

        mockMvc.perform(put("/api/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(atualizarClienteRequestDto)))
//                    .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(atualizarClienteRequestDto.id().toString()))
                .andExpect(jsonPath("$.cpf").value(atualizarClienteRequestDto.cpf()))
                .andExpect(jsonPath("$.nome").value(atualizarClienteRequestDto.nome()))
                .andExpect(jsonPath("$.email").value(atualizarClienteRequestDto.email()))
                .andExpect(jsonPath("$.telefone").value(atualizarClienteRequestDto.telefone()))
                .andExpect(jsonPath("$.dataNascimento").exists())
                .andExpect(jsonPath("$.endereco").exists());
        verify(clienteUseCases, times(1))
                .atualizarCliente(any(ClienteEntity.class));

    }

    @Test
    void devePermitirDeletarCliente() throws Exception {
        var id = UUID.randomUUID();
        DeletarClienteRequestDto deletarClienteRequestDto = new DeletarClienteRequestDto(id);
        when(clienteUseCases.deletarCliente(any(UUID.class))).thenReturn(true);

        mockMvc.perform(delete("/api/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(deletarClienteRequestDto)))
                .andExpect(status().isNoContent());
        verify(clienteUseCases, times(1))
                .deletarCliente(any(UUID.class));

    }

    public static String asJsonString(final Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper()
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());

            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
