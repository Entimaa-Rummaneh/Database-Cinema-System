/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alkasabaproject;

/**
 *
 * @author User
 */
public class Food {
    private int meal_id;
    private String meal_name;
    private float price;
    private float cost;
    private byte [] picture; 

public Food(int fid,String fmeal_name,float fprice,float fcost,byte[]fimg)
{
this.meal_id=fid;
this.meal_name=fmeal_name;
this.price=fprice;
this.cost=fcost;
this.picture=fimg;

}

    /**
     * @return the meal_id
     */
    public int getMeal_id() {
        return meal_id;
    }

    /**
     * @return the meal_name
     */
    public String getMeal_name() {
        return meal_name;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @return the cost
     */
    public float getCost() {
        return cost;
    }

    /**
     * @return the picture
     */
    public byte[] getPicture() {
        return picture;
    }
}
