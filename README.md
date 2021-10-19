# tourist_telegram_bot_for_Resliv

Для запуска вам потребуется: 

*Если на вашем компьютере уже установленны  IntelliJ Idea, MySQL Community Server, MySQLWorkbench, Git 
и проведены необходимые подключения вы можете пропустить пункты: 1 - 7 и 9

1. Скачайте и установите последнюю версию JDK на свой компьютер:
https://adoptopenjdk.net/

2. Скачать и установить последнюю версию среды разработки IntelliJ Idea Community Edition

3. Скачайте и установите систему контроля версий Git на свой компьютер:
https://git-scm.com/

4. Скачайте и установите MySQL Community Server (Вожно запомеить пароль!)

5. Скачайте и установите MySQLWorkbench

6. Подключите к среде разработки IntelliJ Idea установленную на своём компьютере JDK

7. Подключите к среде разработки IntelliJ Idea установленный на своём компьютер Git
 
8. Скачайте на свой локальный компьютер проект из GitHub: 
            1. откройте IntelliJ Idea
            2. нажмите кнопку Get from VCS
            3. в поле Version control: выбирете Git
            4. выберите директорию в которую будет загружен проект
            5. введите URL проекта 
            6. нажмите кнопку Clone

https://www.jetbrains.com/help/idea/manage-projects-hosted-on-github.html#clone-from-GitHub

URL проекта: https://github.com/Alexandr-Kozhekin/tourist_telegram_bot_for_Resliv.git

9. Запустите и создайте новое подключение к базе данных в MySQLWorkbench

10. В MySQLWorkbench войдите в подключенную базу данных и воспользоваться скриптом находящийся в database.V0.2.dbCreationScript (он создаст базу данных с необходимыми таблицами)

11. В application.properties укажите имя (стандартное: root) и пароль (введенный при установке MySQL Community Server) 
для подключения к базе данных (application.properties находится в пакете src.main.resources)

   database.user.name= ____________(root)
   database.user.password= ____________(*********)
      
Введите имя бота и токин:

   bot.username=____________
   bot.token=____________
      
12. В IntelliJ Idea запустите скачаный проект

13. Для управлением и изминенмем данных воспользуйтесь: 
http://localhost:8080/

14. В приложении Telegram нужно добавить бота после чего воспользуйтесь стартовой командой для получения списка добавленых городов

15. После получения списка городов введите название города для получения добавленной информации о нем
