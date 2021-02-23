// function sleep(val) {
//   return new Promise(function(resolve) {
//     setTimeout(function() {
//       console.log(val++);
//       resolve(val);
//     }, val * 500);
//   });
// }

// Promise.all([sleep(2), sleep(3), sleep(4)]).then(function(data) {
//   console.log(data);
// });
//->引数には、Promiseインスタンスをreturnするものを格納した反復可能オブジェクト
//   反復可能オブジェクト全部実行してから、thenメソッドが実行される  

// sleep(0).then(function(val) {//->直列
//   return Promise.all([sleep(2), sleep(3), sleep(4)])//->並列
// }).then(function(val) {//->直列
//   console.log(val);//->直列
//   return sleep(val);//->直列
// }).then(function(val) {//->直列
//   return sleep(val);//->直列
// })

// Promise.race([sleep(2), sleep(3), sleep(4)]).then(function(data) {
//   console.log(data);
// });
//->引数には、Promiseインスタンスをreturnするものを格納した反復可能オブジェクト
//   反復可能オブジェクトの内のどれか一つが実行完了したら、thenメソッド実行

// Promise.allSettled([sleep(2), sleep(3), sleep(4)]).then(function(data) {
//   console.log(data);
// });
//->引数には、Promiseインスタンスをreturnするものを格納した反復可能オブジェクト
//   反復可能オブジェクト全部実行完了したら、thenメソッド実行するが、
//   resolve, rejectメソッドが実行されたかどうかまで分からない
//   resolveが実行->status:fullfilled, rejectが実行->status:rejected

function sleep1(val) {
  return new Promise(function(resolve, reject) {
    setTimeout(function() {
      console.log(val++);
      reject(val);
    }, val * 500);
  });
}
// Promise.all([sleep1(2), sleep1(3), sleep1(4)]).then(function(data) {
//   console.log(data);
// }).catch(function(e) {
//   console.error(e);
// });
//->allメソッドは、reject呼出時にはcatchブロック内に処理が入る

Promise.allSettled([sleep1(2), sleep1(3), sleep1(4)]).then(function(data) {
  console.log(data);
}).catch(function(e) {
  console.error(e);
});
//->allSettledメソッドは、reject呼出時にもcatchブロック内に処理が入らない