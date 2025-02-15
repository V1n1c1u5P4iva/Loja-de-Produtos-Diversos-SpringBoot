# Loja de Produtos Diversos - Em Desenvolvimento

Este é um projeto em desenvolvimento de uma **Loja de Produtos Diversos** utilizando o framework **Spring Boot**. A aplicação tem como objetivo a gestão de fornecedores, clientes, produtos, vendas e itens de venda. Está sendo desenvolvido como parte de estudos para colocar em prática conceitos de desenvolvimento backend, utilizando o banco de dados **PostgreSQL** para simular um ambiente mais próximo do real.

## Diagrama ERD (Entidade-Relacionamento)

```mermaid
erDiagram
    FORNECEDOR {
        bigint id PK
        string nome
        string cnpj
        string telefone
        string endereco
    }

    CLIENTE {
        bigint id PK
        string nome
        string email
        string telefone
        string endereco
    }

    PRODUTO {
        bigint id PK
        string nome
        string descricao
        float preco
        int estoque
        bigint fornecedor_id FK
    }

    VENDA {
        bigint id PK
        date data
        bigint cliente_id FK
    }

    ITEMVENDA {
        bigint id PK
        bigint venda_id FK
        bigint produto_id FK
        int quantidade
        float preco_unitario
    }

    FORNECEDOR ||--o{ PRODUTO : fornece
    CLIENTE ||--o{ VENDA : realiza
    VENDA ||--o{ ITEMVENDA : contem
    PRODUTO ||--o{ ITEMVENDA : compoe
```
