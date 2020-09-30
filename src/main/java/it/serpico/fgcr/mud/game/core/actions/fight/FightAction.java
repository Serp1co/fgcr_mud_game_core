package it.serpico.fgcr.mud.game.core.actions.fight;

import it.serpico.fgcr.mud.game.core.actions.*;
import it.serpico.fgcr.mud.game.core.enums.ActionEnum;

import java.util.List;

public class FightAction extends GenericAction {

    private ActionMessageStack doDamageAction(ActionActors actors) {
        return doDamageAction(actors.getInitiator(), actors.getReceivers());
    }

    private ActionMessageStack doDamageAction(Object initiator, List<Object> receivers) {
        ActionMessageStack actionMessageStack = new ActionMessageStack();
        actionMessageStack.setRequest(new ActionMessage(ActionEnum.FIGHT, initiator.toString()));
        receivers.forEach(receiver -> actionMessageStack.addResponse(doDamageAction(initiator,receiver)));
        return actionMessageStack;
    }

    private ActionMessage doDamageAction(Object initiator, Object receiver) {
        if(receiver instanceof ICanBeDamaged) return ((ICanBeDamaged)receiver).takeDamage(initiator instanceof ICanDamage ? ((ICanDamage)initiator).getDamage() : 0);
        return buildIndestructibleResult();
    }

    private static ActionMessage buildIndestructibleResult() {
        return new ActionMessage(ActionEnum.FAILURE, "L'oggetto non puo' essere danneggiato!");
    }

    @Override
    public ActionMessageStack executeAction(Object initiator, List<Object> receiver) {
        return executeAction(new ActionActors(initiator, receiver), this::doDamageAction);
    }

}
