import java.util.*;

public class RecipeManager{

    List<Recipe> recipeList;

    public static void main(String[] args){
        RecipeManager manager = new RecipeManager();


        //最初にやる事（データの読み込み）
        if(!manager.initManager()){
            System.out.println("レシピデータの初期化に失敗しました");
            System.exit(0);
        }

        manager.printRecipeList();
    }

    public boolean initManager(){
        //レシピの生成(ファイルからのロード)
        recipeList = RecipeGenerator.generateRecipesFromFile();
        if(recipeList==null){
            System.out.println("レシピデータのロードに失敗しました");
            return false;
        }
        return true;
    }

    //i番目のレシピのタイトルを出力する
    public String getRecipeTitle(int i){
        if(i>=this.recipeList.size()){
            System.err.println(i+"番目のレシピはありません。");
            return null;
        }
        return this.recipeList.get(i).title;
    }

    //レシピリストを出力する
    public void printRecipeList(){
        for(int i=0;i<recipeList.size();i++){
            Recipe recipe = this.recipeList.get(i);
            System.out.println(recipe.getRecipeInfo());
        }
    }

}