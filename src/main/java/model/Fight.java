package model;


import model.impl.Item;
import model.impl.Person;

public class Fight {


    public void fight(Person person, Person personBot, Item item, Item itemBot) {
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
