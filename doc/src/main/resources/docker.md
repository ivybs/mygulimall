#准备工作
##mysql安装
拉取镜像
docker pull mysql

启动mysql服务
docker run -p 3306:3306 --name mysql \
-v /mydata/mysql/log:/var/log/mysql \
-v /mydata/mysql/data:/var/lib/mysql \
-v /mydata/mysql/conf:/etc/mysql \
-v /home/mysq/mysql-files:/var/lib/mysql-files/ \
-e MYSQL_ROOT_PASSWORD=123456 \
-d mysql:8.0
##redis安装
拉取镜像：
docker pull redis \
配置文件映射：
mkdir -p /mydata/redis/conf \
touch /mydata/redis/conf/redis.conf \
启动redis服务：
docker run -p 6379:6379 --name redis -v /mydata/redis/data:/data -v /mydata/redis/conf/redis.conf:/etc/redis/redis.conf -d redis redis-server /etc/redis/redis.conf 
测试执行：
docker exec -it redis redis-cli     
由于redis中的数据都存储在缓存中，因此每次重启redis会导致缓存数据丢失，在redis配置文件中配置aof开启


##idea
1.配maven
2.安装插件：mybatisx(mapper方法快速定位到xml文件)