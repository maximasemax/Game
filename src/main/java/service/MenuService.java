package service;

import java.io.IOException;

public interface MenuService {
    void startGame(int command) throws IOException;

    void endGame(int command) throws Exception;

    void ruleMenu(int command) throws Exception;

    void exitGame() throws  Exception;
}
