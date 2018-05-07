package za.co.smartdevops.smart.kayaapp;

/**
 * Created by smart on 4/19/2018.
 */

public class Model {
    public static  final int IMAGE_TYPE =1;
    public String title,subtile, Image;
    public int type;

    public  Model (int mtype, String mtitle, String msubtitle, String mimage){
        this.title=mtitle;
        this.type=mtype;
        this.Image =mimage;
        this.subtile=msubtitle;
    }
}
