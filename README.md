# Car card game API documentation

### Program
Car card game  
BaseURL: `/api/cards`

### Entities:
* Card


| Http method  | Endpoint                       | Description                         |
| ------------ | ---------------------------    | ----------------------------------- |
| GET          | `"/api/cards"`                 | get all cards                     |
| POST         | `"/api/cards"`                 | create card                   |
| PUT          | `"/api/cards"`                 | update card|
| DELETE       | `"/api/cards/{id}"`                 | delete card by id                      |
| POST         | `"/api/cards/uploadfile/{filename}"`| upload cards from file (create or update)               |
| POST         | `"/api/cards/find"`            | find cards by attribute(s)|
|              | `"/actuator/health"`           | health check                |
