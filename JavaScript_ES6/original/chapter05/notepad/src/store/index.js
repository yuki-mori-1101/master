import Vue from 'vue'
import Vuex from 'vuex'
import createdPersistedState from 'vuex-persistedstate'

// vuexを使用できるようにする
Vue.use(Vuex)

/*
storeは、ブラウザの再読み込みで消える。
再読み込みしても消えないためには、サーバーサイドプログラムを使って、
DBやファイルに保存しておかなければならない。
*/

//  vuexのデータを保存する機能(store)のオブジェクトをexportする
export default new Vuex.Store({
    plugins: [createdPersistedState()],
    // state -> 記録するためのデータ
    state: {
        memos: [
            { id: 1, body: 'サンプルです'}
        ]
    },
    // データを保存する処理
    mutations: {
        // vuexでは、メソッドでなくハンドラと呼ぶ
        save(state, memo) {
            var max = state.memos[state.memos.length - 1].id;
            memo.id = max + 1;
            state.memos.push(memo);
        },
        update(state, data) {
            let x = state.memos.find(memo => memo.id == data.id);
            x.body = data.body;
        }
    }
})