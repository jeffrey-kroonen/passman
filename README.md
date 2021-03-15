# passman
An application to manage passwords.


## Todo
1. Add repository for Directory entity.
2. Refactor Directory model.
3. Refactor DirectoryService.
4. Test via Postman.

# Requests
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
- `id` _example 1_

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
    "first_name": "Alexander ",
    "last_name": "McQueen",
    "email": "a.mcqueen@example.com",
    "password": "super_secret"
}
```
---
## Update user
`PUT` http://localhost:8080/api/v1/user/{id}<br>

### Parameters<br>
- `id` _example 1_

### Headers
```json
Content-Type: "application/json"
```

### Body
```json
{
    "first_name": "Alexander ",
    "last_name": "McQueen",
    "email": "a.mcqueen@example.com"
}
```
---
## Delete user
`DELETE` http://localhost:8080/api/v1/user/{id}<br>

### Parameters<br>
- `id` _example 1_

### Headers
```json
Content-Type: "application/json"
```
---