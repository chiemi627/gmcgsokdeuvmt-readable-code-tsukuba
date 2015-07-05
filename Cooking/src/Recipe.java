public class Recipe{
    public int id;
    public String title;
    public String description;

    static int lastID = 0; //レシピID用の変数

    public String getRecipeInfo(){
        return id+":"+title+":\n    作り方: "+description;
    }

    public Recipe(){
        id = lastID; //IDは自動的に振られる
        lastID++;
    }
}