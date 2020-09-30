package it.serpico.fgcr.mud.game.core.actions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ActionMessageStack {

    @Getter
    private ActionMessage request;
    @Getter
    private final List<ActionMessage> responseList = new ArrayList<>();

    public void setRequest(ActionMessage request) {
        this.request = request;
    }

    public void addResponse(ActionMessage response) {
        responseList.add(response);
    }

}
