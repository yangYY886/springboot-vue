<template>
  <div>
    <el-container>
      <el-aside :width="asideWidth">
        <div style="height: 70px; line-height: 70px; font-size: 20px; display: flex; align-items: center; justify-content: center">
          <!--<img src="../assets/images/logo.jpg" style="width:70px;" alt="">-->
          <img src="../assets/images/logo.jpg" alt="" style="width: 70px; height: 70px; border-radius:50%;margin: 0 5px">

          <span class="logo-title" v-show="!isCollapse">欢迎管理员</span>
        </div>
        <el-menu router :collapse="isCollapse" :collapse-transition="false" background-color="#001529"
                 active-text-color="#fff" text-color="rgba(255, 255, 255, 0.65)" :default-active="$route.path"
                 style="border: none">
          <el-menu-item index="/home">
            <i class="el-icon-s-home"></i>
            <span slot="title">系统首页</span>
          </el-menu-item>
          <el-submenu index="/home">
            <template slot="title"><i class="el-icon-menu"></i><span>信息管理</span></template>
            <el-menu-item index="/user">用户信息</el-menu-item>
          </el-submenu>
          <el-submenu index="/home">
            <template slot="title"><i class="el-icon-menu"></i><span>医生管理</span></template>
            <el-menu-item index="/doctor">医生信息</el-menu-item>
          </el-submenu>
          <el-submenu index="/home">
            <template slot="title"><i class="el-icon-menu"></i><span>科室管理</span></template>
            <el-menu-item index="/department">科室信息</el-menu-item>
          </el-submenu>
          <el-submenu index="/home">
            <template slot="title"><i class="el-icon-menu"></i><span>预约管理</span></template>
            <el-menu-item index="/doctorcard">进行预约</el-menu-item>
            <el-menu-item index="/audting">预约审核</el-menu-item>
            <el-menu-item index="/record">预约记录</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-container>
        <el-header style="height: 70px; line-height: 70px; display: flex; align-items: center; box-shadow: 2px 0 6px rgba(0, 21, 41, .35);">
          <i :class="collapseIcon" @click="handleCollapse" style="font-size: 26px"></i>

          <div style="flex: 1; display: flex; justify-content: flex-end; align-items: center">
            <i class="el-icon-quipping" @click="handleFullScreen" style="font-size: 25px"></i>
            <el-dropdown placement="bottom">
              <div style="display: flex; align-items: center; cursor: pointer">
                <!--<img src="../assets/images/logo.jpg" alt="" style="width: 70px; height: 70px; margin: 0 5px">-->
                <img src="../assets/images/logo.jpg" alt="" style="width: 70px; height: 70px; border-radius:50%;margin: 0 5px">

                <span>{{user.name}}</span>
              </div>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item><div @click="$router.push('/person')">个人信息</div></el-dropdown-item>
                <el-dropdown-item @click="$router.push('/password')">修改密码</el-dropdown-item>
                <el-dropdown-item><div @click="$router.push('/login')">退出登录</div></el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
        </el-header>
      <el-main>
        <router-view @update:user="updateUser"/>
        </el-main>
      </el-container>
    </el-container>

  </div>
</template>

<script>

import user from "./manager/User.vue";
import User from "@/views/manager/User.vue";

export default {
  name: 'Manager',
  computed: {
    User() {
      return User
    },
    user() {
      return user
    }
  },
  data() {
    return {
      isCollapse: false,
      asideWidth: '200px',
      collapseIcon: 'el-icon-s-fold',
      user:JSON.parse(localStorage.getItem('honey-user')||'{}'),
    }
  },
  mounted() {   //页面加载完成后触发

  },
  methods: {
    updateUser(user){
      this.User=JSON.parse(JSON.stringify(user))  //让父级对象与子级对象毫无关联
    },
    handleFullScreen() {
      document.documentElement.requestFullscreen()
    },
    handleCollapse() {
      this.isCollapse = !this.isCollapse
      this.asideWidth = this.isCollapse ? '64px' : '200px'
      this.collapseIcon = this.isCollapse ? 'el-icon-s-unfold' : 'el-icon-s-fold'
    }
  }
}
</script>

<style>
.el-menu--inline, .el-menu-item {
    background-color: #000c17 !important;
}

.el-submenu__title {
    height: 40px !important;
    line-height: 40px !important;
    padding: 0 25px !important;
    transition: color 0s;
}
.el-menu--collapse .el-submenu__title {
    padding: 0 20px !important;
}
.el-submenu__title>i:nth-child(1) {
    margin-top: 2px;
}
.el-submenu__title>i.el-submenu__icon-arrow {
    margin-top: -5px;
}
.el-menu-item {
    min-width: 0 !important;
    width: calc(100% - 10px);
    margin: 5px;
    height: 40px !important;
    line-height: 40px !important;
    border-radius: 5px;
}
.el-menu--inline>.el-menu-item {
    padding-left: 50px !important;
}
.el-menu-item.is-active {
    background-color: dodgerblue !important;
}

.el-menu-item:hover {
    color: #fff !important;
}

.el-submenu__title:hover *, .el-submenu__title:hover {
    color: #fff !important;
}

.el-aside {
    box-shadow: 2px 0 6px rgba(0, 21, 41, .35);
    background-color: #001529;
    color: #fff;
    min-height: 100vh;

}
.el-menu--collapse .el-tooltip {
    padding: 0 15px !important;
}
.logo-title {
    margin-left: 5px;

}
.el-menu {
    transition: all .3s;
}

.header{
    display:flex;
    background: dodgerblue;
    color: white;
}
.zuti,header-right{
    padding: 0 10px;
    line-height: 40px;

}
.el-menu-demo{
    flex: 1;
}
.login-avatar-container{
    display: flex;/* 允许元素在同一行显示 */
    align-items: center;/* 垂直居中 */
}

</style>