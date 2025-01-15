
# Restaurant Management API

Este proyecto es una API de gestión de Reservas desarrollada con Java, Spring Boot, MySQL y Docker. La API permite gestionar reservas y agendas.

# Características Modelo

Agenda: Gestiona la agenda/calendario que consisten en dia, horarios disponible y disponibilidad. 

Reservation: Reservas de las personas asociadas a una agenda, horario disponible y cantidad de persona en al reserva.




## Instalación del Proyecto

Descargar el proyecto, el proycto se debe llamar

```bash
  restaurant-test
```

Si al descargarlo directamente por github web el proyecto le aparece con otro nombre, debe modificar la carpeta de descarga de la siguiente manera

```bash
  restaurant-test-master --> restaurant-test
```


Ubicarse en la raiz del proyecto y ejecutar el siguiente comando

```bash
  mvn clean package
```

Levantar el contenedor de docker

```bash
  docker-compose up -d
```

Sobre la raiz del proyecto ejecutar el siguiente comando para arrancar el proyecto.

```bash
  mvn spring-boot:run 
```
    
## API's

#### Consultar todas las agendas

Endpoint
```bash
  GET http://localhost:8000/api/agenda

```

#### Consultar agenda por dia

Endpoint
```bash
  GET http://localhost:8000/api/agenda/available?day=Monday

```


#### Realizar una reservacion 

```bash
  POST http://localhost:8000/api/reservations
```
Body
```bash
{
    "firstName": "Juan",
    "lastName": "Pérez",
    "numPeople": 4,
    "day": "Monday",
    "startTime": "19:00:00",
    "endTime": "20:00:00",
    "idAgenda": 1
}

```
Respuesta
```bash
{
    "id": 1,
    "firstName": "Juan",
    "lastName": "Pérez",
    "numPeople": 4,
    "day": "Monday",
    "startTime": "19:00:00",
    "endTime": "20:00:00"
}
```

#### Consultar agenda por dia

```bash
  GET http://localhost:8000/api/reservations/by-date?day=Monday
```

Respuesta
```bash
    {
        "id": 1,
        "firstName": "Juan",
        "lastName": "Pérez",
        "numPeople": 4,
        "day": "Monday",
        "startTime": "19:00:00",
        "endTime": "20:00:00"
    }
```


#### Eliminar una reserva

```bash
  DELETE http://localhost:8000/api/reservations/{reservationId}
```

Respuesta
```bash
204
```

#### Modificar una reserva
```bash
  PUT http://localhost:8000/api/reservations/{reservationId}
```

Body
```bash
{
    "firstName": "Juan",
    "lastName": "Pérez",
    "numPeople": 4,
    "day": "Monday",
    "startTime": "19:00:00",
    "endTime": "20:00:00",
    "idAgenda": 1
}

```
Respuesta
```bash
{
    "id": 1,
    "firstName": "Juan",
    "lastName": "Pérez",
    "numPeople": 4,
    "day": "Monday",
    "startTime": "19:00:00",
    "endTime": "20:00:00"
}
```



