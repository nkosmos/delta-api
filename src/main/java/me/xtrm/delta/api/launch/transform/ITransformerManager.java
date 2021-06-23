package me.xtrm.delta.api.launch.transform;

@FunctionalInterface
public interface ITransformerManager {

    void registerTransformer(ITransformer transformer) throws UnsupportedOperationException;

}
