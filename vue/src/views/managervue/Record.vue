<template>
    <div class="record-container">
        <h3 style="text-align: center; margin-top: 30px;">预约记录</h3>
        <el-table
            :data="tableData"
            border
            style="width: 80%; height: 150px">
            <el-table-column
                prop="date"
                label="日期"
                width="180">
            </el-table-column>
            <el-table-column
                prop="name"
                label="姓名"
                width="180">
            </el-table-column>
            <el-table-column
                prop="doctor"
                label="医生">
            </el-table-column>
            <el-table-column
                prop="department"
                label="科室">
            </el-table-column>
            <el-table-column
                prop="time"
                label="预约时间">
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
export default {
    data() {
        return {
            tableData: [{
                date: '2023-12-19',
                name: '王小虎',
                doctor: '徐晔',
                department:'整形烧伤科',
                time:'2023-12-22'
            }, {
                date: '2023-12-19',
                name: '王小虎',
                doctor: '李文亮',
                department:'眼科',
                time:'2023-12-23'
            }, {
                date: '2023-12-19',
                name: '王小虎',
                doctor: '李兰娟',
                department:'急诊科',
                time:'2023-12-25'
            }, {
                date: '2023-12-19',
                name: '王小虎',
                doctor: '陈薇',
                department:'妇产科',
                time:'2023-12-27'
            }]
        }
    }
}
</script>

<style scoped>
.record-container{
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    background-size: cover;
    background-position: center;
    background-repeat: no-repeat;
    background-image: url("@/assets/images/01.png");
}
h3 {
    text-align: center;
    margin-top: 30px;
}
.el-table th,
.el-table td {
    font-size: 16px; /* Adjust the font size as needed */
}
</style>
