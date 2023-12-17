<template>
    <div>
        <Header></Header>

        <router-view></router-view>

        <Footer></Footer>
    </div>
</template>

<script>
import Header from '@/views/Header.vue'
//import Footer from '@/components/Footer.vue'
export default {
    components:{
        Header,
        //Footer
    }
}
</script>

<style>

</style>