package com.literalura.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.literalura.model.Author;
import com.literalura.model.Book;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ApiService {

    private static final String GUTENDEX_API_BASE_URL = "https://gutendex.com/books/";

    public Book fetchBook(String query) throws Exception {
        String apiUrl = GUTENDEX_API_BASE_URL + "?search=" + query.replace(" ", "+");

        // Connect to API
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        // Check if the response is successful
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Failed to fetch book: HTTP error code " + responseCode);
        }

        // Read response
        Scanner scanner = new Scanner(url.openStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        // Parse JSON response
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.toString());
        JsonNode bookNode = root.path("results").get(0);

        // Extract book and author information
        String title = bookNode.path("title").asText();
        JsonNode authorNode = bookNode.path("authors").get(0);

        String authorName = authorNode.path("name").asText();
        int birthYear = authorNode.path("birth_year").asInt();
        int deathYear = authorNode.path("death_year").asInt();

        // Create and return Book and Author objects
        Author author = new Author(authorName, birthYear, deathYear);
        return new Book(title, author);
    }

    // Método searchBooks que retorna uma lista de livros
    public List<Book> searchBooks(String query) throws Exception {
        String apiUrl = GUTENDEX_API_BASE_URL + "?search=" + query.replace(" ", "+");

        // Conectar à API
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        // Verificar se a resposta foi bem-sucedida
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Failed to fetch books: HTTP error code " + responseCode);
        }

        // Ler a resposta
        Scanner scanner = new Scanner(url.openStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        // Parse JSON da resposta
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.toString());
        JsonNode booksNode = root.path("results");

        List<Book> books = new ArrayList<>();
        for (JsonNode bookNode : booksNode) {
            String title = bookNode.path("title").asText();
            JsonNode authorNode = bookNode.path("authors").get(0);

            String authorName = authorNode.path("name").asText();
            int birthYear = authorNode.path("birth_year").asInt();
            int deathYear = authorNode.path("death_year").asInt();

            // Criar e adicionar o livro à lista
            Author author = new Author(authorName, birthYear, deathYear);
            books.add(new Book(title, author));
        }

        return books;
    }
}
