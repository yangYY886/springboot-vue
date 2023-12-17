import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

import './assets/style/base.css'
import request from "@/utils/request";

Vue.config.productionTip = false
Vue.use(ElementUI,{size:"mini"});
Vue.use(ElementUI,{size:'small'})
Vue.prototype.$request=request
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
import axios from 'axios';  // 假设您想使用axios作为请求库
Vue.config.productionTip = false;
