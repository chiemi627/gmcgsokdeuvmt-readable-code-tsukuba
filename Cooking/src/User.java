/**
 * Created by chiemi on 2015/07/05.
 */
public class User {
    public int id;
    public String name;
    public String recipe_file;

    static int lastID = 0; //���[�UID�p�̕ϐ�

    private User(){} //�g��Ȃ�

    public User(String n){
        name = n;
        id = User.lastID; //�R���X�g���N�^��Ń��[�UID�������I�ɂӂ�
        User.lastID++; //�J�E���g�A�b�v
    }
}
