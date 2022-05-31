package service.impl;

import model.Fight;
import model.impl.Item;
import model.impl.Person;
import service.MenuService;
import service.MessageServiceOption;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class MenuServiceImpl implements MenuService {

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
            Person personUser = personService.chosePerson();
            ItemServiceImpl itemServiceImpl = new ItemServiceImpl();
            List<Item> itemsUser = new ArrayList<>(itemServiceImpl.choseItem());
            Person personBot = personService.chosePersonBot();
            System.out.println(personBot.getName() + "\n");
            List<Item> itemBot = itemServiceImpl.choseItemBot();
            for (Item item : itemBot) {
                System.out.println(item.getName());
            }
            Fight fight = new Fight();
            while (personUser.getHp() > 0 && personBot.getHp() > 0) {
                fight.fight(personUser, personBot, itemChoseUser(itemsUser), itemChoseBot(itemBot));
                System.out.println(personUser.getHp() + "hp user\n");
                System.out.println(personBot.getHp() + "hp bot\n");
            }
            if (personUser.getHp() > 0) {
                System.out.println("You win!!!!!");
            } else {
                System.out.println("You lose((((");
            }
            exitGame();
        }
        //FIXME Поправить хп не должно быть отрицательным
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
            System.out.println(e.getMessage());
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

    private Item itemChoseUser(List<Item> items) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("chose item at round! from:\n");
        int count = 0;
        for (Item item : items) {
            count += 1;
            stringBuilder.append(count + ". Name: " + item.getName());
            stringBuilder.append("\n");
            stringBuilder.append("Attack skill: " + item.getDamageSkill());
            stringBuilder.append("\n");
            stringBuilder.append("Defence skill: " + item.getDefenceSkill());
            stringBuilder.append("\n");
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
        scanner.nextInt();
        return items.get(count - 1);
    }

    private Item itemChoseBot(List<Item> items) {
        System.out.println("bot chose!\n");
        Random random = new Random();
        Item item = items.get(random.nextInt(items.size()));
        System.out.println(item);
        return item;
    }
}
