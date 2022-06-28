package service;

import java.io.IOException;

public interface MenuService {
    void startGame() throws IOException;

    void endGame() throws Exception;

    void ruleMenu() throws Exception;

    void exitGame() throws Exception;
}
