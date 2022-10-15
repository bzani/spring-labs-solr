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
mkdir data
sudo chown 8983:8983 data
docker run --rm -d -v "$PWD/data:/var/solr" -p 8983:8983 --name solr-server solr solr-precreate products
```

## Loading custom data

```sh
docker run --rm -v "$PWD/mydata:/mydata" solr post -c products /mydata/products.csv
```

## Source

https://solr.apache.org/guide/solr/latest/getting-started/documents-fields-schema-design.html

https://solr.apache.org/guide/solr/latest/deployment-guide/solr-in-docker.html

https://stackoverflow.com/a/64006395/10194598 (troubleshooting)