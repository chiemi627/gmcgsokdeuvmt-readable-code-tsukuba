import java.util.*;

public class CookingDatabase {

    Map<User, List<Recipe>> user_recipe_map = new HashMap<User, List<Recipe>>();
    Map<Recipe, User> recipe_user_map = new HashMap<Recipe, User>();
    List<Recipe> recipeList = new ArrayList<Recipe>();
    List<User> userList = new ArrayList<User>();

    //レシピを追加する
    public void addRecipe(User user, Recipe recipe){
        if(!recipeList.contains(recipe)){
            this.recipeList.add(recipe);
        }
        if(!userList.contains(user)){
            this.userList.add(user);
        }
        if(!user_recipe_map.containsKey(user)) {
            user_recipe_map.put(user, new ArrayList<Recipe>());
        }
        user_recipe_map.get(user).add(recipe);
        recipe_user_map.put(recipe, user);
    }

    //i番目のレシピを出力する
    public Recipe getRecipe(int i){
        if(i>=this.recipeList.size()){
            System.err.println(i+"番目のレシピはありません。");
            return null;
        }
        return this.recipeList.get(i);
    }

    //ユーザが指定したＩＤのレシピを出力する
    public Recipe getRecipeByID(int query_id){
        for(int i=0;i<recipeList.size();i++){
            Recipe recipe = this.recipeList.get(i);
            if(recipe.id == query_id){
                return recipe;
            }
        }
        //エラー処理：そのIDのレシピは無い
        System.out.println("IDが"+query_id+"のレシピはありません。");
        return null;

    }

    public User getUser(int i){
        if(i>=this.userList.size()){
            System.err.println(i+"番目のユーザは登録されていません");
            return null;
        }
        else{
            return this.userList.get(i);
        }
    }

    public int countUser(){
        return this.userList.size();
    }

    List<Recipe> getRecipesByUser(User u){
        if(!this.user_recipe_map.containsKey(u)){
            System.err.println("ユーザ "+u.name+" は登録されていません");
            return null;
        }
        else{
            return this.user_recipe_map.get(u);
        }
    }

//    //レシピリストをユーザごとに出力する
//    public void printAllRecipesGroupedByUser(){
//        for(int i=0;i<this.userList.size();i++){
//            User user = new this.userList.get(i);
//            System.out.println("ユーザ名："+user.name);
//            List<Recipe> recipe_list = this.user_recipe_map.get(user);
//            for(int j=0;j<recipe_list.size();j++){
//                Recipe recipe = this.getRecipe(j);
//                System.out.println(recipe.getRecipeInfo());
//            }
//        }
//    }

}