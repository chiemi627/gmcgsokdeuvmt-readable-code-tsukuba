import java.util.*;
import java.io.*;

public class RecipeGenerator {

    final static String recipefile = "../recipe-data.csv";


    //���V�s���X�g���t�@�C������ǂݍ���
    public static List<Recipe> generateRecipesFromFile(){

        List<Recipe> recipeList = new ArrayList<Recipe>();

        try {
            File file = new File(RecipeGenerator.recipefile);
            FileReader filereader = new FileReader(file);
            BufferedReader br = new BufferedReader(filereader);
            String line;
            while ((line = br.readLine()) != null) {
                //Recipe�I�u�W�F�N�g�����
                Recipe recipe = new Recipe();
                //CSV�t�@�C������Recipe�f�[�^�����
                String[] items = line.split(",");

                //�Ƃ肠�����ŏ���0�ԖڂɃ^�C�g��
                recipe.title = items[0];
                recipe.description = items[1];
                //���V�s���X�g�Ƀ��V�s��ǉ�����
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

    //CSV�t�@�C����1�s�����烌�V�s�����
    public static Recipe makeRecipeFromCSV(String line){
        //Recipe�I�u�W�F�N�g�����
        Recipe recipe = new Recipe();
        //CSV�t�@�C������Recipe�f�[�^�����
        String[] items = line.split(",");

        //�Ƃ肠�����ŏ���0�ԖڂɃ^�C�g��
        //TODO: �t�H�[�}�b�g�̕ω��ɑΉ��ł���悤�ɂ���
        recipe.title = items[0];

        return recipe;

    }


}