package io.dabrowa.rpn;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

class Lazy<T> implements Supplier<T> {

    private final Supplier<T> initializator;
    private final AtomicReference<T> reference;

    Lazy(Supplier<T> initializator) {
        this.initializator = initializator;
        this.reference = new AtomicReference<>(null);
    }

    @Override
    public T get() {
        if(reference.get() == null) {
            reference.set(initializator.get());
        }
        return reference.get();
    }
}
