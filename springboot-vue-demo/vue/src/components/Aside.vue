<template>
  <div>
    <el-menu
        style = "width: 200px;min-height: calc(100vh - 50px);"
        default-active="user"
        default-openeds=1
        class="el-menu-vertical-demo"



    >
      <el-sub-menu index="1">
          <template #title>水利系统管理</template>
          <el-menu-item index="user">水位管理</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="2">
        <el-icon><icon-menu /></el-icon>
        <span>水质管理</span>
      </el-menu-item>
      <el-menu-item index="4">
        <el-icon><setting /></el-icon>
        <span>Navigator Four</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Aside"
}
</script>

<style scoped>

</style>