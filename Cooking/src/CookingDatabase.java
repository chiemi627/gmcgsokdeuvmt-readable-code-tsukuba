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

    //ユーザ数を求める
    public int countUsers(){
        return this.userList.size();
    }

    //i番目のユーザを求める
    public User getUser(int i){
        if(i>=this.userList.size()){
            System.err.println(i+"番目のユーザは登録されていません");
            return null;
        }
        else{
            return this.userList.get(i);
        }
    }

    //IDがquery_idであるユーザを求める
    public User getUserByID(int query_id){
        for(int i=0;i<this.countUsers();i++){
            User u = getUser(i);
            if(u.id==query_id){
                return u;
            }
        }
        return null;
    }

    //i番目のレシピを求める
    public Recipe getRecipe(int i){
        if(i>=this.recipeList.size()){
            System.err.println(i+"番目のレシピはありません。");
            return null;
        }
        return this.recipeList.get(i);
    }

    //ユーザが指定したＩＤのレシピを求める
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

    //ユーザの登録したレシピをリストを求める
    public List<Recipe> getRecipeListByUser(User u) {
        if (!this.user_recipe_map.containsKey(u)) {
            System.err.println("ユーザ " + u.name + " は登録されていません");
            return null;
        } else {
            return this.user_recipe_map.get(u);
        }
    }
}