package observer.delegate;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Notifier goodNotifier = new GoodNotifier();
        PlayingGameListener playingGameListener = new PlayingGameListener();
        WatchingTVListener watchingTVListener = new WatchingTVListener();
        goodNotifier.addListener(playingGameListener, "stopPlayingGame", new Date());
        goodNotifier.addListener(watchingTVListener, "stopWatchingTV", new Date());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goodNotifier.notifyX();
    }
}