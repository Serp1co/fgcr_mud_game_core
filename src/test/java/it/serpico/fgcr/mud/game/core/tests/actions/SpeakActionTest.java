package it.serpico.fgcr.mud.game.core.tests.actions;

import it.serpico.fgcr.mud.game.core.actions.ActionMessageStack;
import it.serpico.fgcr.mud.game.core.actions.IAction;
import it.serpico.fgcr.mud.game.core.actions.factory.ActionClazzEnum;
import it.serpico.fgcr.mud.game.core.actions.factory.ActionFactory;
import it.serpico.fgcr.mud.game.core.actions.speak.ICanTalk;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SpeakActionTest {

    Logger logger = Logger.getLogger(SpeakActionTest.class.getName());

    ActionFactory actionFactory;

    static class ActionSpeakImplementer implements ICanTalk {

        @Override
        public String doAsk(long questionCode) {
            return "I can ask";
        }

        @Override
        public String doAnswer(String question) {
            return "I can answer";
        }

        @Override
        public ActionMessageStack doSpeak(ICanTalk speak) {
            return null;
        }
    }

    @BeforeAll
    void init() {
        actionFactory = new ActionFactory();
    }

    @Test
    void testAction1() {
        IAction action = actionFactory.getAction(ActionClazzEnum.valueOf("SPEAK"));
        logger.log(Level.INFO, action.executeAction(new ActionSpeakImplementer(), new ArrayList<>()).toString());
    }
}
