<template>
  <div>
    <el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
  </div>
</template>

<script>
import { createDecipher } from 'crypto';
import { create } from 'domain';


  export default {
    name:'',
    props:[''],
    data () {
      return {
        
        defaultProps: {
          children: 'children',
          label: 'label'
        }
      };
    },

    components: {},

    computed: {},

    beforeMount() {},

    mounted() {},

    created(){
        this.getMenu
    },

    methods: {
        handleNodeClick(data) {
        console.log(data);
      },
      getMenu(){
          this.$http({
          url: this.$http.adornUrl('/product/category/list/tree'),
          method: 'get',
        }).then(data=>{
            console.log("成功获取到菜单数据......",data)
        })
      },
    },

    watch: {}

    

  }

</script>
<style lang='' scoped>

</style>