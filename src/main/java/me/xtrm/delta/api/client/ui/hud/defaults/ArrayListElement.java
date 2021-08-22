package me.xtrm.delta.api.client.ui.hud.defaults;

import fr.nkosmos.starboard.Group;
import fr.nkosmos.starboard.Setting;
import fr.nkosmos.starboard.api.ISetting;
import fr.nkosmos.starboard.api.ISettingEnum;
import lombok.*;
import me.xtrm.delta.api.client.features.module.IModule;
import me.xtrm.delta.api.client.features.module.IModuleManager;
import me.xtrm.delta.api.client.ui.animation.IAnimationContainer;
import me.xtrm.delta.api.client.ui.color.ColorMode;
import me.xtrm.delta.api.client.ui.context.RenderContext;
import me.xtrm.delta.api.client.ui.context.Resolution;
import me.xtrm.delta.api.client.ui.font.EnumFont;
import me.xtrm.delta.api.client.ui.font.IFontRenderer;
import me.xtrm.delta.api.client.ui.hud.HudAlignment;
import me.xtrm.delta.api.client.ui.hud.IAlignableElement;
import me.xtrm.delta.api.client.ui.hud.IMovableElement;

import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Getter
public class ArrayListElement implements IMovableElement, IAlignableElement {

    private final Group rootGroup = new Group("root", null, true);

    public final Setting<EnumFont> font = new Setting<>(rootGroup, "Font", EnumFont.NORMAL).callback(this::updateFontRenderer);
    public final Setting<Boolean> dropShadow = new Setting<>(rootGroup, "Shadow", true);
    public final Setting<Boolean> background = new Setting<>(rootGroup, "Background", true);
    public final Setting<Boolean> animation = new Setting<>(rootGroup, "Animation", true);
    //public final Setting<AnimationType> animationType = new Setting<>(rootGroup, "Animation Type", true).values(AnimationType.values()).onlyIf(animation);

    public final Setting<Boolean> border = new Setting<>(rootGroup, "Border", true);
    public final Group borderGroup = new Group("Border Settings", rootGroup);
    public final Setting<BorderStyle> borderStyle = new Setting<>(borderGroup, "Border Style", BorderStyle.FULL).onlyIf(border);
    public final Setting<ColorMode> borderColorMode = new Setting<>(borderGroup, "Border Color Mode", ColorMode.CUSTOM).onlyIf(border).values(ColorMode.values());
    public final Setting<Color> borderCustomColor = new Setting<>(borderGroup, "Border Color", new Color(255, 255, 255, 255)).onlyIf(border).onlyIf(borderColorMode.get()::isCustomizable);

    public final Setting<ColorMode> textColorMode = new Setting<>(rootGroup, "Text Color Mode", ColorMode.CUSTOM).values(ColorMode.values());
    public final Setting<Color> textCustomColor = new Setting<>(rootGroup, "Text Color", new Color(255, 255, 255, 255)).onlyIf(textColorMode.get()::isCustomizable);

    @Getter(AccessLevel.PRIVATE)
    private RenderContext cachedRenderContext;

    @Getter(AccessLevel.PRIVATE)
    private IFontRenderer cachedFontRenderer;

    @Getter(AccessLevel.PRIVATE)
    private List<IModule> toRender;

    @Setter
    private int x;
    @Setter
    private int y;

    private int perModuleWidthOffset = 0;
    private int perModuleHeightOffset = 0;

    @Override
    public HudAlignment getAlignment() {
        return this.cachedRenderContext == null ? HudAlignment.TOP_LEFT : HudAlignment.fromPosition(this.cachedRenderContext, x, y);
    }

    @Override
    public String getName() {
        return "Module List " + (toRender.size());
    }

    @Override
    public void render(RenderContext context) {
        this.toRender = IModuleManager.MODULE_REGISTRY.getAll().stream().filter(IModule::isVisible).filter(m -> m.getDisplayAnimation().isFinished()).collect(Collectors.toList());
        this.cachedRenderContext = context;

        if (this.cachedFontRenderer == null) {
            EnumFont font = this.font.get();
            this.cachedFontRenderer = context.getFontProvider().getFontRenderer(font);
        }

        this.toRender.sort(Comparator.<IModule>comparingInt(m -> cachedFontRenderer.getStringWidth(m.getDisplayName())).reversed());

        Resolution resolution = this.cachedRenderContext.getResolution();

        HudAlignment alignment = getAlignment();
        int xOffset = alignment.getXOffset();
        int yOffset = alignment.getYOffset();
        int startX = xOffset > 0 ? resolution.getWidth() : 0;

        perModuleWidthOffset = border.get() ? 6 : 2;
        perModuleHeightOffset = 2;

        int fontHeight = this.cachedFontRenderer.getFontHeight();
        int yIncrements = fontHeight + perModuleHeightOffset;

        int y1 = 0;

        for (int count = 0; count < this.toRender.size(); count++) {
            IModule module = this.toRender.get(count);
            IAnimationContainer animation = module.getDisplayAnimation();
            int textWidth = this.cachedFontRenderer.getStringWidth(module.getDisplayName());

            float animationValue = animation.getValue(!module.isEnabled());

            int x2 = startX + ((textWidth + perModuleWidthOffset) * xOffset);
            int y2 = y1 + (yIncrements * yOffset);



            y1 += animationValue * yIncrements;
        }
    }

    @Data
    public static class Cum {
        long amount = 69L;
    }

    public static void main(String... args) {
        Supplier<Cum> daddy = you();
        Consumer<Cum> me = xtrm();

        me.accept(daddy.get());
    }

    private static Supplier<Cum> you(){
        return Cum::new;
    }

    private static Consumer<Cum> xtrm(){
        return c -> System.out.println(c.amount);
    }

    @Override
    public int getWidth() {
        if (this.toRender == null || this.toRender.isEmpty()) {
            return 0;
        }
        if (this.cachedFontRenderer == null) {
            return 0;
        }
        return this.toRender.stream()
                .map(IModule::getDisplayName)
                .mapToInt(this.cachedFontRenderer::getStringWidth)
                .max()
                .orElse(-perModuleWidthOffset)
                + perModuleWidthOffset;
    }

    @Override
    public int getHeight() {
        if (this.toRender == null || this.toRender.isEmpty()) {
            return 0;
        }
        if (this.cachedFontRenderer == null) {
            return 0;
        }
        return this.toRender.size() * (this.cachedFontRenderer.getFontHeight() + perModuleHeightOffset);
    }

    private void updateFontRenderer(ISetting<EnumFont> font, EnumFont oldValue) {
        this.cachedFontRenderer = null;
    }

    @Getter
    @RequiredArgsConstructor
    public enum BorderStyle implements ISettingEnum {
        OUTER_SLIM("Outer Slim"),
        INNER_SLIM("Inner Slim"),
        OUTER_BIG("Outer Big"),
        INNER_BIG("Inner Big"),
        FULL("Full");

        private final String name;
    }
}
