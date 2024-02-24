let xhr = new XMLHttpRequest(); // Создание нового объекта XMLHttpRequest
let jsonStr; // Переменная для хранения JSON строки
let jsonObj; // Переменная для хранения преобразованного в объект JSON

// Функция обратного вызова, которая будет вызвана при изменении состояния запроса
xhr.onreadystatechange = function() {
    if (xhr.readyState == XMLHttpRequest.DONE) { // Проверка, что запрос завершен
        jsonStr = xhr.responseText; // Получение JSON строки из ответа
        jsonObj = JSON.parse(jsonStr); // Преобразование JSON строки в объект
        let table_body = document.getElementById("table_body"); // Получение элемента таблицы
        for (let element of jsonObj) { // Перебор элементов массива JSON объектов
            let str = ""; // Переменная для хранения строки HTML для каждого элемента
            table_body.innerHTML += "<tr>"; // Добавление открывающего тега <tr> в таблицу
            for (value of Object.values(element)) { // Перебор значений каждого объекта
                str += "<td>" + value + "</td>"; // Формирование ячейки таблицы с данными
            }
            table_body.innerHTML += str; // Добавление строки в таблицу
            table_body.innerHTML += "</tr>"; // Добавление закрывающего тега </tr> в таблицу
        }
    }
}

xhr.open("POST", "read", true); // Настройка запроса (POST метод, URL, асинхронный режим)
xhr.setRequestHeader("Content-type", "application/json"); // Установка заголовка Content-type
xhr.send("1"); // Отправка данных на сервер
