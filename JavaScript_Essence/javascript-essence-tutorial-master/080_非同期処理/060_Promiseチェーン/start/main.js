/*
プロミスチェーン・・・
Promiseを使用して非同期処理を順々実行すること
*/
function sleep(val) {
  return new Promise(function(resolve) {
    setTimeout(function() {
      console.log(val++);
      resolve(val);
    }, 1000);
  });
}

sleep(0).then( val => {
  return sleep(val);
}).then( val =>  {
  return sleep(val);
}).then( val => {
  return sleep(val);
}).then( val => {
  return sleep(val);
})