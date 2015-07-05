import java.util.*;

public class CookingDatabase {

    Map<User, List<Recipe>> user_recipe_map = new HashMap<User, List<Recipe>>();
    Map<Recipe, User> recipe_user_map = new HashMap<Recipe, User>();
    List<Recipe> recipeList = new ArrayList<Recipe>();
    List<User> userList = new ArrayList<User>();

    //���V�s��ǉ�����
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

    //i�Ԗڂ̃��V�s���o�͂���
    public Recipe getRecipe(int i){
        if(i>=this.recipeList.size()){
            System.err.println(i+"�Ԗڂ̃��V�s�͂���܂���B");
            return null;
        }
        return this.recipeList.get(i);
    }

    //���[�U���w�肵���h�c�̃��V�s���o�͂���
    public Recipe getRecipeByID(int query_id){
        for(int i=0;i<recipeList.size();i++){
            Recipe recipe = this.recipeList.get(i);
            if(recipe.id == query_id){
                return recipe;
            }
        }
        //�G���[�����F����ID�̃��V�s�͖���
        System.out.println("ID��"+query_id+"�̃��V�s�͂���܂���B");
        return null;

    }

    public User getUser(int i){
        if(i>=this.userList.size()){
            System.err.println(i+"�Ԗڂ̃��[�U�͓o�^����Ă��܂���");
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
            System.err.println("���[�U "+u.name+" �͓o�^����Ă��܂���");
            return null;
        }
        else{
            return this.user_recipe_map.get(u);
        }
    }

//    //���V�s���X�g�����[�U���Ƃɏo�͂���
//    public void printAllRecipesGroupedByUser(){
//        for(int i=0;i<this.userList.size();i++){
//            User user = new this.userList.get(i);
//            System.out.println("���[�U���F"+user.name);
//            List<Recipe> recipe_list = this.user_recipe_map.get(user);
//            for(int j=0;j<recipe_list.size();j++){
//                Recipe recipe = this.getRecipe(j);
//                System.out.println(recipe.getRecipeInfo());
//            }
//        }
//    }

}