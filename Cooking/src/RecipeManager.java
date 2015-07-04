import java.util.*;

public class RecipeManager{

    List<Recipe> recipeList;

    public static void main(String[] args){
        RecipeManager manager = new RecipeManager();


        //最初にやる事（データの読み込み）
        if(!manager.init()){
            System.out.println("レシピデータの初期化に失敗しました");
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

    //ユーザが指定したＩＤのレシピを出力する
    public Recipe getRecipeByID(int query_id){
        for(int i=0;i<recipeList.size();i++){
            Recipe recipe = this.recipeList.get(i);
            if(recipe.id == query_id){
                return recipe;
            }
        }
        return null;

    }

    //レシピリストを出力する
    public void printRecipeList(){
        for(int i=0;i<recipeList.size();i++){
            Recipe recipe = this.recipeList.get(i);
            System.out.println(recipe.getRecipeInfo());
        }
    }

}