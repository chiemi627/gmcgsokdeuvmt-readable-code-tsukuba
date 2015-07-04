public class Recipe{
    public int id;
    public String title;
    public static int lastID = 0;

    public String getRecipeInfo(){
        return id+":"+title;
    }

    public Recipe(){
        id = lastID;
        lastID++;
    }
}