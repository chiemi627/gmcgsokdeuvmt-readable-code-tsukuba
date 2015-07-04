public class Recipe{
    public int id;
    public String title;
    public String description;

    //ƒNƒ‰ƒX•Ï”
    public static int lastID = 0;

    public String getRecipeInfo(){
        return id+":"+title+":\n    ì‚è•û: "+description;
    }

    public Recipe(){
        id = lastID;
        lastID++;
    }
}