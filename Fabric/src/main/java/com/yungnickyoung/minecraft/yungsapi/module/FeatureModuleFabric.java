package com.yungnickyoung.minecraft.yungsapi.module;

import com.yungnickyoung.minecraft.yungsapi.autoregister.AutoRegistrationManager;
import com.yungnickyoung.minecraft.yungsapi.autoregister.RegisterData;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.Feature;

/**
 * Registration of features.
 */
public class FeatureModuleFabric {
    public static void processEntries() {
        AutoRegistrationManager.FEATURES.stream()
                .filter(data -> !data.processed())
                .forEach(FeatureModuleFabric::register);
    }

    private static void register(RegisterData data) {
        Registry.register(Registry.FEATURE, data.name(), (Feature<?>) data.object());
        data.markProcessed();
    }
}