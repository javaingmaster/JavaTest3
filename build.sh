mvn clean install

docker build . -f ./docker/mysql/Dockerfile -t mysql:v1
docker build . -f ./docker/java/Dockerfile -t java:v1

