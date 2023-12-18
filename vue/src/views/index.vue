<template>
    <div class="home-container">
        <el-carousel :interval="3000" arrow="always" style="width: 100%; height: 300px;">
            <el-carousel-item>
                <div class="image-container">
                    <img src="@/assets/images/images02.png" alt="">
                </div>
            </el-carousel-item>
            <el-carousel-item>
                <div class="image-container">
                    <img src="@/assets/images/images05.png" alt="">
                </div>
            </el-carousel-item>
            <el-carousel-item>
                <div class="image-container">
                    <img src="@/assets/images/images08.png" alt="">
                </div>
            </el-carousel-item>
        </el-carousel>
        <div class="container">
        <el-row justify="center" align="middle">
            <el-row>

                <div class="grid-content bg-purple">
                    <el-col :span="24">
                        <div class="grid-content bg-purple">
                            <el-divider>
                                <h2>健康资讯</h2></el-divider>

                        </div>
                    </el-col>
                </div>

                <el-row :gutter="20">
                    <el-col :span="6">
                        <div class="grid-content bg-purple" >
                            <el-link class="no-underline" icon="">

                                <img src="@/assets/images/images06.png" alt="">

                            </el-link>
                            <el-link class="no-underline">
                                <a href="http://www.kepu.gov.cn/www/article/dtxw/869cf32167514836a25c0ac1d9c76274">
                                    <h3>衡量人体器官老化的血检方法问世</h3>
                                    <p>老化造成组织结构和功能衰败，使大多数慢性病风险快速上升。</p>
                                </a>
                            </el-link>
                        </div>
                    </el-col>
                    <el-col :span="6">
                        <div class="grid-content bg-purple">
                            <el-link class="no-underline" icon="">
                                <img src="@/assets/images/images10.png" alt="">
                            </el-link>
                            <el-link class="no-underline">
                                <a href="http://www.kepu.gov.cn/www/article/e01b9c7c4cf5419cb80e34bec2ba3c5a">
                                    <h3>超声波无痛无针注射疫苗</h3>
                                    <p>研究人员正在探索一种通过超声波无痛、无针注射疫苗的新方法。</p>
                                </a>
                            </el-link>
                        </div>
                    </el-col>

                    <el-col :span="6">
                        <div class="grid-content bg-purple">
                            <el-link class="no-underline" icon="">
                                <img src="@/assets/images/images03.png" alt="">
                            </el-link>
                            <el-link class="no-underline">
                                <a href="http://www.kepu.gov.cn/www/article/94f6f4c2b37148cc9cc27e6a66c16889">
                                    <h3>《健康教育与健康传播：从理论到实践》专著正式发布</h3>
                                    <p>向世界展现“中国健康故事”的生动篇章。</p>
                                </a>
                            </el-link>
                        </div>
                    </el-col>
                    <el-col :span="6">
                        <div class="grid-content bg-purple">
                            <el-link class="no-underline" icon="">
                                <img src="@/assets/images/images04.png" alt="">
                            </el-link>
                            <el-link class="no-underline">
                                <a href="http://www.kepu.gov.cn/www/article/001d8bd0ae1843b9a3c5c2696a1b184d">
                                    <h3>金华火腿“早得名”</h3>
                                    <p>非遗文化之窗 --  金华火腿 又称为南腿，盛产于浙江省金华地区。</p>
                                </a>
                            </el-link>
                        </div>
                    </el-col>
                </el-row>
            </el-row>
            <el-row :gutter="20">
                <el-col :span="6">
                    <div class="grid-content bg-purple" >
                        <el-link class="no-underline" icon="">
                            <img src="@/assets/images/images16.png" alt="">
                        </el-link>
                        <el-link class="no-underline">
                            <a href="https://www.kepuchina.cn/article/articleinfo?business_type=100&classify=0&ar_id=464974">
                                <h3>健康真知｜多服用维生素C能预防流感？</h3>
                                <p>维生素C是人体内不可或缺的一种水溶性维生素，它有多种生理功能.</p>
                            </a>
                        </el-link>
                    </div>
                </el-col>
                <el-col :span="6">
                    <div class="grid-content bg-purple">
                        <el-link class="no-underline" icon="">
                            <img src="@/assets/images/images17.png" alt="">
                        </el-link>
                        <el-link class="no-underline">
                            <a href="https://www.kepuchina.cn/article/articleinfo?business_type=100&classify=0&ar_id=464874">
                                <h3>“多吃辣”能预防和治疗糖尿病？</h3>
                                <p>研究发现，辣椒可能会增加胰岛素受体数量，提高胰岛素的清除率。</p>
                            </a>
                        </el-link>
                    </div>
                </el-col>

                <el-col :span="6">
                    <div class="grid-content bg-purple">
                        <el-link class="no-underline" icon="">
                            <img src="@/assets/images/images18.png" alt="">
                        </el-link>
                        <el-link class="no-underline">
                            <a href="https://www.kepuchina.cn/article/articleinfo?business_type=100&classify=0&ar_id=464869">
                                <h3>无花果糖分高，糖尿病人不能吃？</h3>
                                <p>以自身情况而定，如果是血糖控制稳定的糖尿病人，可在两餐间吃适量的无花果。</p>
                            </a>
                        </el-link>
                    </div>
                </el-col>
                <el-col :span="6">
                    <div class="grid-content bg-purple">
                        <el-link class="no-underline" icon="">
                            <img src="@/assets/images/images19.png" alt="">
                        </el-link>
                        <el-link class="no-underline">
                            <a href="https://www.kepuchina.cn/article/articleinfo?business_type=100&classify=0&ar_id=464796">
                                <h3>著名歌手患癌去世！这种癌“偏爱中国人”，爱吃火锅的格外注意……</h3>
                                <p>12月5日，日本知名乐队The Birthday在社交媒体发布讣告称，罹患食道癌的乐队主唱千叶佑辅，在家人的陪伴下于11月26日去世</p>
                            </a>
                        </el-link>
                    </div>
                </el-col>
            </el-row>
        </el-row>
        </div>


<!--        <el-row>-->
<!--            <el-row>-->
<!--                <div class="grid-content bg-purple">-->
<!--                    <el-col :span="24">-->
<!--                        <div class="grid-content bg-purple">-->
<!--                            <el-divider>-->
<!--                                <h2>健康科普</h2></el-divider>-->

<!--                        </div>-->
<!--                    </el-col>-->
<!--                </div>-->

<!--                <el-row :gutter="20">-->
<!--                    <el-col :span="6">-->
<!--                        <div class="grid-content bg-purple" >-->
<!--                            <el-link class="no-underline" icon="">-->
<!--                                <img src="@/assets/images/images12.png" alt="">-->
<!--                            </el-link>-->
<!--                            <el-link class="no-underline">-->
<!--                                <a href="https://www.kepuchina.cn/article/articleinfo?business_type=100&classify=0&ar_id=460878">-->
<!--                                    <h3>牙龈出血，是“上火”了吗？答案是……</h3>-->
<!--                                    <p>有的朋友是刷牙时发现牙刷上有血渍，有的朋友是吃苹果时发现食物上有血渍。-->
<!--                                        一般大家的第一反应是上火了，多喝点水就好。</p>-->
<!--                                </a>-->
<!--                            </el-link>-->
<!--                        </div>-->
<!--                    </el-col>-->
<!--                    <el-col :span="6">-->
<!--                        <div class="grid-content bg-purple">-->
<!--                            <el-link class="no-underline" icon="">-->
<!--                                <img src="@/assets/images/images13.png" alt="">-->
<!--                            </el-link>-->
<!--                            <el-link class="no-underline">-->
<!--                                <a href="https://www.kepuchina.cn/article/articleinfo?business_type=100&classify=0&ar_id=465049">-->
<!--                                    <h3>什么？喝酒竟会喝出老年痴呆？</h3>-->
<!--                                    <p>现在喝酒的理由是越来越多了, 心情好，要去小酌两杯, 心情坏，要去借酒消愁,-->
<!--                                        上到太阳爆炸，下到蚂蚁搬家 ,都可以成为搓一顿的理由</p>-->
<!--                                </a>-->
<!--                            </el-link>-->
<!--                        </div>-->
<!--                    </el-col>-->

<!--                    <el-col :span="6">-->
<!--                        <div class="grid-content bg-purple">-->
<!--                            <el-link class="no-underline" icon="">-->
<!--                                <img src="@/assets/images/images14.png" alt="">-->
<!--                            </el-link>-->
<!--                            <el-link class="no-underline">-->
<!--                                <a href="https://www.kepuchina.cn/article/articleinfo?business_type=100&classify=0&ar_id=465047">-->
<!--                                    <h3>你以为是休息，其实非常耗气血的5个行为，希望你一个也没占！</h3>-->
<!--                                    <p>医生提醒：莫把气血不足与贫血混淆，气血不足≠贫血。</p>-->
<!--                                </a>-->
<!--                            </el-link>-->
<!--                        </div>-->
<!--                    </el-col>-->
<!--                    <el-col :span="6">-->
<!--                        <div class="grid-content bg-purple">-->
<!--                            <el-link class="no-underline" icon="">-->
<!--                                <img src="@/assets/images/images15.png" alt="">-->
<!--                            </el-link>-->
<!--                            <el-link class="no-underline">-->
<!--                                <a href="https://www.kepuchina.cn/article/articleinfo?business_type=100&classify=0&ar_id=464984">-->
<!--                                    <h3>醋能控糖，甚至能抗糖尿病？</h3>-->
<!--                                    <p>要想达到真正意义上的降低血糖，不能单纯依赖喝醋。</p>-->
<!--                                </a>-->
<!--                            </el-link>-->
<!--                        </div>-->
<!--                    </el-col>-->
<!--                </el-row>-->
<!--            </el-row>-->
<!--            <el-row :gutter="20">-->
<!--                <el-col :span="6">-->
<!--                    <div class="grid-content bg-purple" >-->
<!--                        <el-link class="no-underline" icon="">-->
<!--                            <img src="@/assets/images/images16.png" alt="">-->
<!--                        </el-link>-->
<!--                        <el-link class="no-underline">-->
<!--                            <a href="https://www.kepuchina.cn/article/articleinfo?business_type=100&classify=0&ar_id=464974">-->
<!--                                <h3>健康真知｜多服用维生素C能预防流感？</h3>-->
<!--                                <p>维生素C是人体内不可或缺的一种水溶性维生素，它有多种生理功能.</p>-->
<!--                            </a>-->
<!--                        </el-link>-->
<!--                    </div>-->
<!--                </el-col>-->
<!--                <el-col :span="6">-->
<!--                    <div class="grid-content bg-purple">-->
<!--                        <el-link class="no-underline" icon="">-->
<!--                            <img src="@/assets/images/images17.png" alt="">-->
<!--                        </el-link>-->
<!--                        <el-link class="no-underline">-->
<!--                            <a href="https://www.kepuchina.cn/article/articleinfo?business_type=100&classify=0&ar_id=464874">-->
<!--                                <h3>“多吃辣”能预防和治疗糖尿病？</h3>-->
<!--                                <p>研究发现，辣椒可能会增加胰岛素受体数量，提高胰岛素的清除率。</p>-->
<!--                            </a>-->
<!--                        </el-link>-->
<!--                    </div>-->
<!--                </el-col>-->

<!--                <el-col :span="6">-->
<!--                    <div class="grid-content bg-purple">-->
<!--                        <el-link class="no-underline" icon="">-->
<!--                            <img src="@/assets/images/images18.png" alt="">-->
<!--                        </el-link>-->
<!--                        <el-link class="no-underline">-->
<!--                            <a href="https://www.kepuchina.cn/article/articleinfo?business_type=100&classify=0&ar_id=464869">-->
<!--                                <h3>无花果糖分高，糖尿病人不能吃？</h3>-->
<!--                                <p>以自身情况而定，如果是血糖控制稳定的糖尿病人，可在两餐间吃适量的无花果。</p>-->
<!--                            </a>-->
<!--                        </el-link>-->
<!--                    </div>-->
<!--                </el-col>-->
<!--                <el-col :span="6">-->
<!--                    <div class="grid-content bg-purple">-->
<!--                        <el-link class="no-underline" icon="">-->
<!--                            <img src="@/assets/images/images19.png" alt="">-->
<!--                        </el-link>-->
<!--                        <el-link class="no-underline">-->
<!--                            <a href="https://www.kepuchina.cn/article/articleinfo?business_type=100&classify=0&ar_id=464796">-->
<!--                                <h3>著名歌手患癌去世！这种癌“偏爱中国人”，爱吃火锅的格外注意……</h3>-->
<!--                                <p>12月5日，日本知名乐队The Birthday在社交媒体发布讣告称，罹患食道癌的乐队主唱千叶佑辅，在家人的陪伴下于11月26日去世</p>-->
<!--                            </a>-->
<!--                        </el-link>-->
<!--                    </div>-->
<!--                </el-col>-->
<!--            </el-row>-->
<!--        </el-row>-->
<!--        <div class="footer-container">-->
<!--            底部-->
<!--        </div>-->
    </div>
</template>

<script>

export default {
    name: 'HomeView',
    components: {
    },
    data() {
        return {

        };
    },

}
</script>

<style scoped lang="less">
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;

}

.lko{
  border: none;
  outline: none;
}

.el-row {
  margin-bottom: 30px;
  &:last-child {
    margin-bottom: 15px;
  }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #ffffff;
}
.bg-purple {
  background: #ffffff;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.el-divider{
  border-top: 1px solid dodgerblue;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
a {
  text-decoration: none;
  color: black;
}


.no-underline:hover{
  //color: dodgerblue;
  font-size: 16px;  /* 定义字体大小 */
  font-family: Arial, sans-serif;  /* 定义字体 */
}
.container {
    display: flex;
    justify-content: center; /* 水平居中 */
    align-items: center; /* 垂直居中 */
    height: 100vh; /* 使容器高度等于视口高度 */
}
.image-container {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 100%;

}
.footer-container {
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */

  background-color: dodgerblue; /* 背景颜色 */
  padding: 20px; /* 上下左右的内边距 */
  height: 100px; /* 设置高度 */

  /* 修改文字颜色 */
  color: white;
}
</style>