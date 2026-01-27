# 🛠️ Estagio-1-Java-Exercicio-Sistema-Gestao-Servicos

Este projeto foi desenvolvido como parte do meu **treinamento em Java e Programação Orientada a Objetos**, com foco em **boas práticas de arquitetura**, **persistência de dados** e **modelagem orientada a objetos**.

⚠️ **Projeto exclusivamente educacional**, criado para fins de aprendizado.
Não representa código de produção nem sistemas internos de nenhuma empresa.

---

## 🎯 Objetivo do Projeto

O objetivo deste sistema é **simular um sistema de gestão de serviços**, permitindo o **cadastro, consulta e remoção de serviços**, utilizando **Java + JPA (Hibernate)** e aplicando conceitos avançados de **POO**.

Toda a aplicação funciona via **console**, com persistência dos dados em banco de dados através do **EntityManager**.

---

## 📋 Funcionalidades

✅ Criar novos serviços

✅ Listar serviços cadastrados

✅ Buscar serviços por **ID**

✅ Excluir serviços por **ID**

📔 Atualização de serviços (planejada)

---

## 🧩 Tipos de Serviço

O sistema trabalha com **herança** para representar diferentes tipos de serviço:

### 🔹 DevelopmentService

* Tipo: `DEVELOPMENT`
* Linguagem utilizada na programação do projeto
* Ideal para simular serviços de desenvolvimento de software

### 🔹 MaintenanceService

* Tipo: `MAINTENANCE`
* Local onde ocorreu a manutenção
* Descrição do problema encontrado

### 🔹 SupportService

* Tipo: `SUPPORT`
* Quem solicitou o suporte
* Como o problema foi resolvido

Todos herdam da classe abstrata **`Service`**, utilizando **herança com JPA (`SINGLE_TABLE`)**.

---

## 🧠 Conceitos de POO e Arquitetura Aplicados

✔️ Programação Orientada a Objetos (POO)

✔️ **Herança e Polimorfismo**

✔️ Classe abstrata (`Service`)

✔️ Enums (`ServiceType`, `ServiceStatus`, `ServicePriority`)

✔️ Padrão **DAO (Data Access Object)**

✔️ Separação de camadas (`application`, `controller`, `entities`)

✔️ Persistência com **JPA / Hibernate**

✔️ Uso de `EntityManager`

✔️ Mapeamento ORM com anotações

✔️ Collections (`List`, `ArrayList`)

---

## 🛠️ Tecnologias Utilizadas

* ☕ **Java**

* 🗄️ **JPA (Hibernate)**

* 🧠 **Programação Orientada a Objetos**

* 🖥️ **Aplicação Console**

* 📦 **Maven / Jakarta Persistence**

* 🗃️ **Banco de dados relacional**

---

## 🔄 Fluxo do Programa

1. Exibição de um **menu interativo**
2. Usuário escolhe uma das opções:

   * Criar novo serviço
   * Listar serviços
   * Buscar por ID
   * Excluir por ID
   * Encerrar aplicação
3. Dados são persistidos no banco via **JPA**
4. A aplicação permanece ativa até o usuário optar por sair

---

## 🚀 Aprendizados

Com este projeto foi possível consolidar:

* Modelagem de domínio com **herança**
* Uso de **JPA/HIBERNATE com estratégia SINGLE_TABLE**
* Implementação do padrão **DAO**
* Uso de **Enums** para estados e prioridades
* Persistência de objetos complexos
* Organização de projetos Java em camadas
* Construção de sistemas CRUD no console

---

## 👨‍💻 Autor

**Yuri Duarte**

Estagiário | Desenvolvedor Java
Treinamento em **Java, JPA e Programação Orientada a Objetos**
