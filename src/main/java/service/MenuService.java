package service;

import model.Fight;

import java.util.Scanner;


public class MenuService implements MenuServiceOption {


    public void startMenuService() throws Exception {
        MessageService messageService = new MessageService();
        messageService.showStartMessage();
        tryStart();

    }

    @Override
    public void startGame(int command) {
        if (command == 2) {
            Fight fight = new Fight();
//          fight.fight();
        }
    }

    @Override
    public void endGame(int command) throws Exception {
        if (command == 3) {
            MessageService messageService = new MessageService();
            messageService.showEndMessage();
            exitGame();
        }
    }

    @Override
    public void ruleMenu(int command) throws Exception {
        if (command == 1) {
            MessageService messageService = new MessageService();
            messageService.showRulesMenu();
            exitFromRuleMenu();
        }

    }

    @Override
    public void exitGame() throws Exception {
        System.exit(0);
    }

    public void tryStart() throws Exception {
        MessageService messageService = new MessageService();
        messageService.showCommandsMessage();
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        try {
            ruleMenu(command);
            startGame(command);
            endGame(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exitFromRuleMenu() throws Exception {
        MessageService messageService = new MessageService();
        messageService.showCommandsInRuleMenuMessage();
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        if (command == 1){
            tryStart();
        }
        if (command == 2){
            exitGame();
        }
    }
}


// TODO Интерфесы и создать классы меседж сервис , раскинуть по пакетам , и сделать другой цикл