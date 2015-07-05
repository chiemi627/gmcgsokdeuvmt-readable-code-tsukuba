/**
 * Created by chiemi on 2015/07/05.
 */
public class User {
    public int id;
    public String name;
    public String recipe_file;

    static int lastID = 0; //ユーザID用の変数

    private User(){} //使わない

    public User(String n){
        name = n;
        id = User.lastID; //コンストラクタ上でユーザIDを自動的にふる
        User.lastID++; //カウントアップ
    }
}
