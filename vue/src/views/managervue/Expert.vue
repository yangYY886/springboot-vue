<template>
    <div class="expert-container">
        <h2 class="title">专家介绍</h2>
        <div class="experts">
            <div v-for="expert in experts" :key="expert.name" class="expert">
                <img :src="expert.photo" alt="Expert Photo" class="expert-photo" />
                <h3>{{ expert.name }}</h3>
                <p>{{ expert.title }}</p>
                <button @click="showDetails(expert)">查看详情</button>
            </div>
        </div>
        <!-- 详细介绍弹窗 -->
        <div v-if="selectedExpert" class="modal">
            <div class="modal-content">
                <h3>{{ selectedExpert.name }}</h3>
                <p>{{ selectedExpert.description }}</p>
                <button @click="closeDetails">关闭</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "ExpertIntroduction",
    data() {
        return {
            experts: [
                {
                    name: "徐晔",
                    title: "主任医师",
                    photo: "/images/images21.png",
                    description: "徐晔是我院的一位资深主任医师，毕业于中山大学中山医学院临床医学八年制专业，是一名临床医学博士。" +
                        "擅长各类创面及体表缺损的修复与重建、各类体表肿瘤切除修复、常见美容外科及烧伤外科的各项诊断及治疗工作。" +
                        "他参与完成多项国家级科研项目研究工作，主持省级课题1项，市级课题1项，多次参加国内学术会议，发表SCI论文5篇，" +
                        "总影响因子20分以上，发表核心期刊论文1篇，专利1项。",
                },
                {
                    name: "钟南山",
                    title: "主任医师",
                    photo: "/images/images24.png",
                    description: "钟南山，福建厦门人，中国医学家、教授，中国工程院院士，专长慢性阻塞性肺病及其他呼吸道病，2003年起中国历次呼吸道传染病的防治领军人，" +
                        "尤以在广东省防治2003年非典型肺炎传染病闻名，他领导的广州呼吸疾病研究所主动接收SARS患者，并找出了医治皮质激素恶性股骨头坏死后遗症的疗法。" +
                        "2020年严重急性呼吸系统综合征冠状病毒2传染病暴发，83岁的钟南山任国家卫健委高级别专家组组长主理。防治传染病之外，钟南山自2004年起关注肺炎与雾霾的关连，" +
                        "2012年3月、2013年3月全国人大会期期间积极向媒体宣传雾霾议题。其他职衔包括：1992-2002年广州医学院院长、2006-2011年中华医学会会长；" +
                        "1993－2008年任第八、第九、第十届全国政协委员；2008－2018年任第十一、十二届全国人大代表；1997年中共十五大代表。",
                },
                {
                    name: "李兰娟",
                    title: "主治医师",
                    photo: "/images/images26.png",
                    description: "李兰娟擅长治疗各类疑难杂症，受到患者的高度评价，主要从事传染病临床、科研和教学工作，擅长各类肝炎、感染性疾病、新发突发传染病诊治，" +
                        "尤其是肝衰竭、病毒性肝炎、肝病微生态研究",
                },
                {
                    name: "李文亮",
                    title: "医师",
                    photo: "/images/images27.png",
                    description: "李文亮（1985年10月-2020年2月7日），男，满族，籍贯辽宁省锦州市北镇市，武汉大学临床医学七年制专业毕业，中共党员。曾任武汉市中心医院眼科医生。" +
                        "2020年3月6日，国家卫生健康委员会、人力资源和社会保障部、国家中医药管理局追授李文亮“全国卫生健康系统新冠肺炎疫情防控工作先进个人”称号。 " +
                        "2020年4月2日，李文亮被评定为烈士。4月20日，追授第24届“中国青年五四奖章”抗疫个人。",
                },
                {
                    name: "张定宇",
                    title: "主任医师",
                    photo: "/images/images28.png",
                    description: "张定宇，男，汉族，1963年12月出生于湖北省武汉市 ，祖籍河南省驻马店市确山县，中共党员，毕业于同济医科大学（现华中科技大学同济医学院），博士研究生学历，" +
                        "医学博士学位。现任湖北省卫生健康委员会党组成员、副主任、公共卫生总师。1986年7月，参加工作。1981年9月至1986年7月，在同济医科大学医学专业学习。 " +
                        "2012年9月至2013年12月，任武汉市血液中心主任、党委副书记。2013年12月，武汉市调任金银潭医院（市医疗救治中心）院长、党委副书记 。2020年8月11日，" +
                        "国家主席习近平签署主席令，授予在抗击新冠肺炎疫情斗争中作出杰出贡献的人士国家勋章和国家荣誉称号，张定宇被授予“人民英雄”国家荣誉称号 ；8月19日，" +
                        "获得第十二届“中国医师奖” ；9月17日，中央文明办发布2-7月“中国好人榜”，张定宇被评为“敬业奉献好人” 。2021年2月17日，张定宇被评为“感动中国2020年度人物” 。",
                },
                {
                    name: "顾方舟",
                    title: "副主任医师",
                    photo: "/images/images29.png",
                    description: "顾方舟（1926年6月16日-2019年1月2日），男，浙江宁波人，出生于上海市，第三世界科学院院士，英国皇家内科学院（伦敦）院士， 欧洲科学、 艺术、 文学学院院士，" +
                        "医学科学家、病毒学专家，中国医学科学院北京协和医学院原院长、一级教授。1944年9月至1950年9月，顾方舟本科就读于北京大学医学院医学系；1951年8月至1955年9月， " +
                        "博士就读于苏联医学科学院病毒学研究所病毒学专业；1958年7月至1964年8月，任中国医学科学院病毒学研究所脊髓灰质炎研究室主任，副研究员；1964年9月至1971年10月，任中国医学科学院医学生物学研究所副所长，" +
                        "副研究员；1985年11月至1993年12月，任中国医学科学院院长，中国协和医科大学校长，研究员；2019年1月2日，顾方舟因病在北京逝世，享年92岁。9月17日，国家主席习近平签署主席令，授予顾方舟“人民科学家”国家荣誉称号。" +
                        "顾方舟对脊髓灰质炎的预防及控制的研究长达42年，是中国组织培养口服活疫苗开拓者之一，被称为“中国脊髓灰质炎疫苗”之父。",
                },
                {
                    name: "陈薇",
                    title: "主治医师",
                    photo: "/images/images30.png",
                    description: "陈薇，女，1966年2月26日出生于浙江兰溪，中共党员，生物安全专家，中国工程院院士，中国人民解放军军事科学院军事医学研究院生物工程研究所所长、研究员，中国科学技术协会副主席，专业技术二级，少将军衔，" +
                        "博士生导师。陈薇1988年毕业于浙江大学，获得化学工程学士学位；1991年获得清华大学工学硕士学位，同年4月特招入伍；1998年获得军事医学科学院医学博士学位；2002年晋升为研究员；2003年成为博士生导师；" +
                        "2006年7月担任军事医学科学院微生物流行病研究所副所长；2011年12月担任军事医学科学院生物工程研究所所长，同年获得中国青年女科学家奖；2015年被授予专业技术少将军衔；2017年获得何梁何利基金科学与技术进步奖；" +
                        "2019年当选中国工程院院士；2020年被授予“人民英雄”国家荣誉称号。",
                },
                {
                    name: "张文宏",
                    title: "主任医师",
                    photo: "/images/images31.png",
                    description: "张文宏长期从事不明原因发热，各种疑难感染性疾病的查因与诊治，包括难治性细菌感染、结核等分枝杆菌感染、真菌感染以及寄生虫感染的诊治。 擅长病毒性肝炎等慢性肝病的诊治，" +
                        "教育部长江学者特聘教授、入选国家卫生健康突出贡献中青年专家、教育部新世纪优秀人才支持计划、是上海市“优秀学科带头人”、上海市先进工作者；入选国家健康科普专家库、获得全国抗击新冠肺炎疫情先进个人、" +
                        "2020年“最美教师、上海科普教育创新奖“科普杰出人物奖”、获得首届“国之名医·优秀风范”等奖，2021年1月31日，张文宏当选“中国城市人物”，获得2020年度上海市市长质量奖，2020年12月，" +
                        "《收获》杂志长篇专号2020冬卷，首发纪实文学作品《张文宏医生》 [42]；2021年8月单行本《张文宏医生》出版。",
                },
                {
                    name: "吴尊友",
                    title: "副主任医师",
                    photo: "/images/images32.png",
                    description: "吴尊友于1995年博士毕业于加州大学洛杉矶分校流行病学专业； 1988年毕业后进入安徽省防疫站工作；1995至1997年在中国预防医学科学院病毒学研究所博士后科研流动站从事博士后研究工作，" +
                        "合作导师是曾毅；2003年—2007年任民进中央社会法制分委会，副主任；2005年任中国疾控性病艾滋病预防控制中心主任；2006年6月任民进宣武区工委主任；2017年4月任中国疾病预防控制中心流行病学首席专家；" +
                        "2022年12月当选中国民主促进会第十五届中央委员会委员、常务委员；2023年1月当选为第十四届全国政协委员",
                },
                {
                    name: "张继先",
                    title: "主治医师",
                    photo: "/images/images33.png",
                    description: "张继先，呼吸与重症医学科主任，今年54岁。她是常年坚守在一线的呼吸科医生，是从抗击非典战斗中走出来的老将，是具有敏锐头脑的守望者，汇聚几种特质的她，是拉响新冠肺炎疫情警报的第一人。" +
                        "她是武汉新型冠状病毒感染的肺炎疫情防控工作的标志性人物，是湖北疫情上报“第一人”。2020年，获得“全国先进工作者”“中国好医生、中国好护士”抗疫特别人物、“全国卫生健康系统新冠肺炎疫情防控工作先进个人”" +
                        "“白求恩式的好医生”等一系列光荣称号。",
                },
            ],
            selectedExpert: null,
        };
    },
    methods: {
        showDetails(expert) {
            this.selectedExpert = expert;
        },
        closeDetails() {
            this.selectedExpert = null;
        },
    },
};
</script>

<style scoped>
.expert-container {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column; /* 垂直居中排列 */
    min-height: 100vh;
    background-color: #f0f0f0;
    padding-top: 20px;
    padding-bottom: 20px;
}

.title {
    font-size: 24px;
    color: #333;
    margin-bottom: 20px;
}

.experts {
    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;
}

.expert {
    width: 22%;
    padding: 20px;
    background-color: white;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    margin: 10px;
    text-align: center;
}

.expert-photo {
    width: 100%;
    border-radius: 50%;
    margin-bottom: 10px;
}

.modal {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: flex;
    justify-content: center;
    align-items: center;
}

.modal-content {
    background-color: white;
    width: 60%; /* 设置弹窗宽度 */
    max-width: 600px; /* 设置最大宽度 */
    height: auto; /* 让高度自适应内容 */
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    text-align: center;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.modal-content button {
    margin-top: 10px;
}
</style>
