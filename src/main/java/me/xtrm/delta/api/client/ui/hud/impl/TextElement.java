package me.xtrm.delta.api.client.ui.hud.impl;

import fr.nkosmos.starboard.Group;
import fr.nkosmos.starboard.Setting;
import fr.nkosmos.starboard.api.ISetting;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import me.xtrm.delta.api.client.ui.context.RenderContext;
import me.xtrm.delta.api.client.ui.font.EnumFont;
import me.xtrm.delta.api.client.ui.font.IFontRenderer;
import me.xtrm.delta.api.client.ui.hud.IMovableElement;
import meteordevelopment.starscript.Script;
import meteordevelopment.starscript.compiler.Compiler;
import meteordevelopment.starscript.compiler.Parser;

import java.awt.*;

@Getter
public class TextElement implements IMovableElement {

    private final Group rootGroup = new Group("root", null, true);

    private final Setting<String> text = new Setting<>(rootGroup, "Text", "Default text").callback(this::updateText);
    private final Setting<EnumFont> font = new Setting<>(rootGroup, "Font", EnumFont.NORMAL).values(EnumFont.values()).callback(this::updateFontRenderer);
    private final Setting<Boolean> dropShadow = new Setting<>(rootGroup, "Shadow", true);
    private final Setting<Boolean> background = new Setting<>(rootGroup, "Background", true);
    public final Setting<Color> color = new Setting<>(rootGroup, "Color", new Color(255, 255, 255, 255));

    @Getter(AccessLevel.PRIVATE)
    private Script script;

    @Getter(AccessLevel.PRIVATE)
    private IFontRenderer fontRenderer;

    @Setter
    private int x;
    @Setter
    private int y;

    public TextElement(String text, int x, int y, EnumFont font, boolean shadow, boolean background, Color color) {
        this.text.set(text);
        this.font.set(font);
        this.dropShadow.set(shadow);
        this.background.set(background);
        this.color.set(color);

        this.x = x;
        this.y = y;
    }

    @Override
    public String getName() {
        return "Text Element" + (text.get() != null ? " (" + text + ")" : "");
    }

    @Override
    public void render(RenderContext context) {
        String output = text.get();
        if (script != null) {
            output = context.getRenderStarscript().run(script);
        }

        if(fontRenderer == null) {
            EnumFont font = this.font.get();
            fontRenderer = context.getFontProvider().getFontRenderer(font);
        }
        fontRenderer.drawString(output, x, y, color.get().getRGB(), dropShadow.get());
    }

    private void updateText(ISetting<String> text, String oldValue) {
        Parser.Result result = Parser.parse(text.get());

        if (!result.hasErrors()) {
            this.script = Compiler.compile(result);
        } else {
            this.script = null;
        }
    }

    private void updateFontRenderer(ISetting<EnumFont> font, EnumFont oldValue) {
        fontRenderer = null;
    }

    @Override
    public int getWidth() {
        return fontRenderer == null ? 0 : fontRenderer.getStringWidth(text.get());
    }

    @Override
    public int getHeight() {
        return fontRenderer == null ? 0 : fontRenderer.getFontHeight();
    }
}