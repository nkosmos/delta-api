package me.xtrm.delta.api.client.ui.context;

import java.util.function.Supplier;

public interface Resolution {
    int getWidth();

    int getHeight();

    static Resolution from(Supplier<Integer> widthSupplier, Supplier<Integer> heightSupplier) {
        return new Resolution() {
            @Override
            public int getWidth() {
                return widthSupplier.get();
            }

            @Override
            public int getHeight() {
                return heightSupplier.get();
            }
        };
    }
}
