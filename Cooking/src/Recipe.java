public class Recipe{
    public int id;
    public String title;
    public String description;

    //�N���X�ϐ�
    public static int lastID = 0;

    public String getRecipeInfo(){
        return id+":"+title+":\n    ����: "+description;
    }

    public Recipe(){
        id = lastID;
        lastID++;
    }
}