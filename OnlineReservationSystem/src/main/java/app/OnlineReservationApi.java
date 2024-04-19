package app;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

import controller.UserController;

public class OnlineReservationApi {
    public void apiServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(4040),0);
        UserController userController = new UserController();

        server.createContext("/users", (HttpExchange exchange) -> {
//            String response = userController.getAllUsersAsJson();
//            exchange.getResponseHeaders().set("Content-Type", "application/json");
//            exchange.sendResponseHeaders(200, response.length());
//            exchange.getResponseBody().write(response.getBytes());
//            exchange.close();
        });

        server.start();
        System.out.println("Server started on port 8000");
    }
}
