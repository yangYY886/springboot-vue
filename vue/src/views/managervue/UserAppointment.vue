<template>
    <div class="appointment-container">
        <div class="appointment-box">
            <!--<h2>预约挂号</h2>-->
            <div class="appointment">
                <div class="appointment-wraper"></div>
                <div class="appointment-content centered-form">
                    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                        <el-form-item label="姓名" prop="name">
                            <el-input v-model="ruleForm.name"></el-input>
                        </el-form-item>
                        <el-form-item label="性别">
                            <el-input v-model="ruleForm.gender"></el-input>
                        </el-form-item>
                        <el-form-item label="年龄">
                            <el-input v-model="ruleForm.age"></el-input>
                        </el-form-item>
                        <el-form-item label="联系电话">
                            <el-input v-model="ruleForm.tel"></el-input>
                        </el-form-item>
                        <el-form-item label="预约科室">
                            <el-select v-model="ruleForm.keshi" placeholder="请选择预约的科室">
                                <el-option label="儿科" value="儿科"></el-option>
                                <el-option label="眼科" value="眼科"></el-option>
                                <el-option label="骨科" value="骨科"></el-option>
                                <el-option label="皮肤科" value="皮肤科"></el-option>
                                <el-option label="妇产科" value="妇产科"></el-option>
                                <el-option label="神经科" value="神经科"></el-option>
                                <el-option label="肝胆外科" value="肝胆外科"></el-option>
                                <el-option label="急诊科" value="急诊科"></el-option>
                                <el-option label="口腔科" value="口腔科"></el-option>
                                <el-option label="整形烧伤科" value="整形烧伤科"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="预约医生">
                            <el-select v-model="ruleForm.doctor" placeholder="请选择预约的医生">
                                <el-option label="徐晔" value="徐晔"></el-option>
                                <el-option label="钟南山" value="钟南山"></el-option>
                                <el-option label="李兰娟" value="李兰娟"></el-option>
                                <el-option label="李文亮" value="李文亮"></el-option>
                                <el-option label="张定宇" value="张定宇"></el-option>
                                <el-option label="顾方舟" value="顾方舟"></el-option>
                                <el-option label="艾芬" value="艾芬"></el-option>
                                <el-option label="张文宏" value="张文宏"></el-option>
                                <el-option label="吴尊友" value="吴尊友"></el-option>
                                <el-option label="张继先" value="张继先"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="预约时间" required>
                            <el-col :span="11">
                                <el-form-item prop="date1">
                                    <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.date1" style="width: 100%;"></el-date-picker>
                                </el-form-item></el-col>
                            <el-col class="line" :span="2">-</el-col>
                            <el-col :span="11">
                                <el-form-item prop="date2">
                                    <el-time-picker placeholder="选择时间" v-model="ruleForm.date2" style="width: 100%;"></el-time-picker>
                                </el-form-item></el-col>
                        </el-form-item>
                        <el-form-item label="病史" prop="history1">
                            <el-input type="textarea" v-model="ruleForm.history1"></el-input>
                        </el-form-item>
                        <el-form-item label="过敏史" prop="history2">
                            <el-input type="textarea" v-model="ruleForm.history2"></el-input>
                        </el-form-item>
                        <el-form-item size="large">
                            <el-button type="primary" @click="submitForm('ruleForm')">预约</el-button>
                            <el-button @click="resetForm('ruleForm')">取消</el-button>
                        </el-form-item>
                    </el-form>

                </div>

            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            ruleForm: {         //表单数据
                name: '',
                gender: '',
                age: '',
                tel: '',
                keshi: '',
                doctor:'',
                date1: '',
                date2: '',

                history1:'',
                history2:'',

            },
            rules: {
                name: [
                    { required: true, message: '请输入名字', trigger: 'blur' },
                ],
                gender: [
                    { required: true, message: '请输入性别', trigger: 'blur' },
                ],
                age: [
                    { required: true, message: '请输入年龄', trigger: 'blur' },

                ],
                tel: [
                    { required: true, message: '请输入联系电话', trigger: 'blur' },

                ],
                keshi: [
                    { required: true, message: '请选择预约科室', trigger: 'change' }
                ],
                doctor: [
                    { required: true, message: '请选择预约医生', trigger: 'change' }
                ],
                date1: [
                    { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
                ],
                date2: [
                    { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
                ],

                history1: [
                    { required: true, message: '请填写病史', trigger: 'blur' }
                ],
                history2: [
                    { required: true, message: '请填写过敏史', trigger: 'blur' }
                ]
            }
        };
    },
    methods: {
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    alert('submit!');
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        }
    }
}

</script>

<style scoped>
.centered-form {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh; /* 使表单占满整个视口高度 */
}
.el-input,
.el-select {
    height: 40px;
}
</style>