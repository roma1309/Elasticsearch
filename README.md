Требования
Java 21 и выше
Maven
Docker и Docker Compose
Запуск проекта

Шаг 1: Запуск контейнеров с помощью Docker Compose
Для запуска всех контейнеров, используйте следующую команду:
docker-compose up

Шаг 2: Индексация документов (для поиска с elasticsearch)
необходимо выполнить индексацию всех документов. Для этого перейдите по следующему URL: http://localhost:8080/api/elastic

Доступ к странице поиска
Основная страница с поиском будет доступна по корневому пути: http://localhost:8080/api/products

Дополнительно
Перед началом работы убедитесь, что у вас установлены все необходимые зависимости и что система соответствует требованиям. Для успешного выполнения команды docker-compose up убедитесь, что Docker и Docker Compose корректно установлены и настроены.