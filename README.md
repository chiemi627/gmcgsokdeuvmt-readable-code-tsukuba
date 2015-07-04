使用言語: Java
アカウント名: gmcgsokdeuvmt

## 概要
　仕様5 レシピ一覧をIDつきで出力する

### 実装コードの場所

* [RecipeManager.java](https://github.com/chiemi627/gmcgsokdeuvmt-readable-code-tsukuba/java/*.java)

srcフォルダ下に 以下のjavaファイルがあります。これを自分の環境下に置くようにしてください。
- RecipeManager.java
- RecipeGenerator.java
- Recipe.java
またレシピファイルもjavaファイルにはいっていますので、これも自分の環境下においてください。

### java ファイルのコンパイル

自分の環境下にあるjava のあるディレクトリに移動してください。
ターミナルで以下のようにコマンドを叩きます。

```
javac *.java
```

この時、コンパイルによってクラスファイル が生成されます。

### java ファイルの実行

コンパイルが完了したら java ファイルを実行して、その動作を確認してみてください。

以下のように ```RecipeManager``` を実行してみてください。今回は**入力**を持たないので、引数は必要ありません。

```
java RecipeManager
```

#### 実行例

```RecipeManager``` を実行すると登録されたレシピ名がレシピIDとともに表示されます。確認してみてください。

```
λ java RecipeManager
0:オムライス
1:親子丼
2:杏仁豆腐
```

また、```RecipeManager``` の後にレシピ番号を指定すると、指定されたレシピ名のみ表示されます。