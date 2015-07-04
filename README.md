使用言語: Java
アカウント名: gmcgsokdeuvmt

## 仕様1 レシピを出力

### 実装コードの場所

* [OmuriceGenerator.java](https://github.com/gmcgsokdeuvmt/gmcgsokdeuvmt-readable-code-tsukuba/java/OmuriceGenerator.java)

javaフォルダ下に ```OmuriceGenerator.java``` ファイルがあります。これを自分の環境下に置くようにしてください。

### java ファイルのコンパイル

自分の環境下にある ```OmuriceGenerator.java``` のあるディレクトリに移動してください。
ターミナルで以下のようにコマンドを叩きます。

```
javac OmuriceGenerator.java
```

この時、コンパイルによって ```OmuriceGenerator.class``` が生成されます。

#### コンパイルできない？

もし、コンパイルができない場合、ファイル名・クラス名を間違えている可能性があります。java の場合、ファイル名とクラス名が一致する必要がありますので、よく確認してみてください。

#### そもそも javac できない

そもそも javac 出来ない可能性があります。Windows の場合 javac のプログラムは
```C:\\Program Files\\Java\\jdk1.8.0_40\\bin\\```下にあると思います。ここにパスを通すようにしてみて下さい。

### java ファイルの実行

コンパイルが完了したら java ファイルを実行して、その動作を確認してみてください。

以下のように ```OmuriceGenerator``` を実行してみてください。今回は**入力**を持たないので、引数は必要ありません。

```
java OmuriceGenerator
```

#### 実行例

```OmuriceGenerator``` を実行すると```オムライス```という文字列が表示されます。確認してみてください。

```
λ java OmuriceGenerator
オムライス
```