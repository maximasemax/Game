package service.impl;

import service.Fight;
import model.impl.Item;
import model.impl.Person;
import service.MenuService;
import service.MessageService;
import service.Requests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class MenuServiceImpl implements MenuService {

    private final MessageService messageService = new MessageServiceImpl();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void startMenuService() throws Exception {
        messageService.showStartMessage();
        start();
    }

    @Override
    public void startGame() throws IOException, InterruptedException {
        PersonServiceImpl personService = new PersonServiceImpl();
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
        Requests requests = new Requests();
        String personName = requests.mix();
        String personBotName = requests.mix();
        while (personUser.getHp() > 0 && personBot.getHp() > 0) {
            fight.fight(personUser, personBot, itemChoseUser(itemsUser), itemChoseBot(itemBot));
            if (personUser.getHp() < 0) {
                System.out.println("0 hp user\n");
            } else {
                System.out.println(personUser.getHp()  +" hp "+ personName+ " \n");
            }
            if (personBot.getHp() < 0) {
                System.out.println("0 hp bot\n");
            } else {
                System.out.println(personBot.getHp()  +" hp "+ personBotName + " \n");
            }
        }
        if (personUser.getHp() > 0) {
            System.out.println("You win!!!!!");
        } else {
            System.out.println("You lose((((");
        }
        exitGame();
    }

    @Override
    public void endGame() throws Exception {
        messageService.showEndMessage();
        exitGame();
    }

    @Override
    public void ruleMenu() throws Exception {
        messageService.showRulesMenu();
        exitFromRuleMenu();
    }

    @Override
    public void exitGame() {
        System.exit(0);
    }


    private void start() throws Exception {
        messageService.showCommandsMessage();
        int command = scanner.nextInt();
        switch (command) {
            case 1:
                ruleMenu();
                break;
            case 2:
                startGame();
                break;
            case 3:
                endGame();
                break;
            default:
                System.out.println("You write wrong number(");
        }
    }

    private void exitFromRuleMenu() throws Exception {
        messageService.showCommandsInRuleMenuMessage();
        int command = scanner.nextInt();
        switch (command) {
            case 1:
                start();
                break;
            case 2:
                exitGame();
                break;
            default:
                System.out.println("You write wrong number(");
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
