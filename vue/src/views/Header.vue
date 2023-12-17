<template>
    <div class="header">
        <div class="zuti">
            <img src="@/assets/images/logo.png" alt="" style="width: 40px;position: relative;top: 10px;">
            <span style="font-size: 20px;margin-left: 15px;color: white">智慧医疗</span>
        </div>
        <el-menu
                :default-active="$route.path" router
                class="el-menu-demo"
                mode="horizontal"
                background-color="dodgerblue"
                text-color="#fff"
                active-text-color="white">
            <el-menu-item index="/">首页</el-menu-item>
            <el-submenu index="2">
                <template slot="title">科室介绍</template>
                <el-menu-item index="/keshiIntroduction">科室介绍</el-menu-item>
                <el-menu-item index="/expert">专家介绍</el-menu-item>
            </el-submenu>

            <el-submenu index="3">
                <template slot="title">看病就诊</template>
                <el-menu-item index="/appointment">预约挂号</el-menu-item>
                <el-menu-item index="/record">就诊记录</el-menu-item>
                <el-menu-item index="3-3">检查结果</el-menu-item>
            </el-submenu>

            <el-menu-item index="/consult">在线咨询</el-menu-item>
            <el-menu-item index="/personal">个人中心</el-menu-item>

        </el-menu>
        <div class="header-right">
            <router-link to="/login" style="width: 40px;position: relative;top: 18px;margin-right: 15px;"
                         v-bind:style="{color:'white',textDecoration:'none'}">
                登录/注册
            </router-link>
            <el-dropdown-item @click.native="$router.push('/login')"><!--退出登录--></el-dropdown-item>
        </div>
    </div>

</template>

<script>
export default {
    data(){
        return{
            activeIndex:'/'
        }


    },
    created() {
        console.log(this.$route);
        this.activeIndex=this.$route.path;
    }
}


</script>

<style lang="less" scoped>
.header{
  display:flex;
  background: dodgerblue;
  color: white;
  .zuti,header-right{
    padding: 0 10px;
    line-height: 40px;

  }
  .el-menu-demo{
    flex: 1;
  }

}
.login-avatar-container{
  display: flex;/* 允许元素在同一行显示 */
  align-items: center;/* 垂直居中 */
}
</style>


