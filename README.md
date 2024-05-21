# Como Rodar o Projeto:

## Através do Makefile (Recomendado):

### 1. Instale Biblioteca

**Windows:**

Baixando e instalando através do Link:

https://gnuwin32.sourceforge.net/packages/make.htm

**Ou via Chocolatey:**

```bash
choco install make
```

**Ubuntu**:

```bash
**sudo apt-get install make**
```

**MAC**:

```bash
brew install make
```

### 2. Execute os comandos:

Para rodar em ambiente dev (somente para debug):

```bash
make dev
```

Em produção:

```bash
make prod 
```

## Através do DockerComposer

### 1. Execute os comandos:

Para rodar em ambiente dev (somente para debug):

```bash
docker compose -f docker-compose-dev.yml up -d
```

Em produção:

```bash
docker compose -f docker-compose.yml up -d
```
