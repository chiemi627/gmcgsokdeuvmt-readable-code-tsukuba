import java.util.*;
import java.io.*;

public class CSVFileLoader {

    final static String recipe_path = "recipes";
    final static String user_list_file = "user_prof.csv";

    public static boolean loadDataset(CookingDatabase db){
        try {
            File file = new File(user_list_file);
            FileReader filereader = new FileReader(file);
            BufferedReader br = new BufferedReader(filereader);

            String line;
            while ((line = br.readLine()) != null) {
                String user_name = line;
                loadUsersRecipe(db, user_name);
            }

        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            return false;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }


    //RecipeListオブジェクトを作成する
    public static boolean loadUsersRecipe(CookingDatabase db, String user_name){

        String recipe_file = recipe_path+"/"+user_name+".csv";

        User user = new User(user_name);
        if(!CSVFileLoader.loadRecipes(db, user, recipe_file)){
            System.err.println("データのローディングに失敗しました");
            return false;
        }
        return true;
    }

    //レシピのリストをファイルから読み込む
    public static boolean loadRecipes(CookingDatabase db, User user, String recipefile){

        try {
            File file = new File(recipefile);
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
                db.addRecipe(user,recipe);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("Recipe file can not be found.: "+recipefile);
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}