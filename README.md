# Spring Boot Labs - Apache Solr

Setup and simple usage of Apache Solr as a full-text search engine, regarding Spring Data Solr as dependency.

## Setup and run

### Build application

Build application image

```sh
./mvnw clean package -DskipTests=true
```


### Docker-compose

Build and start services

```sh
docker-compose up -d --build
docker-compose logs -f
```

Stop services

```sh
docker-compose down
```

### Docker (Solr)

In case you want to run Solr separately as docker container, you can follow the instructions below.

Create the directory used as container volume and run Solr container:

```sh
docker volume create solr-data
docker network create solr-network
docker run --rm -d -v solr-data:/var/solr -p 8983:8983 --network solr-network \
	--name solr-server solr solr-precreate products
```

Buidl and run your application directly from maven or docker:

```
docker build -t solr-api .
docker run --rm -d -p 8083:8083 --network solr-network --name solr-api \
	-e SPRING_DATA_SOLR_HOST=http://solr-server:8983/solr solr-api
```

## Loading custom data

```sh
docker run --rm -v "$PWD/mydata:/mydata" --network=solr-network \
	solr post -c products /mydata/products.csv -host solr-server
```

## Source

https://solr.apache.org/guide/solr/latest/getting-started/documents-fields-schema-design.html

https://solr.apache.org/guide/solr/latest/deployment-guide/solr-in-docker.html

https://stackoverflow.com/a/64006395/10194598 (troubleshooting)