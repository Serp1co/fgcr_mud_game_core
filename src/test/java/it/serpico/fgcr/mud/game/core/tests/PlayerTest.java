package it.serpico.fgcr.mud.game.core.tests;

import it.serpico.fgcr.mud.game.core.player.Player;
import it.serpico.fgcr.mud.game.core.stats.StatSystem;
import it.serpico.fgcr.mud.game.core.stats.clazzs.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlayerTest {

    Player player;
    String name = "Goffredo";
    int startingHealt = 100;
    @BeforeAll
    void init() {
        player = new Player(
                name,
                StatSystem.builder()
                        .amorePerIlGioco(new AmorePerIlGioco())
                        .forzaAlQuattro(new ForzaAlQuattro())
                        .riflessi(new Riflessi())
                        .mani(new Mani())
                        .testa(new Testa())
                        .build(),
                startingHealt
                );
    }

    @Test
    void isPlayerAlive() {
        Assertions.assertEquals(player.isAlive(), true);
    }

}
