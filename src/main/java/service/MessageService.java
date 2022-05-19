package service;

import java.nio.file.Files;
import java.nio.file.Paths;


public class MessageService implements MessageServiceOption {



    private String getMessage(String fileName) throws Exception {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public void showRulesMenu() throws Exception {
        System.out.println(getMessage("C:\\Users\\Maximase\\IdeaProjects\\Game\\src\\main\\resources\\Rules.txt"));
    }

    public void showStartMessage() throws Exception {
        System.out.println(getMessage("C:\\Users\\Maximase\\IdeaProjects\\Game\\src\\main\\resources\\startMessage.txt"));
    }

    public void showEndMessage() throws Exception {
        System.out.println(getMessage("C:\\Users\\Maximase\\IdeaProjects\\Game\\src\\main\\resources\\endMessage.txt"));
    }

    public void showCommandsMessage() throws Exception {
        System.out.println(getMessage("C:\\Users\\Maximase\\IdeaProjects\\Game\\src\\main\\resources\\Commands.txt"));
    }
    public void showCommandsInRuleMenuMessage() throws Exception {
        System.out.println(getMessage("C:\\Users\\Maximase\\IdeaProjects\\Game\\src\\main\\resources\\CommandsInRule.txt"));
    }
}

