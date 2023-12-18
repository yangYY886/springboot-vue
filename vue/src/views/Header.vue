
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

            <el-menu-item index="/userAppointment">预约挂号</el-menu-item>


            <el-menu-item index="/adminManager">后台管理</el-menu-item>
            <el-submenu index="5">
                <template slot="title">个人中心</template>
                <el-menu-item index="/userPerson">个人信息</el-menu-item>
                <el-menu-item index="/record">预约记录</el-menu-item>
                <el-menu-item index="/userPassword">修改密码</el-menu-item>
                <el-menu-item index="/login">退出登录</el-menu-item>
            </el-submenu>
        </el-menu>
        <div class="header-right">
            <router-link to="/login" style="width: 40px;position: relative;top: 18px;margin-right: 15px;"
                         v-bind:style="{color:'white',textDecoration:'none'}">
                登录/注册
            </router-link>
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



<!--<template>-->
<!--    <el-menu :default-active="active"-->

<!--             mode="horizontal"-->
<!--             background-color="#545c64"-->
<!--             text-color="#fff"-->
<!--             active-text-color="#ffd04b" style="display: flex">-->
<!--        <el-menu-item index="/index">首页</el-menu-item>-->
<!--        <el-menu-item index="/news">新闻</el-menu-item>-->
<!--        <el-menu-item index="tice">公告</el-menu-item>-->
<!--        <el-menu-item index="/person">个人中心</el-menu-item>-->
<!--        <el-menu-item index="/manager">后台管理</el-menu-item>-->
<!--    </el-menu>-->
<!--</template>-->
<!--<script>-->
<!--export default {-->

<!--    data(){-->
<!--        return {-->
<!--            active:"1"-->
<!--        }-->
<!--    }-->
<!--}-->
<!--</script>-->


