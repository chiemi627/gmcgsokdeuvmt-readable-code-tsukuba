使用言語: Java
アカウント名: gmcgsokdeuvmt

## 概要
　仕様９ 4人のユーザーのレシピ情報をサポートする

### ファイルの設置

* [RecipeManager.java](https://github.com/chiemi627/gmcgsokdeuvmt-readable-code-tsukuba/java/*.java)

srcフォルダ下のjavaファイルを自分の環境下においてください。
レシピファイルはrecipesフォルダにあります。フォルダごとjavaファイルと同じ場所においてください。
ユーザファイルは user_prof.csv です。javaファイルと同じところに設置してください。

### java ファイルのコンパイル

自分の環境下にあるjava のあるディレクトリに移動してください。
ターミナルで以下のようにコマンドを叩きます。

```
javac *.java
```

この時、コンパイルによってクラスファイル が生成されます。

### java ファイルの実行

コンパイルが完了したら java ファイルを実行して、その動作を確認してみてください。

以下のように ```RecipeManager``` を実行してみてください。

```
java RecipeManager
```

#### 実行例

```RecipeManager``` を実行すると登録されたレシピ名がレシピIDとともに表示されます。

```
λ java RecipeManager
ユーザ名：kou
0:オムライス:
    作り方: 卵を焼いてごはんにのせる
1:親子丼:
    作り方: 鶏肉を焼いて卵でとじてごはんにのせる
2:杏仁豆腐:
    作り方: 牛乳と砂糖をまぜてゼラチンで固める

ユーザ名：tao
3:オムライス:
    作り方: 卵を焼いてごはんにのせる
4:鶏の唐揚げ:
    作り方: 鶏肉にから揚げ粉をまぶして揚げる
5:カレー:
    作り方: 野菜を切って煮込んでカレー粉を入れる

ユーザ名：mare
6:トマトサラダ:
    作り方: トマトと野菜を切ってまぜる
7:生ハムサラダ:
    作り方: 生ハムと野菜を切ってまぜる
8:和風サラダ:
    作り方: 豆腐と野菜を切ってまぜて醤油ベースのドレッシングをかける

ユーザ名：keita
9:チョコケーキ:
    作り方: 薄力粉とココアと卵とバターをまぜて焼く
10:スイートポテト:
    作り方: 蒸したさつまいもと砂糖とバターと生クリームをまぜて焼く
11:杏仁豆腐:
    作り方: 牛乳と砂糖をまぜてゼラチンで固める
```

また、```RecipeManager``` の後にレシピ番号を指定すると、指定されたレシピ名のみ表示されます。