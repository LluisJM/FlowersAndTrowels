package net.lluisjm.flowersandtrowels.util;

import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class ModParticleUtils {

    public static Vec3 offsetRandomHorizontal(Vec3 vec3, Random random) {
        double xOffset = random.nextDouble() - 0.5F;
        double zOffset = random.nextDouble() - 0.5F;
        return vec3.add(xOffset,0.0F, zOffset);
    }
}
