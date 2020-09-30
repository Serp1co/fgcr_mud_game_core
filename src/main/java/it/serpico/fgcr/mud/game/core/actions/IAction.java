package it.serpico.fgcr.mud.game.core.actions;

import java.util.List;

public interface IAction {
    ActionMessageStack executeAction(Object initiator, List<Object> receiver);
}
