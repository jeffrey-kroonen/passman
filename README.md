# passman
An application to manage passwords.

## Todo
- [x] When showing password-entries on directory, order them by date.
- [x] When showing an individual password-entry, order the pasword-entry-fields by date.
- [x] When showing an individual password-entry, select the correct datatype.

# API Reference
## Get users
`GET` http://localhost:8080/api/v1/user<br>
### Headers<br>
```json
Content-Type: "application/json"
```
---
## Get user by ID
`GET` http://localhost:8080/api/v1/user/{id}<br>

### Parameters<br>
- id _example 1_

### Headers
```json
Content-Type: "application/json"
```
---
## Create user
`POST` http://localhost:8080/api/v1/user/<br>

### Headers
```json
Content-Type: "application/json"
```

### Body
```json
{
    "first_name": "Alexander",
    "last_name": "McQueen",
    "email": "a.mcqueen@example.com",
    "password": "super_secret"
}
```
---
## Update user
`PUT` http://localhost:8080/api/v1/user/{id}<br>

### Parameters<br>
- id _example 1_

### Headers
```json
Content-Type: "application/json"
```

### Body
```json
{
    "first_name": "Alexander",
    "last_name": "McQueen",
    "email": "a.mcqueen@example.com"
}
```
---
## Delete user
`DELETE` http://localhost:8080/api/v1/user/{id}<br>

### Parameters<br>
- id _example 1_

### Headers
```json
Content-Type: "application/json"
```
---
