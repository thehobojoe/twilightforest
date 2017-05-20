package twilightforest.client.renderer.entity;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import twilightforest.TwilightForestMod;
import twilightforest.entity.boss.EntityTFHydra;

public class RenderTFHydra extends RenderLiving<EntityTFHydra> {
    private static final ResourceLocation textureLoc = new ResourceLocation(TwilightForestMod.MODEL_DIR + "hydra4.png");
	
	public RenderTFHydra(RenderManager manager, ModelBase modelbase, float shadowSize) {
		super(manager, modelbase, shadowSize);
	}

	@Override
	public void doRender(EntityTFHydra entity, double d, double d1, double d2, float f, float f1) {
		// render the hydra body, legs, tail normally
		super.doRender(entity, d, d1, d2, f, f1);

        BossStatus.setBossStatus((EntityTFHydra)entity, false);
		
//        GlStateManager.pushMatrix();
////        renderOffsetAABB(entity.boundingBox, d - entity.lastTickPosX, d1 - entity.lastTickPosY, d2 - entity.lastTickPosZ);
//        renderOffsetAABB(hydra.body.boundingBox, d - entity.lastTickPosX, d1 - entity.lastTickPosY, d2 - entity.lastTickPosZ);
//        renderOffsetAABB(hydra.tail.boundingBox, d - entity.lastTickPosX, d1 - entity.lastTickPosY, d2 - entity.lastTickPosZ);
//        GlStateManager.popMatrix();

//        System.out.println("Rendering AABB, d = " + d + ", " + d1 + ", " + d2 + ".  entity = " + entity.lastTickPosX + ", " + entity.lastTickPosY + ", " + entity.lastTickPosZ + ".  tail = " + hydra.tail.posX + ", " + hydra.tail.posY + ", " + hydra.tail.posZ);
//        System.out.println("AABB, at " + (d - entity.lastTickPosX - (entity.lastTickPosX - hydra.tail.posX)) + ", " +  (d1 - entity.lastTickPosY - (entity.lastTickPosY - hydra.tail.posY)) + ", " + (d2 - entity.lastTickPosZ - (entity.lastTickPosZ - hydra.tail.posZ)));
//        System.out.println("Theoretically it could be " + (d - hydra.tail.posX) + ", " +  (d1 - hydra.tail.posY) + ", " + (d2 - hydra.tail.posZ));
		
	}

	@Override
	protected float getDeathMaxRotation(EntityTFHydra par1EntityLiving) {
		return 0F;
	}

    @Override
	protected ResourceLocation getEntityTexture(EntityTFHydra par1Entity)
    {
        return textureLoc;
    }
}
