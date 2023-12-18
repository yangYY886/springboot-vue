<template>
  <div>
    <div>
      <el-input placeholder="请输入标题" style="width: 200px;margin: 10px" v-model="title"></el-input>
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
      <el-table-column prop="title" label="标题"></el-table-column>
      <el-table-column prop="description" label="简介"></el-table-column>
      <el-table-column prop="content" label="内容"></el-table-column>
      <el-table-column prop="time" label="发布时间"></el-table-column>
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
          :page-size="pageSize"
          layout="total, prev, pager, next"
          :total="total">
      </el-pagination>
    </div>

    <el-dialog title="请填写信息" :visible.sync="fromVisible" width="30%">
      <el-form :model="form" label-width="80px" style="padding-right: 20px" :rules="rules" ref="formRef">
        <el-form-item label="标题" prop="title">
          <el-input v-model="form.title" placeholder="标题"></el-input>
        </el-form-item>
        <el-form-item label="简介" prop="description">
          <el-input v-model="form.description" placeholder="简介"></el-input>
        </el-form-item>
        <el-form-item label="内容" prop="content">
          <el-input v-model="form.content" placeholder="内容"></el-input>
        </el-form-item>
        <el-form-item label="时间" prop="time">
          <el-input v-model="form.time" placeholder="时间"></el-input>
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
  name: "News",
  data() {
    return {
      tableData: [],  // 所有的数据
      pageNum: 1,   // 当前的页码
      pageSize: 5,  // 每页显示的个数
      title: '',
      news: JSON.parse(localStorage.getItem('news') || '{}'),
      total: 0,
      fromVisible: false,
      form: {},
      rules: {
        title: [
          { required: true, message: '请输入输入标题', trigger: 'blur' },
        ]
      },
      ids: []
    }
  },
  created() {
    this.load()
  },
  methods: {
    delBatch() {
      if (!this.ids.length) {
        this.$message.warning('请选择数据')
        return
      }
      this.$confirm('您确认批量删除这些数据吗？', '确认删除', {type: "warning"}).then(response => {
        request.delete('/News/delete/batch', {data: this.ids}).then(res => {
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
        request.delete('/News/delete/'+ id).then(res => {
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
            url: this.form.id ? '/News/update' : '/News/add',
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
      this.title = ''
      this.load()
    },
    load(pageNum) {  // 分页查询
      if (pageNum) this.pageNum = pageNum
      request.get('/News/selectByPage', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          title: this.title,
          total: this.total
        }
      }).then(res => {
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    handleCurrentChange(pageNum) {
      this.load(pageNum)
    }
  }
}
</script>

<style scoped>

</style>