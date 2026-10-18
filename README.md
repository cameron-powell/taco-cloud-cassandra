## Cassanda Local Dev Setup
- `docker network create cassandra-net`
- `docker run --name taco-cloud-cassandra --network cassandra-net -p 9042:9042 -d cassandra:latest`
- `docker run -it --network cassandra-net --rm cassandra cqlsh taco-cloud-cassandra`
- `create keyspace tacocloud with replication={'class':'SimpleStrategy', 'replication_factor':1} and durable_writes=true;`

## Cassandra Local Dev Teardown
- `docker stop taco-cloud-cassandra`
- `docker rm -v taco-cloud-cassandra`
- `docker network rm cassandra-net`
- `docker image rm cassandra:latest`