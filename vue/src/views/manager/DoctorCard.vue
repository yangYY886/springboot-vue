<template>
  <div>
    <div>
      <el-input placeholder="请输入用户名" style="width: 200px;margin: 10px" v-model="username"></el-input>
      <el-input placeholder="请输入名字" style="width: 200px;margin: 10px" v-model="name"></el-input>
      <el-button type="success" icon="el-icon-search" label="width:15px" plain @click="load(1)">查询</el-button>
      <el-button type="primary" icon="el-icon-delete"  label="width:15px" plain @click="reset">清空</el-button>
    </div>
   <div class="table" style="padding: 15px 20px">
      <el-row :gutter="20">
        <el-col :span="8" v-for=" item in tableData "   :key="item.id" style="margin-bottom: 20px">
          <div style="text-align:center;background-color: #f1d9db" class="card">
            <img src="@/assets/images/tx.png" alt="" style="width: 100px;heigth:100px; border-radius: 50%">
            <div style="font-weight:550;margin-top: 10px">
              {{item.name}} {{item.posiiton}}<span style="margin-left: 5px;font-weight: 500">职位：{{item.position}}</span>
            </div>
            <div style="margin-top: 20px;color: #6d6de3;padding: 0 10px; text-align: left;overflow: hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-box-orient: vertical; -webkit-line-clamp: 4">
              简介：{{item.description}}
            </div>
            <div>
              挂号费：{{item.posiiton}}<span style="margin-left: 5px;font-weight: 500">{{item.price}}</span>
            </div>
            <div style="margin-top: 15px">
              <el-button type="primary" size="mini">挂号</el-button>
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
      username: '',
      name: '',
      total: 0,
      fromVisible: false,
      form: {},
      doctor: JSON.parse(localStorage.getItem('doctor') || '{}'),
      ids: [],
      departmentDate:[]
    }
  },
  created() {
    this.load()
    this.loadDepartment()
  },
  methods: {
    loadDepartment(){
      request.get('/Department/selectAll').then(res=>{
        if (res.code === '200'){
          this.departmentDate=res.data
        }else {
          this.$message.error(res.msg)
        }
      })
    },
    delBatch() {
      if (!this.ids.length) {
        this.$message.warning('请选择数据')
        return
      }
      this.$confirm('您确认批量删除这些数据吗？', '确认删除', {type: "warning"}).then(response => {
        request.delete('/Doctor/delete/batch', {data: this.ids}).then(res => {
          if (res.code === '200') {   // 表示操作成功
            this.$message.success('操作成功')
            this.load(1)
          } else {
            this.$message.error(res.msg)  // 弹出错误的信息
          }
        })
      }).catch(() => {
      })
    },
    handleSelectionChange(rows) {   // 当前选中的所有的行数据
      this.ids = rows.map(v => v.id)
    },
    del(id) {
      this.$confirm('您确认删除吗？', '确认删除', {
        type: "warning"}).then(response => {
        request.delete('/Doctor/delete/' + id).then(res => {
          if (res.code === '200') {   // 表示操作成功
            this.$message.success('删除成功')
            this.load(1)
          } else {
            this.$message.error(res.msg)  // 弹出错误的信息
          }
        })
      }).catch(() => {
      })
    },
    handleEdit(row) {   // 编辑数据
      this.form = JSON.parse(JSON.stringify(row))  // 给form对象赋值  注意要深拷贝数据
      this.fromVisible = true   // 打开弹窗
    },
    handleAdd() {   // 新增数据
      this.form = {}  // 新增数据的时候清空数据
      this.fromVisible = true   // 打开弹窗
    },
    save() {   // 保存按钮触发的逻辑  它会触发新增或者更新
      this.$refs.formRef.validate((valid) => {
        if (valid) {
          request({
            url: this.form.id ? '/Doctor/update' : '/Doctor/add',
            method: this.form.id ? 'PUT' : 'POST',
            data: this.form
          }).then(res => {
            if (res.code === '200') {  // 表示成功保存
              this.$message.success('保存成功')
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
      this.username = ''
      this.name = ''
      this.load()
    },
    load(pageNum) {  // 分页查询
      if (pageNum) this.pageNum = pageNum
      request.get('/Doctor/selectByPage', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          username: this.username,
          name: this.name,
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

</style>