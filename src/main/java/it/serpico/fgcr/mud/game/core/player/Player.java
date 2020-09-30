package it.serpico.fgcr.mud.game.core.player;

import it.serpico.fgcr.mud.game.core.actions.ActionMessageStack;
import it.serpico.fgcr.mud.game.core.actions.speak.ICanTalk;
import it.serpico.fgcr.mud.game.core.enums.ActionEnum;
import it.serpico.fgcr.mud.game.core.actions.ActionMessage;
import it.serpico.fgcr.mud.game.core.actions.fight.ICanBeDamaged;
import it.serpico.fgcr.mud.game.core.actions.fight.ICanDamageNotify;
import it.serpico.fgcr.mud.game.core.stats.StatSystem;
import lombok.*;

public class Player implements ICanDamageNotify, ICanBeDamaged, ICanTalk {

    @Getter
    private final String name;
    @Getter
    private final StatSystem statSystem;
    @Getter
    @Setter(AccessLevel.PRIVATE)
    private int health;
    @Setter(AccessLevel.PRIVATE)
    private boolean isAlive;

    public Player(String name, StatSystem statSystem, int health) {
        this.name = name;
        this.statSystem = statSystem;
        this.health = health;
        isAlive = this.isAlive();
    }

    public boolean isAlive() {
        isAlive = getHealth() > 0;
        return isAlive;
    }

    /*
    @Override
    public ActionMessage takeDamage(ICanDamageNotify damage) {
        takeDamage(damage.getDamage());
        return status();
    }

    private void takeDamage(int damage) {
        setHealth(getHealth() - damage);
        if (getHealth() <= 0) {
            die();
        }
    }
*/
    @Override
    public int getDamage() {
        int damage = 0;
        if(statSystem != null)
            damage += statSystem.getMani().getValue() + statSystem.getForzaAlQuattro().getValue();
        return damage + 1;
    }

    private void die() {
        setAlive(false);
    }

    private ActionMessage status() {
        if(isAlive()) return new ActionMessage(ActionEnum.SUCCESS, "Sei vivo con: " + getHealth());
        return new ActionMessage(ActionEnum.FAILURE,"Sei morto.");
    }

    @Override
    public String doAsk(long questionCode) {
        return ""+ questionCode;
    }

    @Override
    public String doAnswer(String question) {
        return question;
    }

    @Override
    public ActionMessageStack doSpeak(ICanTalk speak) {
        return new ActionMessageStack();
    }

    @Override
    public ActionMessage doDamage(ICanBeDamaged taker) {
        return null;
    }

    @Override
    public ActionMessage takeDamage(int damage) {
        return null;
    }
}
