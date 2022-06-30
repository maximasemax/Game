package service;


import model.impl.Item;
import model.impl.Person;

import java.io.IOException;
import java.net.MalformedURLException;

public class Fight {


    public void fight(Person person, Person personBot, Item item, Item itemBot) throws IOException, InterruptedException {
        float damageFromUser = 0;
        float damageFromBot = 0;
        float defenceUser = 0;
        float defenceBot = 0;
        float damageToUser = 0;
        float damageToBot = 0;
        damageFromUser = person.getAttackSkill() * item.getDamageSkill();
        damageFromBot = personBot.getAttackSkill() * itemBot.getDamageSkill();
        defenceUser = person.getDefenceSkill() * item.getDefenceSkill();
        defenceBot = personBot.getDefenceSkill() * itemBot.getDefenceSkill();
        if (damageFromUser > defenceBot) {
            damageToBot = damageFromUser - defenceBot;
            personBot.setHp(personBot.getHp() - damageToBot);
        } else {
            damageToBot = 0;
        }
        if (damageFromBot > defenceUser) {
            damageToUser = damageFromBot - defenceUser;
            person.setHp(person.getHp() - damageToUser);
        } else {
            damageToUser = 0;
        }

    }
}
