import service.MenuService;
import service.Requests;
import service.impl.MenuServiceImpl;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        MenuService menuService = new MenuServiceImpl();
        menuService.startMenuService();
    }

}
