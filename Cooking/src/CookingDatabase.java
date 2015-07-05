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

    //���[�U�������߂�
    public int countUsers(){
        return this.userList.size();
    }

    //i�Ԗڂ̃��[�U�����߂�
    public User getUser(int i){
        if(i>=this.userList.size()){
            System.err.println(i+"�Ԗڂ̃��[�U�͓o�^����Ă��܂���");
            return null;
        }
        else{
            return this.userList.get(i);
        }
    }

    //ID��query_id�ł��郆�[�U�����߂�
    public User getUserByID(int query_id){
        for(int i=0;i<this.countUsers();i++){
            User u = getUser(i);
            if(u.id==query_id){
                return u;
            }
        }
        return null;
    }

    //i�Ԗڂ̃��V�s�����߂�
    public Recipe getRecipe(int i){
        if(i>=this.recipeList.size()){
            System.err.println(i+"�Ԗڂ̃��V�s�͂���܂���B");
            return null;
        }
        return this.recipeList.get(i);
    }

    //���[�U���w�肵���h�c�̃��V�s�����߂�
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

    //���[�U�̓o�^�������V�s�����X�g�����߂�
    public List<Recipe> getRecipeListByUser(User u) {
        if (!this.user_recipe_map.containsKey(u)) {
            System.err.println("���[�U " + u.name + " �͓o�^����Ă��܂���");
            return null;
        } else {
            return this.user_recipe_map.get(u);
        }
    }
}