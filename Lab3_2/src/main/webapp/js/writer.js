let Game = {
    name: "",
    genre: "",
    platform: "",
    year: 0,
    price: 0
};

function getData() {
    // Получение данных из формы и сохранение их в объекте Game
    Game.name = document.getElementById("name").value;
    Game.genre = document.getElementById("genre").value;
    Game.platform = document.getElementById("platform").value;
    Game.year = document.getElementById("year").value;
    Game.price = document.getElementById("price").value;

    // Преобразование объекта Game в JSON строку
    let gameJson = JSON.stringify(Game);

    // Создание нового объекта XMLHttpRequest
    let xhr = new XMLHttpRequest();

    // Настройка запроса (POST метод, URL, асинхронный режим)
    xhr.open("POST", "write", true);

    // Установка заголовка Content-Type
    xhr.setRequestHeader('Content-Type', 'application/json');

    // Отправка данных на сервер
    xhr.send(gameJson);
};
