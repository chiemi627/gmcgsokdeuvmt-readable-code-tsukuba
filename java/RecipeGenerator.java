import java.util.*;
import java.io.*;

public class RecipeGenerator {

    List<Recipe> recipeList = new ArrayList<Recipe>();
    static String recipefile = "recipe-data.csv";

    public String getRecipeTitle(int i){
        if(i>=this.recipeList.size()){
            System.err.println(i+"�Ԗڂ̃��V�s�͂���܂���B");
            return null;
        }
        return this.recipeList.get(i).title;
    }

    //���V�s���X�g���o�͂���
    public void printRecipeList(){
        for(int i=0;i<recipeList.size();i++){
            String title = this.getRecipeTitle(i);
            if(title != null) {
                System.out.println(title);
            }
        }
    }

    //���V�s���X�g���t�@�C������ǂݍ���
    public void generateRecipesFromFile(){

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
                //TODO: �t�H�[�}�b�g�̕ω��ɑΉ��ł���悤�ɂ���
                recipe.title = items[0];
                //���V�s���X�g�Ƀ��V�s��ǉ�����
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

    public static void main(String[] args){
        RecipeGenerator generator = new RecipeGenerator();
        generator.generateRecipesFromFile();
        generator.printRecipeList();
    }

}