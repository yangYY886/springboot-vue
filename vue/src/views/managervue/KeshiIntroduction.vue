<template>
    <div class="hospital-container">
        <h2 class="title">科室介绍</h2>
        <div class="departments">
            <div v-for="department in departments" :key="department.name" class="department">
                <h3>{{ department.name }}</h3>
                <p>{{ department.description }}</p>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "KeshiIntroduction",
    data() {
        return {
            departments: [
                {
                    name: "儿科",
                    description:
                        "儿科专业致力于儿童的健康管理，涵盖了从新生儿到青少年的全方位医疗服务。我们的专业团队通过丰富的经验和温暖的关怀，致力于确保每个孩子都能获得最优质的医疗服务。",
                },
                {
                    name: "骨科",
                    description:
                        "骨科是一个专注于骨骼系统疾病和损伤的医学领域。我们的骨科团队拥有先进的技术和丰富的经验，提供从骨折修复到关节置换等全面的骨科治疗服务，旨在帮助患者恢复健康。",
                },
                {
                    name: "眼科",
                    description:
                        "眼科专注于眼部健康和视觉问题的诊断和治疗。我们的眼科医生拥有高超的技术和临床经验，为患者提供从常规眼检到复杂眼部手术的全方位服务，保障患者明亮而清晰的视野。",
                },
                {
                    name: "皮肤科",
                    description:
                        "皮肤科是专门研究皮肤及其相关疾病的医学分支。我们的皮肤科医生具备丰富的皮肤诊断和治疗经验，为患者提供从常见皮肤问题到复杂皮肤病的综合性护理和治疗。",
                },
                {
                    name: "妇产科",
                    description:
                        "妇产科关注女性生殖健康和孕产过程。我们的妇产科团队提供从妇科检查到孕期护理、分娩以及更年期健康管理等全方位的服务，旨在帮助女性维护身体健康。",
                },
                {
                    name: "神经科",
                    description:
                        "神经科专注于神经系统疾病的诊断和治疗。我们的神经科医生拥有丰富的神经学专业知识，提供从头痛、癫痫到中风和神经肌肉疾病等综合性的神经科医疗服务。",
                },
                {
                    name: "肝胆外科",
                    description:
                        "肝胆外科是一个专业的外科领域，致力于肝脏、胆囊和胆道系统的疾病治疗。我们的团队拥有先进的技术和临床经验，为患者提供全面的肝胆外科手术和治疗。",
                },
                {
                    name: "急诊科",
                    description:
                        "急诊科是医院重要的医疗服务部门，24小时为患者提供紧急医疗救治。我们的急诊科医生和护士团队随时待命，为患者提供迅速和高效的急诊医疗服务。",
                },
                {
                    name: "口腔科",
                    description:
                        "口腔科专注于口腔和牙齿健康的维护和治疗。我们的口腔科医生提供从常规口腔检查、洗牙到复杂的口腔手术等全面的口腔医疗服务，确保患者拥有健康洁白的笑容。",
                },
                {
                    name: "整形烧伤科",
                    description:
                        "整形烧伤科致力于整形美容和烧伤创伤的医学治疗。我们的整形烧伤团队结合先进技术，为患者提供从整形美容手术到烧伤创伤的综合性整形烧伤医疗服务，帮助患者重获自信。",
                },
            ],
        };
    },
};
</script>

<style scoped>
.hospital-container {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column; /* 垂直居中排列 */
    min-height: 100vh; /* 使用min-height确保内容不会挤到底部 */
    background-color: #f0f0f0;
    padding-top: 20px; /* 增加上边距 */
    padding-bottom: 20px;
}
.title {
    font-size: 24px;
    color: #333;
    margin-bottom: 20px; /* 增加标题与科室介绍之间的间距 */
}

.departments {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    max-width: 1200px;
}

.department {
    width: 45%;
    padding: 20px;
    background-color: white;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    margin: 10px;
}

h3 {
    color: #333;
}

p {
    color: #666;
}
</style>
