<template>
    <div class="center-container">
        <el-card style="width: 40%;height: 400px;">
            <h3>修改密码</h3>
            <el-form ref="formRef" :model="user" :rules="rules" label-width="80px" style="padding-right: 20px; background-color: rgba(255, 255, 255, 0.8);">
                <el-form-item label="原始密码" prop="password" style="margin-bottom: 35px;margin-top: 30px;">
                    <el-input show-password v-model="user.password" placeholder="原始密码"></el-input>
                </el-form-item>
                <el-form-item label="新密码" prop="newPassword" style="margin-bottom: 35px;">
                    <el-input show-password v-model="user.newPassword" placeholder="新密码"></el-input>
                </el-form-item>
                <el-form-item label="确认密码" prop="confirmPassword" style="margin-bottom: 35px;">
                    <el-input show-password v-model="user.confirmPassword" placeholder="确认密码"></el-input>
                </el-form-item>
                <div style="text-align: center; margin-bottom: 20px">
                    <el-button type="primary" @click="update">确认修改</el-button>
                </div>
            </el-form>
        </el-card>
    </div>
</template>

<script>
export default {
    name: "Password",
    data() {
        const validatePassword = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请确认密码'))
            } else if (value !== this.user.newPassword) {
                callback(new Error('确认密码错误'))
            } else {
                callback()
            }
        }
        return {
            user: JSON.parse(localStorage.getItem('honey-user') || '{}'),
            rules: {
                password: [
                    { required: true, message: '请输入原始密码', trigger: 'blur' },
                ],
                newPassword: [
                    { required: true, message: '请输入新密码', trigger: 'blur' },
                ],
                confirmPassword: [
                    { validator: validatePassword, required: true, trigger: 'blur' },
                ],
            }
        }
    },
    created() {
    },
    methods: {
        update() {
            this.$refs.formRef.validate((valid) => {
                if (valid) {
                    this.user.password = this.user.newPassword
                    // 保存当前的用户信息到数据库
                    this.$request.put('/user/update', this.user).then(res => {
                        if (res.code === '200') {
                            // 成功更新
                            this.$message.success('保存成功')
                            this.$router.push('/login')
                        } else {
                            this.$message.error(res.msg)
                        }
                    })
                }
            })
        },
    }
}
</script>

<style scoped>
.center-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 70vh;
    min-height: 100vh;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    background-image: url("@/assets/images/01.png");
}

/deep/.el-form-item__label {
    font-weight: bold;
}
h3 {
    text-align: center;
    margin-top: 30px;
}
</style>