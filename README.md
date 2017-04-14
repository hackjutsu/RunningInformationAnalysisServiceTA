# Running Information Analysis Service (TA版)

## 下载代码
```
git clone https://github.com/hackjutsu/RunningInformationAnalysisServiceTA.git
cd RunningInformationAnalysisServiceTA
```

## 启动数据库
### 启动 MySQL Docker
```
docker-compose up -d
```
### 登录数据库
登录数据库console
```
mysql --host=127.0.0.1 --port=3306 --user=root --password=root 
```
查看已有数据库。
```
show databases;
```
如果不存在`running_information_analysis_db`，就新建一个
```
create database running_information_analysis_db;
```
退出数据库console
```
\q
```

## 启动 Spring Application

```bash
mvn clean install
```
启动server
```bash
java -jar ./target/running-information-analysis-service-1.0.0.BUILD-SNAPSHOT.jar
```

## License
[MIT@CosmoX](https://github.com/hackjutsu/RunningInformationAnalysisServiceTA/blob/master/LICENSE)