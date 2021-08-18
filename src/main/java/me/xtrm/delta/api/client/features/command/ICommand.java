package me.xtrm.delta.api.client.features.command;

import com.mojang.brigadier.context.CommandContextBuilder;

import java.util.function.Consumer;

public interface ICommand {

    void register(CommandContextBuilder<Source> contextBuilder);

    @FunctionalInterface
    interface Source extends Consumer<String> {}

}
