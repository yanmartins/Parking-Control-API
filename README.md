# Parking Control API
 
Exemplo de API REST usando Spring Boot. O código de base pode ser encontrado em [MichelliBrito/parking-control-api](https://github.com/MichelliBrito/parking-control-api) e o vídeo teórico no canal do YouTube da [Michelli Brito](https://www.youtube.com/watch?v=LXRU-Z36GEU).

> 🚧 Novos recursos estão sendo adicionados para fins de estudo.

# Tecnologias

- Java JDK 17
- Maven
- Postman
    > Usei o Thunder Cliente no VSCode
- PgAdmin 4 (Postgres)
- Lombok

# Configurando conexão com banco de dados

A conexão com o banco de dados é feita através do arquivo [application.properties](parking-control/src/main/resources/application.properties).

```properties
spring.datasource.url= jdbc:postgresql://localhost:5432/parking-control-db
spring.datasource.username=postgres
spring.datasource.password=banco123
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```

# Recursos

|Método|Endpoint|Descrição|
|-|-|-|
| POST | `/parking-spot` | Cadastra uma nova vaga. [Exemplo](#post---cadastrar-nova-vaga)|
|GET| `/parking-spot` | Lista todas as vagas cadastradas. [Exemplo](#get---listar-todas-as-vagas)
|GET|`/parking-spot/{id}` | Consulta uma vaga cadastrada. [Exemplo](#get---consultar-uma-vaga)
|DELETE|`/parking-spot/{id}` | Deleta uma vaga cadastrada. [Exemplo](#delete---deletar-uma-vaga)
|PUT|`/parking-spot/{id}` | Altera dados de uma vaga cadastrada. [Exemplo](#put---atualizar-dados-de-uma-vaga)

# Testando endpoints da API

Para testar os métodos, eu utilizei a extensão [Thunder Client](https://marketplace.visualstudio.com/items?itemName=rangav.vscode-thunder-client) para VSCode como substituir o uso do Postman ou outros aplicativos.

## POST - Cadastrar nova vaga

Realiza o cadastro de uma nova vaga.

### Request

<table>
<tr>
<td> Campo </td> <td> Conteúdo </td>
</tr>
<tr>
<td>URL</td>
<td>

```
http://localhost:8080/parking-spot
```
</td>
</tr>
<tr>
<td> Body </td>
<td>
    
```json
{
    "parkingSpotNumber":"110B",
    "licensePlateCar":"MMQ1234",
    "brandCar":"renault",
    "modelCar":"clio",
    "colorCar":"black",
    "responsibleName":"Maria Joaquina",
    "apartment": "206",
    "block":"A"
}
```
</td>
</tr>
</table>

### Response

<table>
<tr>
<td> Status </td> <td> Conteúdo </td>
</tr>
<tr>
<td> 200 </td>
<td>
    
```json
{
  "id": "aad8bc8c-6a32-4d78-a8aa-541211124d42",
  "parkingSpotNumber": "110B",
  "licensePlateCar": "MMQ1234",
  "brandCar": "renault",
  "modelCar": "clio",
  "colorCar": "black",
  "registrationDate": "2022-07-29T15:23:45Z",
  "responsibleName": "Maria Joaquina",
  "apartment": "206",
  "block": "A"
}
```
</td>
</tr>
</table>

## GET - Listar todas as vagas

Realiza a listagem de todas as vagas cadastradas.

### Request

<table>
<tr>
<td> Campo </td> <td> Conteúdo </td>
</tr>
<tr>
<td>URL</td>
<td>

```
http://localhost:8080/parking-spot
```
</td>
</tr>

</table>

### Response 

<table>
<tr>
<td> Status </td> <td> Conteúdo </td>
</tr>
<tr>
<td> 200 </td>
<td>
    
```json
{
  "content": [
    {
      "id": "66eb77dd-21a5-4d4f-ad19-546254d5b336",
      "parkingSpotNumber": "12C",
      "licensePlateCar": "LYA1111",
      "brandCar": "volkswagen",
      "modelCar": "fusca",
      "colorCar": "white",
      "registrationDate": "2022-07-29T15:29:41Z",
      "responsibleName": "Juca João",
      "apartment": "101",
      "block": "B"
    },
    {
      "id": "aad8bc8c-6a32-4d78-a8aa-541211124d42",
      "parkingSpotNumber": "110B",
      "licensePlateCar": "MMQ1234",
      "brandCar": "renault",
      "modelCar": "clio",
      "colorCar": "black",
      "registrationDate": "2022-07-29T15:23:45Z",
      "responsibleName": "Maria Joaquina",
      "apartment": "206",
      "block": "A"
    }
  ],
  "pageable": {
    "sort": {
      "unsorted": false,
      "sorted": true,
      "empty": false
    },
    "pageNumber": 0,
    "pageSize": 10,
    "offset": 0,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 1,
  "totalElements": 2,
  "last": true,
  "numberOfElements": 2,
  "first": true,
  "size": 10,
  "number": 0,
  "sort": {
    "unsorted": false,
    "sorted": true,
    "empty": false
  },
  "empty": false
}
```
</td>
</tr>
</table>

## GET - Consultar uma vaga

Realiza a consulta de dados de uma vaga específica.

### Request

<table>
<tr>
<td> Campo </td> <td> Conteúdo </td>
</tr>
<tr>
<td> URL </td>
<td>
    
```
http://localhost:8080/parking-spot/66eb77dd-21a5-4d4f-ad19-546254d5b336
```
</td>
</tr>
</table>

### Response

<table>
<tr>
<td> Status </td> <td> Conteúdo </td>
</tr>
<tr>
<td> 200 </td>
<td>
    
```json
{
  "id": "66eb77dd-21a5-4d4f-ad19-546254d5b336",
  "parkingSpotNumber": "12C",
  "licensePlateCar": "LYA1111",
  "brandCar": "volkswagen",
  "modelCar": "fusca",
  "colorCar": "white",
  "registrationDate": "2022-07-29T15:29:41Z",
  "responsibleName": "Juca João",
  "apartment": "101",
  "block": "B"
}
```
</td>
</tr>
</table>


## DELETE - Deletar uma vaga

Deleta uma caga específica.

### Request

<table>
<tr>
<td> Campo </td> <td> Conteúdo </td>
</tr>
<tr>
<td> URL </td>
<td>
    
```
http://localhost:8080/parking-spot/66eb77dd-21a5-4d4f-ad19-546254d5b336
```
</td>
</tr>
</table>

### Response



<table>
<tr>
<td> Status </td> <td> Conteúdo </td>
</tr>
<tr>
<td> 200 </td>
<td>
    
```
Parking Spot deleted successfully.
```
</td>
</tr>
</table>

## PUT - Atualizar dados de uma vaga

Atualiza os dados de uma vaga específica.

### Request

<table>
<tr>
<td> Campo </td> <td> Conteúdo </td>
</tr>
<tr>
<td>URL</td>
<td>

```
http://localhost:8080/parking-spot/aad8bc8c-6a32-4d78-a8aa-541211124d42
```
</td>
</tr>
<tr>
<td> Body </td>
<td>
    
```json
{
    "parkingSpotNumber":"111B",
    "licensePlateCar":"MMQ1111",
    "brandCar":"ferrari",
    "modelCar":"f8",
    "colorCar":"red",
    "responsibleName":"Maria Joaquina",
    "apartment": "205",
    "block":"A"
}
```
</td>
</tr>
</table>

### Response

<table>
<tr>
<td> Status </td> <td> Conteúdo </td>
</tr>
<tr>
<td> 200 </td>
<td>
    
```json
{
  "id": "aad8bc8c-6a32-4d78-a8aa-541211124d42",
  "parkingSpotNumber": "111B",
  "licensePlateCar": "MMQ1111",
  "brandCar": "ferrari",
  "modelCar": "f8",
  "colorCar": "red",
  "registrationDate": "2022-07-29T15:23:45Z",
  "responsibleName": "Maria Joaquina",
  "apartment": "205",
  "block": "A"
}
```
</td>
</tr>
</table>