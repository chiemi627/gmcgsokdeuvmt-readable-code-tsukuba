import java.util.*;
import java.io.*;

public class RecipeGenerator {

    final static String recipefile = "../recipe-data.csv";


    //レシピリストをファイルから読み込む
    public static List<Recipe> generateRecipesFromFile(){

        List<Recipe> recipeList = new ArrayList<Recipe>();

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
                recipe.title = items[0];
                recipe.description = items[1];
                //レシピリストにレシピを追加する
                recipeList.add(recipe);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("Recipe file can not be found.: "+recipefile);
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return recipeList;
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


}