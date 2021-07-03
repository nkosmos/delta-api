package me.xtrm.delta.api.client.module;

import fr.shyrogan.post.receiver.annotation.Subscribe;

@Module(
        name = "TeStModule",
        description = "Correctly adequately named description",
        category = "SomeCategory"
)
public class TestModule {

    @Module.Handle
    private static ModuleHandle instance;

    @Subscribe
    public void onCumEvent(Object imagineCestUnEventJaiPasLesImports) {
        System.out.println("do stuff");

        instance.toggle();
    }

    @Module.OnEnable
    public void onEnable() {
        System.out.println("Enabled!");
    }

}
