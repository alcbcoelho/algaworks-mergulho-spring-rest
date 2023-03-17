# 2.1. Configurando o Flyway

## Adicionando DevTools*:

*: (dependência que possibilita que a aplicação se reinicie automaticamente após modificações, similar ao Nodemon com NodeJS)

- Clicar com botão direito no projeto no *Package Explorer > Spring > Add DevTools...*

## Implementando persistência de dados (integração com o BD) no projeto:

- Clicar com botão direito no projeto no *Package Explorer > Spring > Add starters... > Spring Data JPA*

- Checar o pom.xml

## Implementando driver MySQL (ponte entre o código java e o BDMS MySQL) no projeto:

- Clicar com botão direito no projeto no *Package Explorer > Spring > Add starters... > MySQL Driver*

- Checar o pom.xml

## Implementando Flyway (que usaremos para criar e manipular tabelas) no projeto:

- Clicar com botão direito no projeto no *Package Explorer > Spring > Add starters... > Flyway Migration*

- Checar o pom.xml

## Fazendo a integração do BD com o projeto:

Em ***src/static/resources/application.properties***:

```
spring.datasource.url = jdbc:mysql://localhost:3306/algalog?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username = root
spring.datasource.password = root
```

## Flyway

- Cada operação com o banco de dados é armazenada em arquivos .sql separados dentro do caminho ***src/main/resources/db/migration***

- Uma nomenclatura específica há de ser seguida p/ que essas operações sejam efetuadas:

	`V{numero}__{descricao-breve}.sql`

	Exemplo:

	`V001__criar-tabela-cliente.sql`

- Ao se criar um novo arquivo .sql com essa nomenclatura, a tabela gerada no BD referente ao flyway (flyway_schema_history) recebe um novo registro.

	- Não queremos ter registros apenas pela criação de um novo arquivo (vazio), então sempre que se for criar um novo arquivo sql, criá-lo primeiramente FORA dos padrões de nomenclatura do flyway (ex: criar-tabela-cliente.sql) p/ somente depois de adicionar o comando SQL nele renomeá-lo de acordo com a convenção acima (ex: V001__criar-tabela-cliente.sql).

	- Assim, só constará registros na tabela flyway_schema_history para operações de fato.

## Outras notas

- Padronizar os dados temporais do BD em UTC (conforme especificado pelos query params acima) é geralmente uma boa prática

# 2.2. Usando Jakarta Persistence API (JPA)

- **JPA:** Especificação que ajuda a mapear um banco de dados relacional em classes Java (mapeamento objeto relacional - ORM).
	- A ideia é usar o JPA para fazer operações de manipulação de dados, ao invés do SQL cru.

- **Hibernate:** Implementação do JPA (como se fosse uma classe que interpreta a interface).

- **Spring Data JPA:** Biblioteca/dependência para nos ajudar a trabalhar com Jakarta Persistence.

<img src="https://javabydeveloper.com/wp-content/uploads/2020/02/ORM-object-relational-mapping.png?ezimgfmt=ng%3Awebp%2Fngcb330%2Frs%3Adevice%2Frscb330-1">

# 2.3. Usando Spring Data JPA

- **Spring Data JPA:** Biblioteca para se criar repositórios com Jakarta Persistence. NÃO é uma implementação do JPA!
	- **Repositório:** Classe que permite implementar métodos que permitem realizar as operações de persistência (manipulação) de dados.
- O Spring Data JPA instancia, on-the-go, um repositório para cada entidade do BD a partir de uma interface {EntityName}Repository, que estende a interface `JpaRepository<T, ID>` - que contém a especificação de vários métodos p/ realização de operações com o BD.
	- `T:` Tipo da entidade associada ao repositório em questão
	- `ID:` Tipo associado ao atributo identificador primário da entidade.

Exemplo de uma interface de repositório:

```
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
```git push