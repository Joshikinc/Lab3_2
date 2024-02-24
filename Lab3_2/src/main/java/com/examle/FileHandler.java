package com.examle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileHandler {
	// Путь к файлу данных
	private static String pathStr = "E:\\pomoika\\OOP\\2_sem_my\\Lab3_2\\src\\main\\webapp\\game.dat";
	private static Path path = Paths.get(pathStr);

	// Метод для записи игры в файл
	public static void writeGameToFile(Game game) throws IOException {
		// Формирование строки данных об игре
		String gameString = "";
		gameString += game.getName() + ",";
		gameString += game.getGenre() + ",";
		gameString += game.getPlatform() + ",";
		gameString += game.getYear() + ",";
		gameString += game.getPrice() + "\n";

		// Создание файла, если он не существует
		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		// Добавление данных об игре в файл
		Files.write(path, gameString.getBytes(), StandardOpenOption.APPEND);
	}

	// Метод для чтения списка игр из файла
	public static ArrayList<Game> readGamesFromFile() throws IOException {
		if (Files.exists(path)) {
			BufferedReader reader = new BufferedReader(new FileReader(pathStr));
			String data = reader.readLine();
			ArrayList<Game> games = new ArrayList<>();
			while (data != null) {
				// Разделение строки на параметры игры
				String[] parameters = data.split(",");
				// Создание объекта Game и добавление его в список игр
				Game tempGame = new Game(parameters[0], parameters[1], parameters[2], Float.parseFloat(parameters[3]), Float.parseFloat(parameters[4]));
				games.add(tempGame);
				data = reader.readLine();
			}
			reader.close();
			return games;
		}
		return null;
	}
}
