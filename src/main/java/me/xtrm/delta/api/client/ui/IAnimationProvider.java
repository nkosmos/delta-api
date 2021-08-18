package me.xtrm.delta.api.client.ui;

public interface IAnimationProvider {

    float getValue();

    default float getValue(boolean inverted) {
        if (inverted) {
            return 1F - getValue();
        }
        return getValue();
    }

    int getFrame();

    int getTotalFrames();

    default float getPercentage() {
        return (float) getFrame() / (float) getTotalFrames();
    }

    void update();

}
