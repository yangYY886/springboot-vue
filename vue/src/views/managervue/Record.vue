<template>
    <div>
        <el-table :data="appointmentRecords" style="width: 100%">
            <el-table-column label="患者姓名" prop="Patient Name"></el-table-column>
            <el-table-column label="医生" prop="Doctor"></el-table-column>
            <el-table-column label="日期" prop="date"></el-table-column>
            <el-table-column label="时间" prop="Time"></el-table-column>
        </el-table>
    </div>
</template>

<script>
export default {
    data() {
        return {
            appointmentRecords: [
                { patientName: 'John Doe', doctor: 'Dr. Smith', date: '2023-01-01', time: '10:00 AM' },
                { patientName: 'Jane Doe', doctor: 'Dr. Johnson', date: '2023-01-02', time: '02:30 PM' },

            ],
        };
    },
};
</script>

<style scoped>

</style>
