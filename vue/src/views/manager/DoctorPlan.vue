<template>
  <div>
    <div>
      <el-input placeholder="请输入用户名" style="width: 200px;margin: 10px" v-model="username"></el-input>
      <el-input placeholder="请输入名字" style="width: 200px;margin: 10px" v-model="name"></el-input>
      <el-button type="success" icon="el-icon-search" label="width:15px" plain @click="load(1)">查询</el-button>
      <el-button type="primary" icon="el-icon-delete"  label="width:15px" plain @click="reset">清空</el-button>
      <el-button type="primary" plain @click="handleAdd">新增</el-button>
    </div>
    <div style="margin: 10px 10px">
      <el-button type="danger" plain @click="delBatch">批量删除</el-button>
    </div>
    <el-table :data="tableData" stripe :header-cell-style="{ backgroundColor: 'aliceblue', color: '#666' }" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"></el-table-column>
      <el-table-column prop="id" label="序号" width="70" align="center"></el-table-column>
      <el-table-column prop="doctorName" label="医生姓名"></el-table-column>
      <el-table-column prop="departmentName" label="科室名称"></el-table-column>
      <el-table-column prop="num" label="就诊数量"></el-table-column>
      <el-table-column prop="week" label="周几"></el-table-column>
      <el-table-column label="操作" align="center" width="180">
        <template v-slot="scope">
          <el-button size="mini" type="primary" plain @click="handleEdit(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" plain @click="del(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

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
      <el-form :model="form" label-width="90px" style="padding-right: 20px" :rules="rules" ref="formRef">
        <el-form-item label="请选择医生" prop="doctor_id" width="70">
          <el-select v-model="form.department_id" placeholder="请选择医生" style="width: 100%">
            <el-option
                v-for="item in doctorData"
                :key="item.id"
                :label="item.name"
                :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="看病人数" prop="num">
          <el-input v-model="form.num" placeholder="请输入看病人数"></el-input>
        </el-form-item>
        <el-form-item  prop="week" label="选择周几">
          <el-select v-model="form.week" placeholder="请选择周几" style="width: 100%">
            <el-option label="星期一" value="星期一"></el-option>
            <el-option label="星期二" value="星期二"></el-option>
            <el-option label="星期三" value="星期三"></el-option>
            <el-option label="星期四" value="星期四"></el-option>
            <el-option label="星期五" value="星期五"></el-option>
            <el-option label="星期六" value="星期六"></el-option>
            <el-option label="星期日" value="星期日"></el-option>
          </el-select>
        </el-form-item>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button @click="fromVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>


  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "DoctorPlan",
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
      user: JSON.parse(localStorage.getItem('doctor') || '{}'),
      rules: {
        username: [
          { required: true, message: '请输入账号', trigger: 'blur' },
        ]
      },
      ids: []
    }
  },
  created() {
    this.load(),
        this.doctorData()
  },
  methods: {
    doctorData(){
        request.get('/Doctor/selectAll').then(res=>{
          if (res.code === '200'){
            this.doctorData=res.data
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