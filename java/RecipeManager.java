import java.util.*;

public class RecipeManager{

    List<Recipe> recipeList;

    public static void main(String[] args){
        RecipeManager manager = new RecipeManager();


        //�ŏ��ɂ�鎖�i�f�[�^�̓ǂݍ��݁j
        if(!manager.initManager()){
            System.out.println("���V�s�f�[�^�̏������Ɏ��s���܂���");
            System.exit(0);
        }

        manager.printRecipeList();
    }

    public boolean initManager(){
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

    //���V�s���X�g���o�͂���
    public void printRecipeList(){
        for(int i=0;i<recipeList.size();i++){
            Recipe recipe = this.recipeList.get(i);
            System.out.println(recipe.getRecipeInfo());
        }
    }

}