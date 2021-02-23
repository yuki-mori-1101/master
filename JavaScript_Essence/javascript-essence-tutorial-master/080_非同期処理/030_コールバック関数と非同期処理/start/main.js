function a() {
  setTimeout(function task1() { 
    console.log('task1 done');
    b();
  });
  //待機秒数は指定されていないが、タスクキューを
  //経由して実行される為にコールスタックが無くなる
  //までは実行が待機される
  console.log('fn a done');
}

function b() {
  console.log('fn b done');
}

a();

// b();