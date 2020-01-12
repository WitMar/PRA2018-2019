### NODE

Aplikacja wymaga zainstalowania node'a na komputerze:
https://nodejs.org/en/

### ZESTAW MODUŁÓW I NARZĘDZI

Następnie z poziomu terminala należy wywołać następujące polecenia:

1. npm install -g @angular/cli, // instaluje cli angulara, narzędzie ulatwiające pracę z angularem
2. npm install -g json-server // instaluje crudowy serwer opierający się o plik \*.json
3. npm install // (z poziomu root aplikacji) instaluje niezbędne moduły do uruchomienia aplikacji

### START APLIKACJI

1. Uruchomienie serwera -> polecenie:
   json-server --watch db.json
2. Uruchomienia aplikacji -> polecenie:
   ng serve

Aplikacja dostępna będzie pod localhost:4200, server pod localhost:3000
