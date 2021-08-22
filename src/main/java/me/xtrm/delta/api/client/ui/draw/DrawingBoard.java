package me.xtrm.delta.api.client.ui.draw;

public interface DrawingBoard {

    void translate(double x, double y, double z);

    void scale(double x, double y, double z);

    default void scale(double x, double y) {
        scale(x, y, 1);
    }

    void color(int r, int g, int b, int a);

    default void color(double r, double g, double b, double a) {
        color((int) (255 * r), (int) (255 * g), (int) (255 * b), (int) (255 * a));
    }

    void scissor(double x, double y, double x2, double y2, Runnable scissorRun);

    void rect(double x1, double y1, double x2, double y2, int color);

    void gradientRect(double x, double y, double x2, double y2, int color, int color2);

    void circle(float x, float y, double radius, int color);

    void fullCircle(int x, int y, double radius, int color);
}
