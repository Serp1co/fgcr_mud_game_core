package it.serpico.fgcr.mud.game.core.actions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;

@Data
public abstract class GenericAction implements IAction {

    public static Logger log = Logger.getLogger(GenericAction.class.getName());

    public abstract ActionMessageStack executeAction(Object initiator, List<Object> receiver);

    public final ActionMessageStack executeAction(ActionActors actors, Function<ActionActors, ActionMessageStack> actionFunction) {
        return actionFunction.apply(actors);
    }

    @Data
    @AllArgsConstructor
    public static class ActionActors {
        Object initiator;
        List<Object> receivers;
    }

}
