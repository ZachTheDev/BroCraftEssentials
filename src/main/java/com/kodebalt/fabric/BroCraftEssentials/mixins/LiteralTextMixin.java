package com.kodebalt.fabric.BroCraftEssentials.mixins;

import com.kodebalt.fabric.BroCraftEssentials.commands.util.TextFormatter;
import com.kodebalt.fabric.BroCraftEssentials.config.Config;
import net.minecraft.text.LiteralText;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LiteralText.class)
public abstract class LiteralTextMixin {

    @Mutable
    @Final
    @Shadow
    public String string;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void LiteralText(String string, CallbackInfo ci) {
        if (Config.INSTANCE.enableColor) {
            this.string = TextFormatter.INSTANCE.formatString(string);
        } else {
            this.string = string;
        }
    }
}