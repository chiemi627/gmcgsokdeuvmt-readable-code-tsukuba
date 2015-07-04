public class Recipe{
    public int id;
    public String title;
    public String description;

    //クラス変数
    public static int lastID = 0;

    public String getRecipeInfo(){
        return id+":"+title+":\n    作り方: "+description;
    }

    public Recipe(){
        id = lastID;
        lastID++;
    }
}