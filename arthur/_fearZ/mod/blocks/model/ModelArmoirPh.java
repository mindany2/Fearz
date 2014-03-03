package _fearZ.mod.blocks.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
//
public class ModelArmoirPh extends ModelBase
{
  //fields
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape1;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    public ModelRenderer porte1;
    public ModelRenderer porte2;
    public ModelRenderer poignee1;
    public ModelRenderer poignee2;
    ModelRenderer Shape6;
  
  public ModelArmoirPh()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Shape2 = new ModelRenderer(this, 14, 51);
      Shape2.addBox(0F, 0F, 0F, 16, 10, 1);
      Shape2.setRotationPoint(-8F, 11F, 7F);
      Shape2.setTextureSize(64, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 9, 5);
      Shape3.addBox(0F, 0F, 0F, 16, 1, 4);
      Shape3.setRotationPoint(-8F, 11F, 3F);
      Shape3.setTextureSize(64, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 10, 40);
      Shape1.addBox(0F, 0F, 0F, 16, 1, 4);
      Shape1.setRotationPoint(-8F, 20F, 3F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 46, 14);
      Shape4.addBox(0F, 0F, 0F, 1, 8, 4);
      Shape4.setRotationPoint(7F, 12F, 3F);
      Shape4.setTextureSize(64, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 5, 15);
      Shape5.addBox(0F, 0F, 0F, 1, 8, 4);
      Shape5.setRotationPoint(-8F, 12F, 3F);
      Shape5.setTextureSize(64, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      porte1 = new ModelRenderer(this, 16, 18);
      porte1.addBox(0F, -4F, 0F, 7, 8, 1);
      porte1.setRotationPoint(-7F, 16F, 2.8F);
      porte1.setTextureSize(64, 64);
      porte1.mirror = true;
      setRotation(porte1, 0F, 0F, 0F);
      porte2 = new ModelRenderer(this, 29, 28);
      porte2.addBox(-7F, -4F, 0F, 7, 8, 1);
      porte2.setRotationPoint(7F, 16F, 2.8F);
      porte2.setTextureSize(64, 64);
      porte2.mirror = true;
      setRotation(porte2, 0F, 0F, 0F);
      poignee1 = new ModelRenderer(this, 37, 20);
      poignee1.addBox(5F, -1F, -1F, 1, 2, 1);
      poignee1.setRotationPoint(-7F, 16F, 3F);
      poignee1.setTextureSize(64, 64);
      poignee1.mirror = true;
      setRotation(poignee1, 0F, 0F, 0F);
      poignee2 = new ModelRenderer(this, 37, 20);
      poignee2.addBox(-6F, -1F, -1F, 1, 2, 1);
      poignee2.setRotationPoint(7F, 16F, 3F);
      poignee2.setTextureSize(64, 64);
      poignee2.mirror = true;
      setRotation(poignee2, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 11, 0);
      Shape6.addBox(0F, 0F, 0F, 14, 1, 3);
      Shape6.setRotationPoint(-7F, 15.5F, 4F);
      Shape6.setTextureSize(64, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
  }
  
  public void render(float f)
  {
    Shape2.render(f);
    Shape3.render(f);
    Shape1.render(f);
    Shape4.render(f);
    Shape5.render(f);
    porte1.render(f);
    porte2.render(f);
    poignee1.render(f);
    poignee2.render(f);
    Shape6.render(f);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}
