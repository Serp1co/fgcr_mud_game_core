package it.serpico.fgcr.mud.game.core;


import it.serpico.fgcr.mud.game.core.enums.GameStatus;

import java.util.logging.Logger;

public abstract class GameLoop {

    protected final static Logger log = Logger.getLogger(GameLoop.class.getName());

    //volatile object gets read from main memory everytime: http://tutorials.jenkov.com/java-concurrency/volatile.html
    protected volatile GameStatus status;

    protected GameController gameController;

    private final String uId;

    public GameLoop(String uId) {
        this.uId = uId;
        this.status = GameStatus.STOPPED;
        this.gameController = new GameController();
    }

    protected abstract void processGameLoop();

    public void run() {
        this.status = GameStatus.RUNNING;
        //Create a thread to run our game on
        Thread gameThread = new Thread(this::processGameLoop);
        gameThread.start();
    }

    public void stop() {
        this.status = GameStatus.STOPPED;
    }

    public void pause() {
        this.status = GameStatus.PAUSED;
    }

    public void unpause() {
        this.status = GameStatus.RUNNING;
    }

    public boolean isGameRunning() {
        return this.status == GameStatus.RUNNING;
    }

    public String getuId() {
        return uId;
    }
}