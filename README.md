# Spring Boot Redis Example

spring data redis example project

# Docker for Redis

```
-bash$ docker run -d -p 6379:6379 d11wtq/redis

-bash$ nc -z localhost 6379
Connection to localhost port 6379 [tcp] succeeded!
```

### properties

* application.yml

```
redis:
    hostname: 192.168.99.100(docker is configured to use the default machine with IP)
    port: 6379(default)
```

### Stack

    JDK8
    SpringBoot
    SpringDataRedis
    Jedis
    Mock