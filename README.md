# Employed Service

**First, start the Cassandra database and Datastax:**
```
$ docker-compose up
```

**Second, after the database and datastax has started, start the service:**
```
$ ./gradlew bootRun
```
`NOTE`: For running the service, Java is required. It's recommended to use JDK 8 which can be download [here](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

**Third, populate some dummy data into the database by running this command in this root directory:**

***This command will copy the `cql` file into the docker container and execute an INSERT on the database***
```
$ docker cp data.cql employed-io-service_dse_1:/ && docker exec -t employed-io-service_dse_1 cqlsh -f data.cql
```