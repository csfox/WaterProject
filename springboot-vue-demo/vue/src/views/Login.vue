<template>
  <div id="main" style="width: 100%;height:600px;" ref="main">
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
    }
  },
  methods: {
    load(){

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

        webSocket = new WebSocket("ws://localhost:9090/user/chengrui");
        webSocket.onopen = function (){
          console.log('webSocket连接创建。。。');
        }
        webSocket.onmessage = function(event){
          jsonR = JSON.parse(event.data).age;
          if(jsonR!=0){
            this.dataAge = jsonR;
          }
          console.log(this.dataAge);
          let nowTime = new Date().toLocaleTimeString().replace(/^\D*/, '');
          time.shift();
          time.push(nowTime);
          // dataOne.shift()
          // dataOne.push(this.dataId * 1000)
          dataTwo.shift();
          dataTwo.push(this.dataAge * 1000);
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


        }


        webSocket.onclose = function(){
          console.log("连接关闭");
        }
        webSocket.onerror = function (event) {
          console.log('webSocket连接异常。。。');
        }



        //原始
        let nowTime = new Date().toLocaleTimeString().replace(/^\D*/, '');
        request.get("/api/user").then(res =>{
          //this.dataId = res.data.records[temp].id
          this.dataAge = res.data.age
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

<style scoped lang="scss">
</style>