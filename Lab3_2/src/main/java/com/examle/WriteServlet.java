package com.examle;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Перенаправление запроса на файл write.jsp
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher("/jsp/write.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Путь к файлу JSON
		String pathStr = "E:\\pomoika\\OOP\\2_sem_my\\Lab3_2\\src\\main\\webapp\\game.json";
		Path path = Paths.get(pathStr);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ArrayList<Game> gameList = new ArrayList<>();
		String jsonArrayString = "";

		// Создание файла, если он не существует, и чтение содержимого
		if (!Files.exists(path)) {
			Files.createFile(path);
		}
		jsonArrayString = Files.readString(path);

		// Если файл не пустой, преобразование JSON строки в ArrayList<Game>
		if (!jsonArrayString.equals("")) {
			Type listOfGame = new TypeToken<ArrayList<Game>>() {}.getType();
			gameList = gson.fromJson(jsonArrayString, listOfGame);
		}

		// Чтение данных о новой игре из запроса
		String data = request.getReader().readLine();
		Game game = gson.fromJson(data, Game.class);
		gameList.add(game);

		// Запись списка игр обратно в файл
		FileHandler.writeGameToFile(game);
	}
}
