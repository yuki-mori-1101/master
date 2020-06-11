
let timer = () => {
    const now = new Date();
    document.getElementById('timer').innerHTML =
    `${now.getHours()}：${now.getMinutes()}：${now.getSeconds()}`;
}
// setInterval(関数, 処理間隔);
// letでなくvarにしている理由は、start_btn押下した後にstop_btn押下しても停止させるため
var timerID = setInterval(timer, 500);

// 以下コードでは、2回以上start_btn押下後にstop_btn押下しても停止しない。。。。。
const start_btn = document.getElementById('start_btn');
const stop_btn = document.getElementById('stop_btn');
// 時計表示を開始する
start_btn.addEventListener('click', () => {
    timerID = setInterval(timer, 500);
});
// 時計表示を停止する
stop_btn.addEventListener('click', () => {
    clearInterval(timerID);
});