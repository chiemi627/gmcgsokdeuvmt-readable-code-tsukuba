import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiemi on 2015/07/05.
 */
public class RecipeManager {

    CookingDatabase db = new CookingDatabase();

    public boolean init(){
        if( !CSVFileLoader.loadDataset(db) ) {return false;}
        return true;
    }

    public void printAllRecipesGroupedByUser(){
        for(int i=0;i<db.countUser();i++){
            User user = db.getUser(i);
            System.out.println("���[�U���F"+user.name);
            List<Recipe> recipeList = db.getRecipesByUser(user);
            for(int j=0;j<recipeList.size();j++){
                System.out.println(recipeList.get(j).getRecipeInfo());
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){
        RecipeManager manager = new RecipeManager();

        //�N�����̏���
        if(!manager.init()){
            System.out.println("�V�X�e���̏������Ɏ��s���܂���");
            System.exit(0);
        }

        //manager.printRecipeList();
        if(args.length == 0){
            manager.printAllRecipesGroupedByUser();
        }
        else if(args.length == 1) {
            Recipe recipe = manager.db.getRecipeByID(Integer.parseInt(args[0]));
            System.out.println(recipe.getRecipeInfo());
        }
        else{
            System.err.println("Usage: RecipeManager <RecipeNo>");
            System.exit(0);
        }
    }

}
