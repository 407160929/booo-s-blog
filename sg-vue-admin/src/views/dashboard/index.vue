<template>
  <div class="dashboard-container">
    <div class="dashboard-text">
      xuan的博客管理系统
    </div>
    <div>
      github:<a href="https://github.com/407160929">https://github.com/407160929</a>
    </div>
    <div>
      qq-email:407160929@qq.com
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
