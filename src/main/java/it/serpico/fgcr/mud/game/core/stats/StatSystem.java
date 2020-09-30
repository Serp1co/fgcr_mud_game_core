package it.serpico.fgcr.mud.game.core.stats;

import it.serpico.fgcr.mud.game.core.stats.clazzs.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatSystem {

    private AmorePerIlGioco amorePerIlGioco;
    private ForzaAlQuattro forzaAlQuattro;
    private Riflessi riflessi;
    private Mani mani;
    private Testa testa;

}
