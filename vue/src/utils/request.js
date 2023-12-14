import axios from 'axios'
//创建一个axios 对象出来，
const request =axios.create({
    baseURL:'http://localhost:9090',
    timeout:3000
})
//request拦截器
//可以自请求发送前对请求做一些处理
//比如统一token，对请求参数统一加密
request.interceptors.request.use(config=>{
    config.headers['Content-Type']='application/json;charset=utf-8';
    return config
},error => {
    return Promise.reject(error)
});
request.interceptors.response.use(
    response=>{
        //esponse.data即为后端返回数据的Result
        let res =response.data;
        if(typeof res==='string'){
            res=res? JSON.parse(res):res
        }
        return res;
    },
    error => {
        console.log(error)
        return Promise.reject(error)
    }

)
export default  request