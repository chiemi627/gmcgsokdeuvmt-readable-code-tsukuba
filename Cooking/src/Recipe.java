public class Recipe{
    public int id;
    public String title;
    public String description;

    static int lastID = 0; //���V�sID�p�̕ϐ�

    public String getRecipeInfo(){
        return id+":"+title+":\n    ����: "+description;
    }

    public Recipe(){
        id = lastID; //ID�͎����I�ɐU����
        lastID++;
    }
}