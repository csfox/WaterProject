<template>
  <div style="padding:10px;">

<!--    功能区域-->
    <div style="margin:10px 0">
      <el-button type="primary">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>

<!--    搜索区域-->
    <div style="margin:10px 0">
      <el-input v-model="search" placeholder="Please input key word" style="width:20%"/>
      <el-button type="primary" style="margin-left:5px">查询</el-button>
    </div>


    <el-table
        :data="tableData"
        border
        stripe
        style="width: 100%">
      <el-table-column
          prop="date"
          label=”date“
          sortable
      />
      <el-table-column
          prop="name"
          label="Name"  />
      <el-table-column
          prop="address"
          label="Address" />
      <el-table-column fixed="right" label="Operations" width="120">
        <template #default>
          <el-button link type="primary" size="small" @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="确认删除吗?">
            <template #reference>
              <el-button link type="primary" size="small">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

<!--    分页-->
    <div style="margin:10px 0">
      <el-pagination
          v-model:current-page="currentPage"
          :page-size="10"
          :page-sizes="[5,10,20]"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />
    </div>

  </div>
</template>

<script>



export default {
  name: 'Home',
  components: {

  },
  data() {
    return {
      search: '',
      currentPage: 1,
      total:10,
      tableData :[
        {
          date: '2016-05-03',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        },
        {
          date: '2016-05-02',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
        }
      ]
    }
  },
  methods:{
    handleEdit() {

    },
    handleSizeChange() {

    },
    handleCurrentChange() {

    },
  }

}


</script>
