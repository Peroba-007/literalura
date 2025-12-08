# 📚 Literalura

Aplicação Java desenvolvida com **Spring Boot** que consome a API pública **Gutendex** para busca de livros por título, persistindo os dados em um banco **PostgreSQL** e permitindo consultas via menu interativo no console.

Projeto desenvolvido com foco em **boas práticas**, **arquitetura em camadas** e **integração com API externa + banco relacional**.

---

## 🚀 Funcionalidades

- 🔍 Busca de livros por título utilizando a API Gutendex
- 💾 Persistência de dados no PostgreSQL
- 📋 Listagem de todos os livros cadastrados
- 🌎 Filtro de livros por idioma (pt, en, es, fr)
- ⚠️ Prevenção de duplicidade de registros
- 🧠 Separação clara de responsabilidades (Service / Repository)

---

## 🛠 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Hibernate ORM**
- **PostgreSQL**
- **Maven**
- **API Gutendex**
- **IntelliJ IDEA**

---

## 🧱 Arquitetura do Projeto

O projeto segue o padrão de **arquitetura em camadas**:


---

## ⚙️ Configuração do Banco de Dados

No arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/literalura
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA_AQUI

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

git clone https://github.com/Peroba-007/literalura.git

cd literalura

mvn spring-boot:run

===== MENU LITERALURA =====
1 - Buscar livro por título (API)
2 - Listar livros salvos
3 - Listar livros por idioma
0 - Sair
===========================


---

## ✅ O QUE VOCÊ TEM AGORA
✔️ Projeto **de portfólio real**  
✔️ README no nível de mercado  
✔️ Código funcional  
  


- 🟦 Post profissional para LinkedIn  
- 🟩 Texto curto para recrutador  
- 🟨 Pequenos ajustes estéticos  


