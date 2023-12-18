
<template>
  <div>
    <div style="background-color: #f1d9db">
      <span>欢迎来到后台管理</span>
    </div >
    <img src="@/assets/images/syLogo.png" >
  </div>
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