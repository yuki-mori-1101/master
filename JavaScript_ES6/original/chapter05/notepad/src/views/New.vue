<template>
    <div class="editor">
    <Header>New Memos</Header>
        <textarea name ="memo" v-model="memobody"></textarea>
        <button @click="save">保存</button>
    </div>
</template>

<script>
import Header from "@/components/Header.vue"
export default {
  name: 'new',
  components: {
      Header
  },
  data: function() {
    return {
        memobody: ""
    }
  },
  methods: {
      save: function() {
          this.$store.commit("save", {
              body: this.memobody
          });
          this.$router.push("/");
      }
  }
}
</script>