# parking-control-api
 
> 🚧 README EM CONTRUÇÃO🚧

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

|Método|Endpoint|Descrição|Exemplo|

# Testando endpoints da API

Para testar os métodos, eu utilizei a extensão [Thunder Client](https://marketplace.visualstudio.com/items?itemName=rangav.vscode-thunder-client) para VSCode como substituir o uso do Postman ou outros aplicativos.

## POST - Cadastrar nova vaga

Realiza o cadastro de uma nova vaga.
```
http://localhost:8080/parking-spot
```
### Request

<table>
<tr>
<td> Campo </td> <td> Conteúdo </td>
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

http://localhost:8080/parking-spot

### Response 

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

## GET - Listar uma vaga

http://localhost:8080/parking-spot/{id}

http://localhost:8080/parking-spot/66eb77dd-21a5-4d4f-ad19-546254d5b336

### Response

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

## DELETE - Deleta uma vaga por id

http://localhost:8080/parking-spot/{id}

http://localhost:8080/parking-spot/66eb77dd-21a5-4d4f-ad19-546254d5b336

### Response

```
Parking Spot deleted successfully.
```

## PUT - Atualizar dados de uma vaga

http://localhost:8080/parking-spot/{id}

http://localhost:8080/parking-spot/aad8bc8c-6a32-4d78-a8aa-541211124d42

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
### Response

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

# Fontes

- [MichelliBrito
/
parking-control-api](https://github.com/MichelliBrito/parking-control-api)