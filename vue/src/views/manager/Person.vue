<script>
export default {
  name: "Person",
  data() {
    return {

      user: JSON.parse(localStorage.getItem('user') || '{}')
    }
  },
  created() {

  },
  methods:{
    updated(){

    },
    load(){
    }
  }
}
</script>

<template>
  <div>
    <el-card>
      <el-form  :model="user" label-width="80px">
        <div>
          <el-upload
              class="avatar-uploader"
              action="https://localhost:9090/file/upload"
              :headers="{token:user.token}"
              :show-file-list="false"
              :on-success="handleAvatarSuccess">
            <img v-if="user.avatar" :src="user.avatar" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </div>
        <el-form-item label="活动名称">
          <el-input  v-model="user.username" placeholder="用户名" disabled></el-input>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="user.name" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item label="电话">
          <el-input v-model="user.phone" placeholder="用户名" ></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="user.emial" placeholder="邮箱"></el-input>
        </el-form-item>
        <div>  <el-button type="danger" round @click="updated">保存</el-button></div>
      </el-form>
    </el-card>

  </div>
</template>

<style>

</style>