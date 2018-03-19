# Employed.io service

**To start up Cassandra and Datastax:**
```
$ docker-compose up
```

**To start the service:**
```
$ ./gradlew bootRun
```

## APIs

### Get all users:
```
[GET] localhost:8080/api/users/
```
### Get user by Id:
```
[GET] localhost:8080/api/users/{id}
```
| Parameter       | Type     | Required?  | Description                                     |
| -------------   |----------|------------|-------------------------------------------------|
| `id`            | string   | required   | The userId of the user you want to retrieve. |

### Create a user:
```
[POST] localhost:8080/api/users/
```
| Parameter       | Type     | Required?  | Description                                     |
| -------------   |----------|------------|-------------------------------------------------|
| `user`          | com.employ.proto.User | required   | The User protocol object of the user you want to create. |

### Generate mock user data (Temporary):
```
[POST] localhost:8080/api/users/mock
```

