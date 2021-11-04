# PasswordAPI
API to validate password - test

# Descrição

Considere uma senha sendo válida quando a mesma possuir as seguintes definições:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
  - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

Exemplo:  

```c#
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```

> **_Nota:_**  Espaços em branco não devem ser considerados como caracteres válidos.

## Problema

A aplicação expõe uma API web que valida se uma senha é válida.

Input: Uma senha (string).  
Output: Um boolean indicando se a senha é válida.

POSSUI:

- Testes de unidade / integração
- Abstração, acoplamento, extensibilidade e coesão
- Design de API
- Clean Code
- SOLID
- Documentação da solução no *README* 


### Executando o projeto:

Desenvolvido em Java 1.8 com o Framework Spring Boot 2.5.6, JUnit e Swagger;

Para executar:

- Importe o projeto para alguma IDE de sua preferência, por ex: Spring Tool Suite, utilize o Maven (mvn install) para baixar as dependêcias;
- Com as dependências baixadas, execute aplicação utilizando o Run > Spring Boot App
- No Repositório, está disponibilizado uma versão passwordApi-0.0.1-SNAPSHOT.jar que pode ser executada rapidamente via CMD utilizando 
- Java 1.8 (java -jar passwordApi-0.0.1-SNAPSHOT.jar) e visualizado a saída no navegador/Postman.
- Base: http://localhost:8080 & /password (Redireciona para documentação da API - Swagger)
- http://localhost:8080/password (POST) realizada a validação da senha inseriada no body da requisição.

## Implementação

- O projeto é baseado na arquitetura de API Restfull - utilizando MVC;
- Está aplicação foi adaptada visando atender da forma mais efetiva ao objetivo do teste;
- Funcionamento: Ao receber a requisição post no recurso /password, é realizado a validação do conteúdo, utilizando metódos independentes
desenvolvidos para garantir a consistência de cada ponto requerido na regra de negócios;
- O processamento é continuado utilizando funçoes que possuem Expressões Regulares (regex) que otimizam o código com a redução da escrita;
- Toda funcionalidade é garantida por meio dos testes unitários, integrados e testes automatizados que verificam o funcionamento e disponibilidade da API.

Contato:

fontenelelucas8@gmail.com
(86) 9 9466-6972
