# 1. Create Docker Network
docker network create springcqrses

# 2. Axon Platform
docker run -d --name axon-server \
-p 8024:8024 -p 8124:8124 \
--network springcqrses \
--restart always axoniq/axonserver:latest

Once installed, check if running:
http://localhost:8024/

# 3. MongoDB
docker run -d --name mongo-container \
-p 27017:27017 --network springcqrses \
--restart always \
-v ~/docker/volume/database/mongodb/springcqrses:/data/db \
mongo:latest

# Download Client Tools – Robo 3T:
# https://robomongo.org/download
sudo snap install robo3t-snap

#4. MySQL

Run in Docker:
docker run -it -d --name mysql-container \
-p 3307:3306 --network springcqrses \
-e MYSQL_ROOT_PASSWORD=springcqrsesRootPsw \
--restart always \
-v ~/docker/volume/database/sql/springcqrses:/var/lib/mysql  \
mysql:latest
