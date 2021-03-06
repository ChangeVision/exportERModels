# 指定したastahのモデルファイルのERモデルの情報を標準出力に出力する (APIサンプル)
![image](https://github.com/ChangeVision/exportERModels/raw/master/doc/screenshots/exportERModels.png)

## 使い方

1. [Astah Plug-in SDKをインストール(このサンプルのコンパイルと実行に利用します)](http://astah.change-vision.com/ja/plugin-tutorial/devenv.html)
2. このリポジトリをcloneするか [ソースコードをダウンロードしてください。](https://github.com/ChangeVision/exportERModels/archive/master.zip)
3. 適当なフォルダに解凍し、コンソール上でそのフォルダを作業フォルダに指定してください。
3. `astah-build` を実行してください。
5. `astah-mvn -q exec:exec -DmodelPath=YOUR_MODEL_PATH` を実行するか、
6. `java -cp [astah-api.jar and astah-pro.jar path] com.change_vision.astah.apisample.ERModelCSVExporter [target astah model]`を実行してください。


## サンプルコードの簡単な説明

src/main/java

  * com.change_vision.astah.apisample.ERModelCSVExporter - ER Model 情報を出力するメインクラスです。出力情報を編集するには、このクラスを編集してください。
  * com.change_vision.astah.apisample.AstahAPIWrapper - Astah APIのエラーをハンドリングするためのラッパークラスです。

## 注意事項

 * 当APIサンプルのコンパイルと実行にはastah* professionalが必要です。

## License
Copyright 2012 Change Vision, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this work except in compliance with the License.
You may obtain a copy of the License in the LICENSE file, or at:

   <http://www.apache.org/licenses/LICENSE-2.0>

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
    
