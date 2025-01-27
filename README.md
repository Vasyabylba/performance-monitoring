<h1 align="center">Performance Monitoring</h1>

Spring Boot Starter для мониторинга времени выполнения методов.

## Описание

Spring Boot Starter `performance-monitoring-starter` предоставляет аннотацию `@PerformanceMonitoring` для мониторинга
времени выполнения методов. Стартер логирует время выполнения методов, если их время выполнение превышает заданный
порог времени.

## Инструкция по установке

1. Клонировать Git репозиторий:

    ```bash
    git clone https://github.com/Vasyabylba/performance-monitoring.git
    ```

2. Перейти в корневую директорию проекта и собрать проект:

    ```bash
    cd performance-monitoring 
   
   ./gradlew clean -x test build
    ```

3. Для размещения стартера в локальном Maven-репозитории выполнить:

    ```bash
    ./gradlew publishToMavenLocal
    ```

   Стартер будет опубликован в локальном Maven-репозитории (~/.m2/repository).

## Использование

1. Для подключения стартера в `build.gradle` проекта добавить:

   ```
   repositories {
       mavenLocal() 
   }
   
   dependencies {
       implementation 'ru.clevertec:performance-monitoring-starter:1.0.0'
   }
   ```

2. Для логирования метода использовать аннотация `@PerformanceMonitoring`

## Настройка стартера

Управление стартером осуществляется через свойства приложения `application.yml`:

```yaml
performance:
  monitoring:
    enabled: true  # Включить логирования Performance Monitoring
    min-time: 500  # Минимальное время выполнения метода для логирования (в миллисекундах)
```
