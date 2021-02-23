/*
メインスレッド・・・
JavaScript実行とレンダリング(画面描写処理)実行
FPS・・・1秒あたりの画面(フレーム)更新頻度
->60FPSの場合、JavaScriptが重い処理(16.7ms以上)
だと、レンダリングされなくなる。
同期処理・・・
メインスレッドでコードが順番に実行される。
1つの処理でが完了するまで次の処理には進まない。
非同期処理・・・
一時的にメインスレッドから処理が切り離される。
*/
function sleep(ms) {
  const startTime = new Date();
  while (new Date() - startTime < ms);
  console.log('sleep done');
}

const btn = document.querySelector('button');
btn.addEventListener('click', function(){
  console.log('button clicked');
});
setTimeout(function() {
  sleep(3000)
}, 2000)
//->setTimOutにより非同期処理として2秒後にsleep
//  が実行されるので、2秒間は画面更新入力可能

/*
非同期処理
->非同期API
  setTimeOut, Promise, queueMicrotask, etc...
->UIイベント
  クリック, etc...
->NWイベント
->I/Oイベント
*/