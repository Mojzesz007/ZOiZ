Tutorial
https://milanwittpohl.com/projects/tutorials/Full-Stack-Web-App/dockerizing-our-front-and-backend

## TL;DR
1. skompuluj backend poleceniem `maven package` w celu utworzenia plików .jar
2. w najwyższym folderze projektu uruchom `docker build --file=zoiz-back/backend.dockerfile  -t zoiz-back .` a następnie `docker build --file=frontend/frontend.dockerfile -t
 zoiz-front .`
3. Uruchom `docker-compose -f app-compose.yaml up`
4. Aplikacja uruchomi się w http://localhost:4200/, PgAdmin będzie dostępny pod adresem http://localhost:80 (login i hasło znajdują się w pliku app-compose.yaml, a adres serwera jest nazwą kontenera w którym uruchomiony jest postgres)

# Dockerfile - tworzenie obrazu

Blueprint for creating doker images.
Pozwala na określenie kroków instalacji danego narzędzia w kontenerze.
Każdy plik zaczyna się od ustalenia bazowego kontenera (poleceniem FROM) np z gotowym Linuxem i zainstalowanym node.js.
Na końcu pliku znajduje się polecenie które uruchamia zainstalowane narzędzie: `CMD [ "npm", "start" ]`


### Tworzenie obrazu z dockerfile

`docker build -t my-app:1.0 /path/to/dockerfile`
po tym, dockerimage pokaże się w `docker images`

aby przebudiwać image trzeba:
`docker rm id_container`
`docker rmi image_id`
`docker build -t my-app:1.0 /path/to/dockerfile`

#### Połączenie do shell kontenera

`docker exec -it [id_kontenera] /bin/bash`
albo
`docker exec -it [id_kontenera] /bin/sh`

`docker logs [container_id]` \- aby podejrzeć co się dzieje we włączonym kontenerze

## Frontened dockerfile

Uruchomione z root projektu (zajmuje trochę czasu):
`docker build --file=frontend/frontend.dockerfile -t
 zoiz-front .`
 
 ## Backend dockerfile
 Po dokonaniu zmiany w backendzie, trzeba zbudować projekt poleceniem: 'maven package'
(powoduje to odświerzenie plików .jar w folderze /target)

 `docker build --file=zoiz-back/backend.dockerfile  -t zoiz-back .`


# Automatyzacja kontenerów - docker-compose
Należy mieć zainstalowane narzędzie `docker-compose`

## Docker compose file
Uruchomienie go pozwala na automatycznie pobranie kontenerów dostępnych tylko z docker-hub.
zoiz-front i zoiz-back muszą być już utworzone aby ten plik zadziałał.

 docker-compose sam utworzy docker-network.
 
 plik `app-compose.yaml`:
```yaml
version: "3"
services:
  postgres:
    image: postgres:12
    ports:
      - 5432:5432
    environment:
      - POSTGRES_PASSWORD=postgres
      - POSTGRES_DB=zoiz
  pgadmin:
    image: dpage/pgadmin4
    ports:
      - 80:80
    environment:
      - "PGADMIN_DEFAULT_EMAIL=user@domain.com" # Login i hasło do logowania PgAdmina
      - "PGADMIN_DEFAULT_PASSWORD=SuperSecret"
  zoiz-front:
    image: zoiz-front:latest
    environment:
      PORT: 4200
      PROXY_API: http://zoiz-back:8080/
    ports:
      - 4200:4200
  zoiz-back:
    image: zoiz-back:latest
    environment:
      PORT: 8080
    ports:
      - 8080:8080

```

Aby uruchomić docker-compose:

`docker-compose -f app-compose.yaml up`


Aby zatrzymnać (i usunąć stworzoną  domyślnie docker-network ):

`docker-compose -f app-compose.yaml down`

`docker inspect [container_id] | grep IPAddress` - aby podejrzeć na jakim adresie IP jest uruchomiony kontener (potrzebne do połączenia się z bazą danych), można użyć też 'localhost' albo nazwy kontenera
