package me.xtrm.delta.api.launch.transform;

@FunctionalInterface
public interface TransformerManager {

    void registerTransformer(ITransformer transformer) throws UnsupportedOperationException;

}
