import java.io.*;

public class CSVFileLoader {

    final static String recipe_dir = "recipes";
    final static String user_list_file = "user_prof.csv";

    //���ׂẴf�[�^���t�@�C�����烍�[�h����
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


    //���[�U1�l����RecipeList�I�u�W�F�N�g�����[�h����
    public static boolean loadRecipes(CookingDatabase db, String user_name, String recipe_file){

        User user = new User(user_name);
        String recipe_path = recipe_dir+"/"+recipe_file;

        try {
            File file = new File(recipe_path);
            FileReader filereader = new FileReader(file);
            BufferedReader br = new BufferedReader(filereader);
            String line;
            while ((line = br.readLine()) != null) {
                //Recipe�I�u�W�F�N�g�����
                Recipe recipe = new Recipe();
                //CSV�t�@�C������Recipe�f�[�^�����
                String[] items = line.split(",");

                //0�ԖڂɃ^�C�g��
                recipe.title = items[0];
                //1�Ԗڂɐ���
                recipe.description = items[1];
                //���V�s���X�g�Ƀ��V�s��ǉ�����
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