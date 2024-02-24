package com.examle;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/read")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Перенаправление запроса на файл read.jsp
		ServletContext sc = getServletContext();
		sc.getRequestDispatcher("/jsp/read.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Путь к файлу JSON
		String pathStr = "E:\\pomoika\\OOP\\2_sem_my\\Lab3_2\\src\\main\\webapp\\game.json";
		Path path = Paths.get(pathStr);

		// Установка типа содержимого ответа на JSON
		response.setContentType("application/json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String datArrayString = "1";

		// Чтение содержимого файла JSON
		if (Files.exists(path)) {
			datArrayString = Files.readString(path);
			System.out.println(datArrayString);
		}
		PrintWriter out = response.getWriter();
		String jsonArrayString = "";

		// Если файл не пустой, преобразование строки JSON в ArrayList<Game> и затем в JSON
		if (!datArrayString.equals("")) {
			ArrayList<Game> games = FileHandler.readGamesFromFile();
			jsonArrayString = gson.toJson(games);
		}
		// Отправка JSON ответа
		out.print(jsonArrayString);
		out.close();
	}
}
