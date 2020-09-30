package it.serpico.fgcr.mud.game.core.actions.speak;

import it.serpico.fgcr.mud.game.core.actions.ActionMessageStack;
import it.serpico.fgcr.mud.game.core.actions.GenericAction;

import java.util.List;

public class SpeakAction extends GenericAction {

    public ActionMessageStack askQuestion(ActionActors actors) {
        return askQuestion(actors.getInitiator(), actors.getReceivers());
    }

    public ActionMessageStack askQuestion(Object initiator, List<Object> receiver) {
        return null;
    }

    public ActionMessageStack askQuestion(ICanTalk initiator, ICanTalk receiver) {
        return initiator.doSpeak(receiver);
    }

    @Override
    public ActionMessageStack executeAction(Object initiator, List<Object> receiver) {
        return null;
    }

}
