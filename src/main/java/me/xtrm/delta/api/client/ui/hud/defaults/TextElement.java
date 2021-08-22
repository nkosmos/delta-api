package me.xtrm.delta.api.client.ui.hud.defaults;

import fr.nkosmos.starboard.Group;
import fr.nkosmos.starboard.Setting;
import fr.nkosmos.starboard.api.ISetting;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.xtrm.delta.api.client.ui.color.ColorMode;
import me.xtrm.delta.api.client.ui.context.RenderContext;
import me.xtrm.delta.api.client.ui.font.EnumFont;
import me.xtrm.delta.api.client.ui.font.IFontRenderer;
import me.xtrm.delta.api.client.ui.hud.IMovableElement;
import meteordevelopment.starscript.Script;
import meteordevelopment.starscript.compiler.Compiler;
import meteordevelopment.starscript.compiler.Parser;

import java.awt.*;

@Getter
@NoArgsConstructor
public class TextElement implements IMovableElement {

    private final Group rootGroup = new Group("root", null, true);

    public final Setting<String> text = new Setting<>(rootGroup, "Text", "Default text").callback(this::updateText);
    public final Setting<EnumFont> font = new Setting<>(rootGroup, "Font", EnumFont.NORMAL).values(EnumFont.values()).callback(this::updateFontRenderer);
    public final Setting<Boolean> dropShadow = new Setting<>(rootGroup, "Shadow", true);
    public final Setting<Boolean> background = new Setting<>(rootGroup, "Background", true);
    public final Setting<ColorMode> textColorMode = new Setting<>(rootGroup, "Text Color Mode", ColorMode.CUSTOM).values(ColorMode.values());
    public final Setting<Color> textCustomColor = new Setting<>(rootGroup, "Text Color", new Color(255, 255, 255, 255)).onlyIf(textColorMode.get()::isCustomizable);

    @Getter(AccessLevel.PRIVATE)
    private Script script;

    @Getter(AccessLevel.PRIVATE)
    private IFontRenderer cachedFontRenderer;

    @Setter
    private int x;
    @Setter
    private int y;

    public TextElement(String text, int x, int y, EnumFont font, boolean shadow, boolean background, ColorMode colorMode, Color color) {
        this.text.set(text);
        this.font.set(font);
        this.dropShadow.set(shadow);
        this.background.set(background);
        this.textColorMode.set(colorMode);
        this.textCustomColor.set(color);

        this.x = x;
        this.y = y;
    }

    @Override
    public String getName() {
        return "Text" + (text.get() != null ? ": " + text : "");
    }

    @Override
    public void render(RenderContext context) {
        String output = text.get();
        if (script != null) {
            output = context.getRenderStarscript().run(script);
        }

        if(this.cachedFontRenderer == null) {
            EnumFont font = this.font.get();
            this.cachedFontRenderer = context.getFontProvider().getFontRenderer(font);
        }

        this.cachedFontRenderer.drawString(output, x, y, context.getColorProvider().getColor(textColorMode.get(), textCustomColor.get()).getRGB(), dropShadow.get());
    }

    private void updateText(ISetting<String> text, String newValue) {
        Parser.Result result = Parser.parse(newValue);

        if (!result.hasErrors()) {
            this.script = Compiler.compile(result);
        } else {
            result.errors.forEach(System.out::println);
            this.script = null;
        }
    }

    private void updateFontRenderer(ISetting<EnumFont> font, EnumFont oldValue) {
        this.cachedFontRenderer = null;
    }

    @Override
    public int getWidth() {
        return this.cachedFontRenderer == null ? 0 : this.cachedFontRenderer.getStringWidth(text.get());
    }

    @Override
    public int getHeight() {
        return this.cachedFontRenderer == null ? 0 : this.cachedFontRenderer.getFontHeight();
    }

}