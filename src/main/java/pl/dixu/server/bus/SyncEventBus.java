package pl.dixu.server.bus;

import java.util.ArrayList;
import java.util.List;

public class SyncEventBus implements EventBus{
    private List<Subscribable> subscribers;

    public SyncEventBus() {
        subscribers = new ArrayList<>();
    }

    @Override
    public void register(Subscribable subscribable) {
        subscribers.add(subscribable);
    }

    @Override
    public void dispatch(final Event<?> event) {
        subscribers.stream()
                .filter(subscriber -> subscriber.supports().contains(event.getClass()))
                .forEach(subscriber -> subscriber.handle(event));
    }

    @Override
    public List<Subscribable> getSubscribers() {
        return subscribers;
    }
}

