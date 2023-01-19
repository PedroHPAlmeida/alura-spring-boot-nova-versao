## Comando para executar o banco da aplicação com Docker

```
docker run \
    -e MYSQL_ROOT_PASSWORD=root \
	-e MYSQL_USER=app \
	-e MYSQL_PASSWORD=app \
	-e MYSQL_DATABASE=vollmed_api \
	-p 3306:3306 \
	-d mysql:8.0.31
```