package service;

public interface MenuServiceOption {
    void startGame(int command);

    void endGame(int command) throws Exception;

    void ruleMenu(int command) throws Exception;

    void exitGame() throws  Exception;
}
