package service;

import java.io.IOException;

public interface MenuService {
    void startMenuService() throws Exception;

    void startGame() throws IOException, InterruptedException;

    void endGame() throws Exception;

    void ruleMenu() throws Exception;

    void exitGame() throws Exception;
}
