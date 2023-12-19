<template>
  <div>
    <div>
      <el-input placeholder="请输入科室名称" style="width: 200px;margin: 10px" v-model="depart"></el-input>
      <el-input placeholder="请输入星期.." style="width: 200px;margin: 10px" v-model="week"></el-input>
      <el-button type="success" icon="el-icon-search" label="width:15px" plain @click="load(1)">查询</el-button>
      <el-button type="primary" icon="el-icon-delete"  label="width:15px" plain @click="reset">清空</el-button>
      <el-button type="danger" plain @click="handleAdd">进行预约</el-button>
    </div>
   <div class="table" style="padding: 15px 20px">
      <el-row :gutter="20">
        <el-col :span="8" v-for=" item in tableData "   :key="item.id" style="margin-bottom: 20px">
          <div style="text-align:center;background-color: #f1d9db" class="card">
            <img src="@/assets/images/tx.png" alt="" style="width: 100px;heigth:100px; border-radius: 50%">
            <div style="font-weight:550;margin-top: 10px">
              {{item.name}} <span style="margin-left: 5px;font-weight: 500">部门：{{item.depart}}</span>
            </div>
            <div style="font-weight:550;margin-top: 10px">
              <span style="margin-left: 5px;font-weight: 500">职位：{{item.position}}</span> <span style="margin-left: 5px;font-weight: 500">值班时间：{{item.week}}</span>
            </div>
            <div style="margin-top: 20px;color: #6d6de3;padding: 0 10px; text-align: left;overflow: hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-box-orient: vertical; -webkit-line-clamp: 4">
              简介：{{item.description}}
            </div>
            <div>
              挂号费：<span style="margin-left: 5px;font-weight: 500">{{item.price}}</span>
            </div>
          </div>
        </el-col>
      </el-row>
   </div>

    <div style="margin: 10px 0">
      <el-pagination
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[5, 10, 15, 20]"
          :page-size="pageSize"
          layout="total, prev, pager, next"
          :total="total">
      </el-pagination>
    </div>

    <el-dialog title="请填写信息" :visible.sync="fromVisible" width="30%">
      <el-form :model="form" label-width="80px" style="padding-right: 20px" :rules="rules" ref="formRef">
        <el-form-item label="医生名字" prop="doctor">
          <el-select v-model="form.doctor" placeholder="请选择医生名称" style="width: 100%">
            <el-option
                v-for="item in doctorDate"
                :key="item.id"
                :label="item.name"
                :value="item.name">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item  label="科室" prop="depart" >
          <el-select v-model="form.depart" placeholder="请选择科室名称" style="width: 100%">
            <el-option
                v-for="item in departDate"
                :key="item.id"
                :label="item.name"
                :value="item.name">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="预约时间" prop="weeks">
          <el-select v-model="form.weeks" placeholder="请选择预约时间" style="width: 100%">
            <el-option
                v-for="item in weeksDate"
                :key="item.id"
                :label="item.week"
                :value="item.week">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="年龄"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-input v-model="form.sex" placeholder="性别"></el-input>
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="form.phone" placeholder="电话"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="邮箱"></el-input>
        </el-form-item>
        <el-form-item label="病情" prop="cases">
          <el-input type="textarea" v-model="form.cases" placeholder="病情"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="fromVisible = false">取消预约</el-button>
        <el-button type="primary" @click="save">确定预约</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Doctor",
  data() {
    return {
      tableData: [],  // 所有的数据
      pageNum: 1,   // 当前的页码
      pageSize: 5,  // 每页显示的个数
      depart: '',
      week: '',
      total: 0,
      fromVisible: false,
      doName:'',
      deName:'',
      weeks:'',
      form: {},
      ids: [],
      departDate:[],
      doctorDate:[],
      weeksDate:[],
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
        ],
        name: [
          { required: true, message: '请输入名字', trigger: 'blur' },
        ],
        cases: [
          { required: true, message: '请输入病情', trigger: 'blur' },
        ],
        phone: [
          { required: true, message: '请输入电话', trigger: 'blur' },
        ]
      },
    }
  },
  created() {
    this.load()
    this.loadDepartment()
    this.loadDoctor()
    this.loadWeeks()
  },
  methods: {
    loadDepartment(){
      request.get('/Department/selectAll').then(res=>{
        if (res.code === '200'){
          this.departDate=res.data
        }else {
          this.$message.error(res.msg)
        }
      })
    },
    loadWeeks(){
  request.get('/Doctor/selectAll').then(res=>{
    if (res.code === '200'){
      this.weeksDate=res.data
    }else {
      this.$message.error(res.msg)
    }
  })
},
    loadDoctor(){
      request.get('/Doctor/selectAll').then(res=>{
        if (res.code === '200'){
          this.doctorDate=res.data
        }else {
          this.$message.error(res.msg)
        }
      })
    },

    handleAdd() {   // 新增数据
      this.form = {}  // 新增数据的时候清空数据
      this.fromVisible = true   // 打开弹窗
    },
    save() {   // 保存按钮触发的逻辑  它会触发新增或者更新
      this.$refs.formRef.validate((valid) => {
        if (valid) {
          request({
            url: this.form.id ? '/Appointment/update' : '/Appointment/add',
            method: this.form.id ? 'PUT' : 'POST',
            data: this.form
          }).then(res => {
            if (res.code === '200') {  // 表示成功保存
              this.$message.success('预约已申请，可在个人中心查看自己的预约记录')
              this.load(1)
              this.fromVisible = false
            } else {
              this.$message.error(res.msg)  // 弹出错误的信息
            }
          })
        }
      })
    },
    reset() {
      this.depart = ''
      this.week = ''
      this.load()
    },
    load(pageNum) {  // 分页查询
      if (pageNum) this.pageNum = pageNum
      request.get('/Doctor/selectByPageL', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          depart: this.depart,
          week: this.week,
          total: this.total
        }
      }).then(res => {
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    handleCurrentChange(pageNum) {
      this.load(pageNum)
    },
  }
}
</script>

<style scoped>
/*
.doctorCard-container{
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    min-height: 100vh;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    background-image: url("@/assets/images/images01.png");
}

 */
</style>