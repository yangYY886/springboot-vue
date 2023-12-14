
<template>
  <div>
    <div style="margin-bottom: 15px">
      <el-input v-model="input" style="width:200px" placeholer="请输入内容" suffix-icon="el-icon-search"></el-input>
      <el-button type="warning" style="margin-left:10px" >查询</el-button>
      <el-button type="primary">新增<i class="el-icon-circle-plus-outline"></i></el-button>
      <el-button type="primary">导入<i class="el-icon-bottom"></i></el-button>
      <el-button type="primary">导出<i class="el-icon-top"></i></el-button>
    </div>
    <div>
      <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="id" label="序号" width="50">
        </el-table-column>
        <el-table-column prop="username" label="用户" width="120">
        </el-table-column>
        <el-table-column prop="password" label="密码" width="130"></el-table-column>
        <el-table-column prop="phone" label="电话" width="180"></el-table-column>
        <el-table-column prop="email" label="邮箱" width="100"></el-table-column>
        <el-table-column prop="address" label="地址" width="100"></el-table-column>
        <el-table-column  label="操作">
          <el-button type="success">编辑 <i class="el-icon-edit"></i></el-button>
          <el-button type="danger">删除 <i class="el-icon-remove-out"></i></el-button>
        </el-table-column>

      </el-table>
    </div>
    <!--    <div style="margin-top: 10px">-->
    <!--      <el-pagination-->
    <!--          @size-change="handleSizeChange"-->
    <!--          @current-change="handleCurrentChange"-->
    <!--          :current-page="currentPage4"-->
    <!--          :page-sizes="[10, 20, 30, 40]"-->
    <!--          :page-size="100"-->
    <!--          layout="total, sizes, prev, pager, next, jumper"-->
    <!--          :total="40">-->
    <!--      </el-pagination>-->
    <!--    </div>-->
  </div>
</template>

<style scoped>

</style>
<script>
import request from "@/utils/request";
export default {
  name: "Manager",
  data() {
    return {
      input: null,  // 初始化你的 'input' 属性
      tableData: []
    }
  },
  //页面加载的时候，做一些事情，在create里面
  created() {
    this.load();
  },
  //定义一些页面上控件触发的事件调用的方法
  methods:{
    load(){
      request.get("/admin/selectAll").then(res=>{
        if(res.code==='0'){
          this.tableData=res.data
        }
      })
    }
  },
}
</script>