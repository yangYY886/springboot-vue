
<template>
  <div>首页</div>
</template>
<script>
export default {
  name: "Home",
  data(){
    return{
      user:JSON.parse(localStorage.getItem('honey-user') || '{}'),
    }
  },
  created() {
  },
  methods:{}
}
</script>
<style scope>

</style>