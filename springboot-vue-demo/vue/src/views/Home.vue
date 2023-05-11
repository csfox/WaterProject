<template>
  <div style="padding:10px;">

<!--    功能区域-->
<!--    <div style="margin:10px 0">-->
<!--      <el-button type="primary">导出</el-button>-->
<!--    </div>-->

    <h3>新安江模型</h3>
    <div style="height:50px;"></div>

    <el-form :model="form" label-width="120px">
      <span class="text-gray-500">设置水文模型参数</span>
      <el-form-item label="SetSoilWaterStorageParam">
        <el-input v-model="form.name"  placeholder="100，50，100"/>
      </el-form-item>
      <el-form-item label="SetEvapotranspirationParam">
        <el-input v-model="form.name"  placeholder="0.55，0.10"/>
      </el-form-item>
      <el-form-item label="SetRunoffGenerationParam">
        <el-input v-model="form.name" placeholder="0.18，0.00"/>
      </el-form-item>
      <el-form-item label="SetSourcePartitionParam">
        <el-input v-model="form.name" placeholder="15.89，2.00，0.65，0.05"/>
      </el-form-item>
      <el-form-item label="SetRunoffConcentrationParam">
        <el-input v-model="form.name" placeholder="0.45, 0.05, 537"/>
      </el-form-item>
      <span class="text-gray-500">设置运行参数</span>
      <el-form-item label="ComputeRunoffGeneration">
        <el-input v-model="form.name" placeholder="42.41, 100.00, 43.07"/>
      </el-form-item>
      <el-form-item label="ComputeSourcePartition">
        <el-input v-model="form.name" placeholder="9.86, 2"/>
      </el-form-item>
      <el-form-item label="ComputeRunoffConcentration">
        <el-input v-model="form.name" placeholder="44.35, 19.23, 2"/>
      </el-form-item>

      <span class="text-gray-500">输出为地表径流，壤中流，地下径流和总径流序列</span>
      <div style="height:50px;"></div>
      <span class="text-gray-500">测试输入</span>
      <el-form-item label="P">
        <el-input v-model="form.name" placeholder="降雨量序列"/>
      </el-form-item>
      <el-form-item label="EI">
        <el-input v-model="form.name" placeholder="蒸发皿蒸发量序列"/>
      </el-form-item>
      <el-form-item label="ObsQ">
        <el-input v-model="form.name" placeholder="径流量实测序列"/>
      </el-form-item>

      <div style="height:30px;"></div>
      <span class="text-gray-500">测试输出</span>
      <el-form-item label="QRS">
        <el-input v-model="form.name" placeholder="地表径流"/>
      </el-form-item>
      <el-form-item label="QRSS">
        <el-input v-model="form.name" placeholder="壤中流"/>
      </el-form-item>
      <el-form-item label="QRG">
        <el-input v-model="form.name" placeholder="地下径流"/>
      </el-form-item>
      <el-form-item label="Q">
        <el-input v-model="form.name" placeholder="总径流序列"/>
      </el-form-item>
    </el-form>














<!--    <div id="main" style="width: 80%;height:600px;" ref="main">-->
<!--    </div>-->

<!--    搜索区域-->
<!--    <div style="margin:10px 0">-->
<!--      <el-input v-model="search" placeholder="Please input key word" style="width:40%" clearable/>-->
<!--      <el-button type="primary" style="margin-left:5px" @click="load">查询</el-button>-->
<!--    </div>-->


<!--    <el-table-->
<!--        :data="tableData"-->
<!--        border-->
<!--        stripe-->
<!--        style="width: 80%">-->
<!--      <el-table-column-->
<!--          prop="id"-->
<!--          label=”ID“-->
<!--          sortable />-->
<!--      <el-table-column-->
<!--          prop="username"-->
<!--          label="用户名"  />-->
<!--      <el-table-column-->
<!--          prop="nickName"-->
<!--          label="昵称" />-->
<!--      <el-table-column-->
<!--          prop="age"-->
<!--          label="年龄"  />-->
<!--      <el-table-column-->
<!--          prop="sex"-->
<!--          label="性别" />-->
<!--      <el-table-column-->
<!--          prop="address"-->
<!--          label="地址"  />-->
<!--      <el-table :data="tableData1" style="width: 100%">-->
<!--        <el-table-column prop="date" label="level_id" width="180" />-->
<!--        <el-table-column prop="name" label="device_code" width="180" />-->
<!--        <el-table-column prop="address" label="water_level" />-->
<!--        <el-table-column prop="time" label="level_time" />-->
<!--      </el-table>-->


    <div>



    </div>

<!--    分页-->
<!--    <div style="margin:10px 0">-->
<!--      <el-pagination-->
<!--          v-model:current-page="currentPage"-->
<!--          :page-size="pageSize"-->
<!--          :page-sizes="[5,10,20]"-->
<!--          layout="total, sizes, prev, pager, next, jumper"-->
<!--          :total="total"-->
<!--          @size-change="handleSizeChange"-->
<!--          @current-change="handleCurrentChange"-->
<!--      />-->

<!--    </div>-->

  </div>
</template>

<script>

import * as echarts from "echarts";
import request from "../utils/request";
// import axios from "axios";



export default {

  name: 'homePage',
  mounted() {
    this.test()
  },
  data() {
    return {
      dataId:0,
      dataAge:0,
      count:2,
      currentPage:20,
      pageSize:10,
      total:374,
      handleSizeChange:10,
      handleCurrentChange:10,
      tableData1 :[
        {
          date: '0466',
          name: '01',
          address: '20',
          time:'2023 03-02 16:25:39',
        },
        {
          date: '0467',
          name: '01',
          address: '20',
          time:'2023 03-02 16:26:02',
        },
        {
          date: '0468',
          name: '01',
          address: '476',
          time:'2023 03-02 16:26:11',
        },
        {
          date: '0469',
          name: '01',
          address: '471',
          time:'2023 03-02 16:26:23',
        },
        {
          date: '0472',
          name: '01',
          address: '468',
          time:'2023 03-02 16:31:05',
        },
        {
          date: '0473',
          name: '01',
          address: '450',
          time:'2023 03-02 16:31:23',
        },
        {
          date: '0474',
          name: '01',
          address: '464',
          time:'2023 03-02 16:31:48',
        },
      ],
      form : {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: '',
      }



    }
  },
  methods: {
    load(){
      const tableData1 = [
        {
          date: '2016-05-03',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
          time:0,
        },
        {
          date: '2016-05-02',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
          time:0,
        },
        {
          date: '2016-05-04',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
          time:0,
        },
        {
          date: '2016-05-01',
          name: 'Tom',
          address: 'No. 189, Grove St, Los Angeles',
          time:0,
        },
      ]

    },
    test() {
      // 官方示例 var myChart = echarts.init(document.getElementById('main'));
      const myChart = echarts.init(this.$refs.main); // 我们可以这样写

      //
      let temp = 0
      const time = (function () { // 立即执行函数
        let now = new Date();  // 获得当前的时间
        let res = []; // 存放时间的数组
        let len = 5; // 要存几个时间？
        while (len--) {
          res.unshift(now.toLocaleTimeString().replace(/^\D*/, '')); // 转换时间，大家可以打印出来看一下
          now = new Date(+now - 2000) // 延迟几秒存储一次？
        }
        return res;
      })();
      const dataOne = (function () { // 5个随机数，大家可随意定义
        let res = [];
        let len = 6;
        while (len--) {
          //res.push(20 * 1000);
        }
        return res;
      })();
      const dataTwo = (function () { // 5个随机数
        let res = [];
        let len = 6;
        while (len--) {
          res.push(20* 1000);
        }
        return res;
      })();
      //配置项，可以去查一下官方文档
      let options = {
        title: {
          text: '动态',
          textStyle: {
            color: 'black'
          }
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            label: {
              backgroundColor: '#283b56'
            }
          }
        },
        legend: {},
        xAxis: {
          type: 'category',
          data: time, // 把时间组成的数组接过来，放在x轴上
          boundaryGap: true
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data: dataOne,
            type: 'line',
            //name: '测试一',
            markLine: {
              data: [{ type: 'average', name: '平均值' }]
            }
          },
          {
            data: dataTwo,
            name: '水位线',
            type: 'line',
            markLine: {
              data: [{ type: 'average', name: '平均值' }]
            }
          }
        ]
      }
      setInterval(function () {
        let jsonR=0;
        let webSocket;


        //原始
        let nowTime = new Date().toLocaleTimeString().replace(/^\D*/, '');
        request.get("/api/wr_level").then(res =>{
          //this.dataId = res.data.records[temp].id
          this.dataAge = res.data.waterLevel;
          console.log(this.dataAge);

        })

        time.shift()
        time.push(nowTime)
        // dataOne.shift()
        // dataOne.push(this.dataId * 1000)
        dataTwo.shift()
        dataTwo.push(this.dataAge * 1000)
        temp++

        //很多朋友可能要接后端接口,把数据替换下来既可以了
        // axios.get('你的url').then(res => {
        //   console.log(res)
        // })


        myChart.setOption({
          xAxis: [
            {
              data: time
            }
          ],
          series: [
            {
              data: dataOne
            },
            {
              data: dataTwo
            }
          ]
        })
      }, 2000)
      myChart.setOption(options)

    }
  }
}


</script>
