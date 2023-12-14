<template>
  <div>
    <el-container>
      <el-aside :width="asideWidth">
        <div style="height: 60px; line-height: 60px; font-size: 20px; display: flex; align-items: center; justify-content: center">
          <img src="../assets/images/logo1.png" style="width: 30px;" alt="">
          <span class="logo-title" v-show="!isCollapse">Honey2024</span>
        </div>
        <el-menu router :collapse="isCollapse" :collapse-transition="false" background-color="#001529"
                 active-text-color="#fff" text-color="rgba(255, 255, 255, 0.65)" :default-active="$route.path"
                 style="border: none">
          <el-menu-item index="/home">
            <i class="el-icon-s-home"></i>
            <span slot="title">系统首页</span>
          </el-menu-item>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i><span>信息管理</span></template>
            <el-menu-item index="/user">用户管理</el-menu-item>
            <el-menu-item index="/admin">管理员管理</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="height: 60px; line-height: 60px; display: flex; align-items: center; box-shadow: 2px 0 6px rgba(0, 21, 41, .35);">
          <i :class="collapseIcon" @click="handleCollapse" style="font-size: 26px"></i>
          <el-breadcrumb separator="/" style="margin-left: 20px">
            <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item :to="{ path: '/' }">课程管理</el-breadcrumb-item>
          </el-breadcrumb>

          <div style="flex: 1; display: flex; justify-content: flex-end; align-items: center">
            <i class="el-icon-quipping" @click="handleFullScreen" style="font-size: 25px"></i>
            <el-dropdown placement="bottom">
              <div style="display: flex; align-items: center; cursor: pointer">
                <img src="../assets/images/logo1.png" alt="" style="width: 40px; height: 40px; margin: 0 5px">
                <span>{{user.name}}</span>
              </div>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item>个人信息</el-dropdown-item>
                <el-dropdown-item>修改密码</el-dropdown-item>
                <el-dropdown-item><div @click="$router.push('/login')">退出登录</div></el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </div>
        </el-header>
      <el-main>
        <router-view/>
        </el-main>
      </el-container>
    </el-container>

  </div>
</template>

<script>

import user from "./manager/User.vue";

export default {
  name: 'Manager',
  computed: {
    user() {
      return user
    }
  },
  data() {
    return {
      isCollapse: false,
      asideWidth: '200px',
      collapseIcon: 'el-icon-s-fold'
    }
  },
  mounted() {

  },
  methods: {
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

