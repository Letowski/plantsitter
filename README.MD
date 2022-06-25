#### install:
```
cd cicd
docker-compose build
docker-compose up
docker-compose down
```

#### params in ./cicd/local.env
```
MCU_HOST=http://192.168.1.77
```

#### info:
```
ui no 80(default) port
api on 1337(default) port
db (postgres) on 5432(default) port, data in ./cicd/pgdata
```