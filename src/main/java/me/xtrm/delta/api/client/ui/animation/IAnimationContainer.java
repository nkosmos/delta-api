package me.xtrm.delta.api.client.ui.animation;

public interface IAnimationContainer {

    int getFrame();

    int getTotalFrames();

    int getDelayFrame();

    int getTotalDelayFrames();

    default float getPercentage() {
        return (float) getFrame() / (float) getTotalFrames();
    }

    float getValue();

    default float getValue(boolean inverted) {
        if (inverted) {
            return 1F - getValue();
        }
        return getValue();
    }

    void update();

    default boolean isFinished() {
        return getFrame() == getTotalFrames();
    }

}
