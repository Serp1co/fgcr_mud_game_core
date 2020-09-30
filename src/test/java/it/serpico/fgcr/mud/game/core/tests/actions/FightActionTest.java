package it.serpico.fgcr.mud.game.core.tests.actions;

import it.serpico.fgcr.mud.game.core.actions.ActionMessage;
import it.serpico.fgcr.mud.game.core.actions.ActionMessageStack;
import it.serpico.fgcr.mud.game.core.actions.IAction;
import it.serpico.fgcr.mud.game.core.actions.factory.ActionClazzEnum;
import it.serpico.fgcr.mud.game.core.actions.factory.ActionFactory;
import it.serpico.fgcr.mud.game.core.actions.fight.ICanBeDamaged;
import it.serpico.fgcr.mud.game.core.actions.fight.ICanDamageNotify;
import it.serpico.fgcr.mud.game.core.enums.ActionEnum;
import lombok.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FightActionTest {
    Logger logger = Logger.getLogger(FightActionTest.class.getName());
    ActionFactory actionFactory;

    FighterEnabled raffolappo = new FighterEnabled("raffolappo");
    FighterEnabled raffolappo2 = new FighterEnabled("raffolappo2");
    FighterEnabled goffredo = new FighterEnabled("goffredo");
    ImmortalFighterEnabled jotaro = new ImmortalFighterEnabled("jotaro");

    @Data
    @RequiredArgsConstructor
    private static class FighterEnabled implements ICanDamageNotify, ICanBeDamaged {

        @Getter
        private final String name;
        @Getter
        @Setter(AccessLevel.PRIVATE)
        private int health = 100;
        @Setter(AccessLevel.PRIVATE)
        private boolean isAlive;

        @Override
        public ActionMessage takeDamage(int damage) {
            setDamage(damage);
            return status();
        }

        private void setDamage(int damage) {
            setHealth(getHealth() - damage);
            if (getHealth() <= 0) {
                die();
            }
        }

        @Override
        public int getDamage() {
            int damage = 0;
            return damage + 10;
        }

        @Override
        public ActionMessage doDamage(ICanBeDamaged taker) {
            return taker.takeDamage(getDamage());
        }

        public boolean isAlive() {
            isAlive = getHealth() > 0;
            return isAlive;
        }

        private void die() {
            setAlive(false);
        }

        private ActionMessage status() {
            if(isAlive()) return new ActionMessage(ActionEnum.SUCCESS, "Sei vivo con: " + getHealth());
            return new ActionMessage(ActionEnum.FAILURE,"Sei morto.");
        }
    }

    @Data
    @RequiredArgsConstructor
    private static class ImmortalFighterEnabled implements ICanDamageNotify {

        @Getter
        private final String name;
        @Getter
        @Setter(AccessLevel.PRIVATE)
        private int health = 100;
        @Setter(AccessLevel.PRIVATE)
        private boolean isAlive;

        private void takeDamage(int damage) {
            setHealth(getHealth() - damage);
            if (getHealth() <= 0) {
                die();
            }
        }

        @Override
        public int getDamage() {
            int damage = 0;
            return damage + 10;
        }

        @Override
        public ActionMessage doDamage(ICanBeDamaged taker) {
            return taker.takeDamage(getDamage());
        }

        public boolean isAlive() {
            isAlive = getHealth() > 0;
            return isAlive;
        }

        private void die() {
            setAlive(false);
        }

        private ActionMessage status() {
            if(isAlive()) return new ActionMessage(ActionEnum.SUCCESS, "Sei vivo con: " + getHealth());
            return new ActionMessage(ActionEnum.FAILURE,"Sei morto.");
        }
    }

    @BeforeAll
    void init() {
        actionFactory = new ActionFactory();
    }

    @Test
    void testFightAction1() {
        IAction fightAction = actionFactory.getAction(ActionClazzEnum.FIGHT);
        List<Object> fighterEnabledList = new ArrayList<>();
        fighterEnabledList.add(raffolappo);
        fighterEnabledList.add(raffolappo2);
        fighterEnabledList.add(jotaro);
        ActionMessageStack actionMessageStack = fightAction.executeAction(goffredo, fighterEnabledList);
        logger.log(Level.INFO, actionMessageStack.toString());
        logger.log(Level.INFO, raffolappo.toString());
        logger.log(Level.INFO, raffolappo2.toString());
        logger.log(Level.INFO, jotaro.toString());
        logger.log(Level.INFO, goffredo.toString());
    }
}
