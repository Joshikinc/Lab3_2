<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Чтение</title>
    <link rel="stylesheet" type="text/css" href="css/read.css">
    <script src="js/reader.js"></script>
</head>
<body>
<header>
    <nav>
        <ul>
            <li>
                <form action="write">
                    <button type="submit">Запись</button>
                </form>
            </li>
            <li>
                <form action="read">
                    <button type="submit">Чтение</button>
                </form>
            </li>
        </ul>
    </nav>
</header>
<table>
    <thead>
    <tr>
        <th>Название</th>
        <th>Жанр</th>
        <th>Платформа</th>
        <th>Год релиза</th>
        <th>Цена</th>
    </tr>
    </thead>
    <tbody id="table_body">
    </tbody>
</table>
</body>
</html>
