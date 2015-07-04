import java.util.*;

public class RecipeManager{

    List<Recipe> recipeList;

    public static void main(String[] args){
        RecipeManager manager = new RecipeManager();


        //�ŏ��ɂ�鎖�i�f�[�^�̓ǂݍ��݁j
        if(!manager.init()){
            System.out.println("���V�s�f�[�^�̏������Ɏ��s���܂���");
            System.exit(0);
        }

        //manager.printRecipeList();
        if(args.length == 0){
            manager.printRecipeList();
        }
        else if(args.length == 1) {
            Recipe recipe = manager.getRecipeByID(Integer.parseInt(args[0]));
            System.out.println(recipe.title);
        }
        else{
            System.err.println("Usage: RecipeManager <RecipeNo>");
            System.exit(0);
        }
    }

    public boolean init(){
        //���V�s�̐���(�t�@�C������̃��[�h)
        recipeList = RecipeGenerator.generateRecipesFromFile();
        if(recipeList==null){
            System.out.println("���V�s�f�[�^�̃��[�h�Ɏ��s���܂���");
            return false;
        }
        return true;
    }

    //i�Ԗڂ̃��V�s�̃^�C�g�����o�͂���
    public String getRecipeTitle(int i){
        if(i>=this.recipeList.size()){
            System.err.println(i+"�Ԗڂ̃��V�s�͂���܂���B");
            return null;
        }
        return this.recipeList.get(i).title;
    }

    //���[�U���w�肵���h�c�̃��V�s���o�͂���
    public Recipe getRecipeByID(int query_id){
        for(int i=0;i<recipeList.size();i++){
            Recipe recipe = this.recipeList.get(i);
            if(recipe.id == query_id){
                return recipe;
            }
        }
        return null;

    }

    //���V�s���X�g���o�͂���
    public void printRecipeList(){
        for(int i=0;i<recipeList.size();i++){
            Recipe recipe = this.recipeList.get(i);
            System.out.println(recipe.getRecipeInfo());
        }
    }

}