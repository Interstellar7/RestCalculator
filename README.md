# RestCalculator

web service for learning and testing REST remote procedures

Сервис для изучения и тестирования удалённых процедур через REST.
Данный микросервис выполняет роль простого калькулятора.

Есть 2 рабочих URI:

 <b>/hello</b> с параметром name (можно без параметра). Выполняется через GET-запрос. Это просто функция приветствия по имени. В результате получаем текстовую строку приветствия.
Пример: http://localhost:8080/hello?name=Bill%20Gates <br>

 <b>/calculate</b> - собственно сам калькулятор. Дальнейшее описание касается только /calculate.

##Входные данные 
На вход подаются 3 аргумента: <b>action</b> (действие), <b>value1</b> (число 1) и <b>value2</b> (число 2).<br>
Есть 4 значения аргумента action:<br>
addition - сложение<br>
subtraction - вычитание<br>
multiplication - умножение<br>
division - деление<br>

В данном микросервисе реализовано 2 варианта передачи входных данных: в помощью GET-запроса и с помощью POST-запроса

Пример GET-запроса для умножения 2 * 4:<br>
http://localhost:8080/calculate?action=multiplication&value1=2&value2=4

Пример POST-запроса для умножения 2.6 * 4.56<br>
{<br>
    "action": "multiplication",<br>
    "value1": 2.6,<br>
    "value2": 4.56<br>
}<br>
Важно, чтобы были запятые при перечислении полей и кавычки для строковых типов.
Посылать Post-запрос можно через Postmap или SoapUI.

##Выходные данные
На выходе получаем следующий JSON-объект (пример умножения 2 * 4):<br>
{<br>
    "status": "OK",<br>
    "message": "Action is multiplication",<br>
    "calcResult": 8<br>
}<br>
status - http-статус ответа сервера. Посмотреть числовой код ответа в SoapUI можно на вкладке raw.<br>
message - сообщение пользователю. В случае успешного вычисления - наименование действия, в случае неуспешного - сообщение об ошибке<br>
calcResult - результат вычисления.<br>
Пример ответа с сообщением об ошибке (деление на ноль):<br>
{<br>
    "status": "METHOD_NOT_ALLOWED",<br>
    "message": "Division by zero!",<br>
    "calcResult": 0.0<br>
}<br>

В вышеописанных примерах адрес сервера прописан localhost (локальная машина) с портом 8080. Сменить порт можно, отредактировав файл application.properties в папке resources. Также с помощью свойства numbersAfterComa можно задать количество знаков после запятой для округления результата.

Для удобства тестирования в папке программы есть файл SoapUI-проекта REST-Calculator-soapui-project.xml уже со всеми готовыми методами.  