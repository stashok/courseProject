# MyContactManager
Курсовой проект - MyContactManager


Функциональные возможности мобильного приложения: добавление, удаление, просмотр контактов. Осуществление вызовов, отправка сообщений по сети Интернет и через мобильную связь. Возможность регистрации
и аутентификации пользователей для осуществления работы с интернет-сообщениями. Ограничение на создание снимков экрана и вход по отпечатку пальцев в приложение.


Функциональные возможности веб-приложения: регистрация и аутентификация, возможность просмотра и отправки сообщений. Просмотр статистики по отправленным сообщениям. 

Логин:


![Alt text](screenshots/1.jpg?raw=true "Title")


Создание контакта:


![Alt text](screenshots/2.jpg?raw=true "Title")


Просмотр контакта:


![Alt text](screenshots/3.jpg?raw=true "Title")


Доступные функции для работы с контактом:

![Alt text](screenshots/4.jpg?raw=true "Title")


Чат при отправке сообщений через мобильную связь:


![Alt text](screenshots/5.jpg?raw=true "Title")


Звонок:


![Alt text](screenshots/6.jpg?raw=true "Title")


Вход в режим отправки сообщений через Интернет:


![Alt text](screenshots/7.jpg?raw=true "Title")


Просмотр истории бесед с различными пользователями:


![Alt text](screenshots/8.jpg?raw=true "Title")


Отправка сообщения выбранному контакту:


![Alt text](screenshots/9.jpg?raw=true "Title")


Просмотр истории сообщений:


![Alt text](screenshots/10.jpg?raw=true "Title")


Далее демонстрируется работа с веб-приложением.
Страница логина или регистрации в веб-приложении:


![Alt text](screenshots/11.jpg?raw=true "Title")


Просмотр статистики по сообщениям:


![Alt text](screenshots/12.jpg?raw=true "Title")


Страница отправки сообщений:


![Alt text](screenshots/13.jpg?raw=true "Title")


Вход в приложение по отпечатку пальца:


![Alt text](screenshots/Вход-по-пальцу.gif?raw=true "Title")


Ошибка, в случае неправильного отпечатка пальца:


![Alt text](screenshots/Ошибка-при-входе.gif?raw=true "Title")


Для того, чтобы войти в приложение, в вашей системе должен быть зарегистрирован отпечаток пальца. 


Запрет скриншота реализован следующим образом:


<pre><code>getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);</code></pre>
                
                
Ссылка на репозиторий, в котором хранится код сервера(веб-приложения) - https://github.com/stashok/server         


Для корректной работы сканера отпечатков пальца используется разрешение: USE_BIOMETRIC
                
                
                




