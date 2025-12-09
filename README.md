# 📚 Literalura — Catálogo de Livros com Spring Boot e PostgreSQL

Projeto desenvolvido em **Java com Spring Boot**, utilizando **Spring Data JPA**, **PostgreSQL** e integração com a **API Gutendex** (catálogo do Project Gutenberg).

O sistema permite buscar livros por título, armazenar os dados em banco de dados e realizar consultas locais por idioma e listagem geral, por meio de um **menu interativo no console**.

---

## 🚀 Funcionalidades

- 🔍 Buscar livros por título via API Gutendex
- 💾 Salvar livros automaticamente no banco de dados PostgreSQL
- 📚 Listar livros salvos localmente
- 🌍 Listar livros por idioma
- 🚫 Evita salvar livros duplicados
- 📈 Exibe quantidade de downloads

---

## 🧱 Arquitetura do Projeto

O projeto segue boas práticas de **arquitetura em camadas**, com separação clara de responsabilidades:


---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL 18**
- **Maven**
- **API Gutendex**
- **IntelliJ IDEA**

---

## 🗄️ Banco de Dados

O projeto utiliza **PostgreSQL** para persistência dos dados.

### Exemplo de configuração (`application.properties`)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/literalura
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA_AQUI

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

mvn spring-boot:run

===== MENU LITERALURA =====
1 - Buscar livro por título (API)
2 - Listar livros salvos
3 - Listar livros por idioma
0 - Sair
===========================

