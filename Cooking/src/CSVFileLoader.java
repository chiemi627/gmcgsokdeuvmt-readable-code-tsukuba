import java.io.*;

public class CSVFileLoader {

    final static String recipe_dir = "recipes";
    final static String user_list_file = "user_prof.csv";

    //すべてのデータをファイルからロードする
    public static boolean loadData(CookingDatabase db){
        try {
            File file = new File(user_list_file);
            FileReader filereader = new FileReader(file);
            BufferedReader br = new BufferedReader(filereader);

            String line;
            while ((line = br.readLine()) != null) {
                String[] items = line.split(",");
                String user_name = items[0];
                String recipe_file = items[1];
                loadRecipes(db, user_name, recipe_file);
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


    //ユーザ1人分のRecipeListオブジェクトをロードする
    public static boolean loadRecipes(CookingDatabase db, String user_name, String recipe_file){

        User user = new User(user_name);
        String recipe_path = recipe_dir+"/"+recipe_file;

        try {
            File file = new File(recipe_path);
            FileReader filereader = new FileReader(file);
            BufferedReader br = new BufferedReader(filereader);
            String line;
            while ((line = br.readLine()) != null) {
                //Recipeオブジェクトを作る
                Recipe recipe = new Recipe();
                //CSVファイルからRecipeデータを作る
                String[] items = line.split(",");

                //0番目にタイトル
                recipe.title = items[0];
                //1番目に説明
                recipe.description = items[1];
                //レシピリストにレシピを追加する
                db.addRecipe(user,recipe);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("Recipe file can not be found.: "+recipe_file);
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}