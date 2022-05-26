package service;

import model.Item;
import model.Person;

import java.io.IOException;
import java.util.Scanner;


public class MenuService implements MenuServiceOption {

    private final MessageServiceOption messageService = new MessageService();
    private final Scanner scanner = new Scanner(System.in);

    public void startMenuService() throws Exception {
        messageService.showStartMessage();
        start();

    }

    @Override
    public void startGame(int command) throws IOException {
        if (command == 2) {
            PersonService personService = new PersonService();
            personService.chosePerson();
            ItemService itemService = new ItemService();
            itemService.choseItem();
//            Fight fight = new Fight();
            Person personBot = personService.chosePersonBot();
            System.out.println(personBot);
            Item itemBot = itemService.choseItemBot();
            System.out.println(itemBot);

//          fight.fight();
        }
    }

    @Override
    public void endGame(int command) throws Exception {
        if (command == 3) {
            messageService.showEndMessage();
            exitGame();
        }
    }

    @Override
    public void ruleMenu(int command) throws Exception {
        if (command == 1) {
            messageService.showRulesMenu();
            exitFromRuleMenu();
        }

    }

    @Override
    public void exitGame() {
        System.exit(0);
    }

    public void start() throws Exception {
        messageService.showCommandsMessage();
        int command = scanner.nextInt();

        try {
            // Сделат-ь switch
            ruleMenu(command);
            startGame(command);
            endGame(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exitFromRuleMenu() throws Exception {
        messageService.showCommandsInRuleMenuMessage();
        int command = scanner.nextInt();
        if (command == 1) {
            start();
        }
        if (command == 2) {
            exitGame();
        }

    }
}
