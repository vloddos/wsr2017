Используется java 10.0.2, language level 10

В начале необходимо открыть mysql workbench, создать бд с названием "wsr2017_db", выполнить скрипты для бд

Порядок создания таблиц:
* clientgroups
* events
* regions
* skills
* users
* results
* volunteers
* wsi

После создания всех таблиц и запуска workbench нужно запустить сервер, предварительно указав логин и пароль в полях
```java
private static final String user;
private static final String password;
```
соответственно

Теперь можно запускать клиент
