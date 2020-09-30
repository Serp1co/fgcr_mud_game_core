package it.serpico.fgcr.mud.game.core.actions.factory;

import it.serpico.fgcr.mud.game.core.actions.ActionMessageStack;
import it.serpico.fgcr.mud.game.core.actions.GenericAction;
import it.serpico.fgcr.mud.game.core.actions.IAction;
import it.serpico.fgcr.mud.game.core.actions.fight.FightAction;
import it.serpico.fgcr.mud.game.core.actions.speak.SpeakAction;
import java.util.List;
import java.util.function.Function;

public class ActionFactory {

    public ActionFactory() {

    }

    public IAction getAction(ActionClazzEnum actionClazzEnum){
        switch (actionClazzEnum) {
            case FIGHT:
                return new FightAction();
            case SPEAK:
                return new SpeakAction();
            default:
                throw new ActionFactoryException("Generic Action is without a functional interface to be implemented");
        }
    }

    public IAction getAction(ActionClazzEnum actionClazzEnum, Function<GenericAction.ActionActors, ActionMessageStack> actionFunction){
        switch (actionClazzEnum) {
            case FIGHT:
                return new FightAction() {
                    @Override
                    public ActionMessageStack executeAction(Object initiator, List<Object> receiver) {
                        return executeAction(new ActionActors(initiator, receiver), actionFunction);
                    }
                };
            case SPEAK:
                return new SpeakAction() {
                    @Override
                    public ActionMessageStack executeAction(Object initiator, List<Object> receiver) {
                        return executeAction(new ActionActors(initiator, receiver), actionFunction);
                    }
                };
            default:
                return new GenericAction() {
                    @Override
                    public ActionMessageStack executeAction(Object initiator, List<Object> receiver) {
                        return executeAction(new ActionActors(initiator, receiver), actionFunction);
                    }
                };
        }
    }

}
