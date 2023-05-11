<template>
  <div>
    <el-menu
        style = "width: 200px;min-height: calc(100vh - 50px);"
        default-active="user"
        default-openeds=9
        class="el-menu-vertical-demo"
    >
      <el-sub-menu index="1">
          <template #title>水利系统管理</template>
      </el-sub-menu>
      <el-menu-item index="2">
        <el-icon><icon-menu /></el-icon>
        <span>水位管理</span>
      </el-menu-item>
      <el-menu-item index="3">
        <el-icon><icon-menu /></el-icon>
        <span>水质管理</span>
      </el-menu-item>
      <el-menu-item index="3">
        <el-icon><setting /></el-icon>
        <span>人员管理</span>
      </el-menu-item>
      <el-menu-item index="4">
        <el-icon><setting /></el-icon>
        <span>设备管理</span>
      </el-menu-item>
      <el-menu-item index="5">
        <el-icon><setting /></el-icon>
        <span>无人机管理</span>
      </el-menu-item>
      <el-menu-item index="6">
        <el-icon><setting /></el-icon>
        <span>无人船管理</span>
      </el-menu-item>
      <el-menu-item index="7">
        <el-icon><setting /></el-icon>
        <span>河流管理</span>
      </el-menu-item>
      <el-menu-item index="8">
        <el-icon><setting /></el-icon>
        <span>水利设备管理</span>
      </el-menu-item>
      <el-menu-item index="8">
        <el-icon><setting /></el-icon>
        <span>天气系统管理</span>
      </el-menu-item>
      <el-menu-item index="9">
        <el-icon><setting /></el-icon>
        <span style="font-color:blue">模型管理</span>
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