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
|              | `"/swagger-ui/index.html"`     | swagger UI                |

The authentication is commented out in pom.xml and AppSecurityConfig.java, because
Im confused after a time, while Im trying to passed a test with active authentication.
So I commanted out instead. This way the tests are passed. The other way(uncomment authentication)
are the authentication working, everything authenticated, except actuator/health, this one
I leave public access.  
Im sorry for this, but unfortunately we dont learn the security on course,
like the versioning neither.  
Im working the security only the quiz-game hobby project, where I need to secure only
the admin page, where user can manage the database.  
I didnt even start the versioning, just read about it, and its not clear to me, what is
the good way:
- URI
- media type
- @Projection
