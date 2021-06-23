package me.xtrm.delta.api.launch.transform;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

@FunctionalInterface
public interface ITransformer extends Opcodes {

    void transform(String className, ClassNode classNode);

    default boolean isTarget(String className) {
        return true;
    }

}
