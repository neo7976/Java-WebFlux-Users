Тогда задача такая, нужно поднять в докере PostgreSQL, мигрировать в него БД которое будет хранить следующие данные
(они же являются ТЗ для кода):

`Project`
Поля -`id`, `Имя проекта`, `команда проекта`, `описание проекта`, `логотип проекта`, `дата начала` и `окончания проекта`.
API - CRUD + поиск по id, имени, описанию.

`Team` (команда как объект существует отдельно от проекта хотя и может являться его частью)
Поля - `id`, `название`, `описание`, `логотип`, участники `(User)`, дата создания, общее количество.
API - CRUD + поиск команды, по названию, id, описанию.

`User`
Поля - `id`, `имя`, `телефон`.
API - CRUD, поиск по имени, id.

Для демонстрации работы можно подготовить тесты через postman 
или сделать простенький интерфейс через thymeleaf, тут на ваше усмотрение.