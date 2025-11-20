# EncurtadorUrlSpring

***

Projeto baseado no desafio do GitHub :
 - https://github.com/backend-br/desafios/blob/master/url-shortener/PROBLEM.md

***

O seu desafio será implementar um serviço que permite encurtar URLs longas para torná-las mais compactas e fáceis de
compartilhar.

**Exemplo**

O seu serviço recebe uma chamada para encurtar uma URL.

**[POST]** `{{host}}/shorten-url`

```
{
    "url": "https://backendbrasil.com.br"
}
```

E retorna um JSON com a URL encurtada:

```
HTTP/1.1 200 OK

```

```
{
    "url": "https://xxx.com/DXB6V"
}
```

**Requisitos**

- O encurtador de URLs recebe uma URL longa como parâmetro inicial.
- O encurtamento será composto por um mínimo de 05 e um máximo de 10 caracteres.
- Apenas letras e números são permitidos no encurtamento.
- A URL encurtada será salva no banco de dados com um prazo de validade (você pode escolher a duração desejada).
- Ao receber uma chamada para a URL encurtada `https://xxx.com/DXB6V`, você deve fazer o redirecionamento para a
URL original salva no banco de dados. Caso a URL não seja encontrada no banco, retorne o código de
status `HTTP 404 (Not Found)`.

***


#Informacoes 

o projeto foi feito em Spring boot java na parte do back end, e como um extra o front end em html. 

Pontos de observacao :
 - O Spring tem como dependencia no lombok, jpa, devtools e start-web
 - h2 database como banco de dados 
 - As pastas sendo organizados em entidade, service, controler, Dto e repositorio

 ***

 - Entidade toma conta do modelo do banco de dados e na criacao do objeto 
 - Dto cuida da parte de padronizacao do objeto
 - Crontoler tem o objetivo de fazer o as rotas de requisicaos Post e Get
 - O repositorio cuida da comunicacao com o banco de dados
 - Service faz a parte de logica 

***

# Organizacao de pastas :

|front end <br>
--| - index.html <br>
|src<br>
--|main<br>
---|java<br>
----|alexandreS<br>
-----| - Crontoler<br>
          |urlControler.java<br>
-----| - DTO<br>
          |urlDto.java<br>
-----| - Entidade<br>
          |entidadeUrl.java<br>
-----| - Repositorio<br>
          |repositorioUrl.java<br>
-----| - Service<br>
          |Conversor.java<br>
          |serviceUrl.java<br>

***

# Problemas 

Alguns dos problemas que passei nesse projeto, foram o do Conversor de url e do Cors do front end.

A parte principal do projeto e a conversor de uma url longa para curta a partir do id dele guardado no banco, e para ter os caracteres mínimos de 5 preenchi com letras "a", agora para decriptografar foi feito para retorna o id original guardado no banco e redirecionar o url original.

Um outro problema foi a comunicacao com o front end e o back end, que tive problemas com cors, que utilizei a ia "deepseek" para a explicacao e entedimento de como posso ultrapassar esse problema, 
