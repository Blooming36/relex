# [![Typing SVG](https://readme-typing-svg.herokuapp.com?color=%FFFFFF&lines=Test+task+for+relex)](https://git.io/typing-svg)

# Стек технологий проекта
## Фреймворки и библиотеки
* Spring Boot 3.0.1: Предоставляет комплексную платформу для создания корпоративных приложений на Java.
* Spring Security: Для аутентификации и авторизации в приложении.
* Spring Web: Для создания веб-приложений с использованием Spring MVC.
* Spring Data JPA: Обеспечивает поддержку репозиториев для JPA.
* Thymeleaf 3.1.2: Современный шаблонизатор на стороне сервера для веб- и автономных сред.
* MapStruct 1.4.2: Инструмент для генерации кода, который значительно упрощает реализацию отображений между типами Java-бинов.
* Lombok 1.18.4: Библиотека для уменьшения шаблонного кода в классах Java.
* JSON Web Token (JWT) 0.11.5: Для безопасной передачи информации между сторонами в виде объекта JSON.
## База данных
* PostgreSQL: Мощная, открытая реляционная система управления базами данных.
## Сборка и управление зависимостями
* Maven: Инструмент сборки для управления зависимостями и построения проекта.
## Прочее

* Java 17: Язык программирования, используемый для разработки.<br>
* Этот проект использует комбинацию индустриальных технологий для создания надежного, безопасного и поддерживаемого веб-приложения.
# Рассмотрим примеры REST-запросов и ответов к ним
#### Аунтификация пользователя
`Post localhost:8080/auth/authenticate `
```
{
    "username": "danila",
    "password": "2002"
}
```
`Ответ `
```
  {
    tocken : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkYW5pbGEiLCJpYXQiOjE3MDk2NjAwMTgsImV4cCI6MTcwOTc0NjQxOH0.kBDRiJr9JAoN1gbysHdG2TdQ6J_PPqHx4cr8_Rn3MXY
  }
```
#### Регистрация пользователя
`Post localhost:8080/auth/addNewUser `
```
{
    "firstName": "666",
    "lastName": "321",
    "patronymic": "321",
    "email": "666@Gmail.com",
    "password": "2002",
    "roles": "ROLE_USER"
}
```
`Ответ `
```
  {
    text : Пользователь добавлен в system
  }
```
#### Блокировка пользователей
`Post localhost:8080/auth/blockUser/? ` <br>
`Ответ `
```
  {
    text :Пользователь с id ? заблокирован
  }
```
#### Добавления нового продукта
`Post localhost:8080/product/addNewProduct ` <br>
```
{
    "name": "Яйки",
    "unitOfMeasurement" : "Шт"
}
```
`Ответ `
```
  {
    text : Товар Яйки2 добавлен !
  }
```
#### Получение всех продуктов
`Get localhost:8080/product/allProduct ` <br>
`Ответ `
```
    {
        "id": 1,
        "name": "Арбуз",
        "unitOfMeasurement": "Кг"
    },
    {
        "id": 2,
        "name": "Ягода",
        "unitOfMeasurement": "Кг"
    }   
```
#### Добовления рейтинга пользователю
`Post localhost:8080/rating/addRatingUser/??rating=? ` <br>
`Ответ `
```
  {
    text : Пользователю c именем ? добавлен рейтинг ?
  }
```
#### Просмотр рейтинга
`Get localhost:8080/rating/checkRating/? ` <br>
`Ответ `
```
  {
    text : Вы сегодня получили оценку  ?
  }  
```
#### Добовления нормы сбора
`Post localhost:8080/collecting/setNormUser/?/??theRateOfCollection=? ` <br>
`Ответ `
```
  {
    text : Вы добавили дневную норму для пользователя ?
  }
```
#### Просмотр сбора продуктов пользователя
`Get localhost:8080/collecting/getAllProductForUser/? ` <br>
`Ответ `
```
     {
        "theRateOfCollection": 50,
        "collecting": 60,
        "date": "2024-03-05",
        "name": "Голубика",
        "unitOfMeasurement": "Кг"
    },
    {
        "theRateOfCollection": 50,
        "collecting": 60,
        "date": "2024-03-05",
        "name": "Яйки",
        "unitOfMeasurement": "Шт"
    } 
```
#### Сбор продуктов
`Post localhost:8080/collecting/collectingProduct/?/??collect=? ` <br>
`Ответ `
```
  {
    text : Вы собрали больше на 20 Шт 
  }
```
#### Просмотр статистики фермы
`Get localhost:8080/statistic/collecting-products?period=&userId= ` <br>
`Ответ `
```
  {
        "firstName": "Dima",
        "lastName": "Mens",
        "patronymic": "Front",
        "theRateOfCollection": 50,
        "collecting": 0,
        "name": "Ягода",
        "unitOfMeasurement": "Кг",
        "date": "2024-03-05"
    },
    {
        "firstName": "danila",
        "lastName": "Aleks",
        "patronymic": "Grom",
        "theRateOfCollection": 50,
        "collecting": 0,
        "name": "Ягода",
        "unitOfMeasurement": "Кг",
        "date": "2024-03-05"
    },
    {
        "firstName": "danila",
        "lastName": "Aleks",
        "patronymic": "Grom",
        "theRateOfCollection": 40,
        "collecting": 70,
        "name": "Арбуз",
        "unitOfMeasurement": "Кг",
        "date": "2024-03-05"
    }
```
