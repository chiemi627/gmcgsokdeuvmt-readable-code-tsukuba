import java.util.*;
import java.io.*;

public class RecipeGenerator {

    List<Recipe> recipeList = new ArrayList<Recipe>();
    static String recipefile = "recipe-data.csv";

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
            String title = this.getRecipeTitle(i);
            if(title != null) {
                System.out.println(title);
            }
        }
    }

    //レシピリストをファイルから読み込む
    public void generateRecipesFromFile(){

        try {
            File file = new File(RecipeGenerator.recipefile);
            FileReader filereader = new FileReader(file);
            BufferedReader br = new BufferedReader(filereader);
            String line;
            while ((line = br.readLine()) != null) {
                //Recipeオブジェクトを作る
                Recipe recipe = new Recipe();
                //CSVファイルからRecipeデータを作る
                String[] items = line.split(",");

                //とりあえず最初は0番目にタイトル
                //TODO: フォーマットの変化に対応できるようにする
                recipe.title = items[0];
                //レシピリストにレシピを追加する
                recipeList.add(recipe);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("Recipe file can not be found.: "+recipefile);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //CSVファイルの1行分からレシピを作る
    public static Recipe makeRecipeFromCSV(String line){
        //Recipeオブジェクトを作る
        Recipe recipe = new Recipe();
        //CSVファイルからRecipeデータを作る
        String[] items = line.split(",");

        //とりあえず最初は0番目にタイトル
        //TODO: フォーマットの変化に対応できるようにする
        recipe.title = items[0];

        return recipe;

    }

    public static void main(String[] args){
        RecipeGenerator generator = new RecipeGenerator();
        generator.generateRecipesFromFile();
        generator.printRecipeList();
    }

}