package me.xtrm.delta.api.launch.transform;

@FunctionalInterface
public interface ITransformerManager {

    void registerTransformers(ITransformer... transformers) throws UnsupportedOperationException;

}
