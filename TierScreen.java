package com.tiertagger.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.EditBox;
import net.minecraft.network.chat.Component;

import java.util.List;

public final class TierScreen extends Screen {
    private final TierDataStore store;
    private EditBox searchBox;

    public TierScreen(TierDataStore store) {
        super(Component.literal("TierTagger"));
        this.store = store;
    }

    @Override
    protected void init() {
        super.init();
        searchBox = new EditBox(this.font, this.width / 2 - 140, 35, 280, 20, Component.literal("Search player"));
        searchBox.setValue("");
        this.addRenderableWidget(searchBox);
        searchBox.setFocused(true);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        context.drawCenteredString(this.font, "TierTagger", this.width / 2, 12, 0xFFFFFF);

        List<TierEntry> results = store.search(searchBox == null ? "" : searchBox.getValue());
        int y = 70;
        int shown = 0;
        for (TierEntry entry : results) {
            String line = entry.player() + " | " + entry.gamemode() + " | " + entry.tier();
            context.drawString(this.font, line, this.width / 2 - 140, y, 0xFFFFFF);
            y += 16;
            if (++shown >= 18) break;
        }

        if (results.isEmpty()) {
            context.drawCenteredString(this.font, "No tier found", this.width / 2, 75, 0xAAAAAA);
        }

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
