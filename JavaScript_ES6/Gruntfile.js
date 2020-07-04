// Gruntコードの外枠
module.exports = function(grunt) {
    // 初期化情報処理(タスクの定義)
    grunt.initConfig({
        uglify: { // grunt-contrib-uglifyのタスク
            myTask: { // 任意の子タスク
                // 圧縮ルール
                files: {
                    '/Users/y_mori/Git/master/JavaScript_ES6/authenticGuide/chapter08/jasmine/scripts/app.min.js' : // 出力ファイル名
                    [
                        '/Users/y_mori/Git/master/JavaScript_ES6/authenticGuide/chapter08/jasmine/src/Member.js',
                        '/Users/y_mori/Git/master/JavaScript_ES6/authenticGuide/chapter08/jasmine/src/MyArea.js',
                        '/Users/y_mori/Git/master/JavaScript_ES6/authenticGuide/chapter08/jasmine/src/MyStorage.js'
                    ] // 入力(圧縮)ファイル名
                }
            }
        }
    });

// grunt-contrib-uglifyプラグインをロード
grunt.loadNpmTasks('grunt-contrib-uglify');
// defaultタスクにuglifyを登録
grunt.registerTask('default', [ 'uglify' ]);
};