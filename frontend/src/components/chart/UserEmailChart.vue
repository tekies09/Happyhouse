
<script>
import {Bar} from 'vue-chartjs'
import http from "@/util/http-common.js";
export default {
    extends: Bar,
    name: 'FontendUseragechart',

    data() {
        return {
            datacollection: {
          //Data to be represented on x-axis
            labels: this.userColumn, 
            datasets: [
            {
            fill: true,
            label: 'Data One',
            backgroundColor: '#ADD8E6',
            pointBackgroundColor: 'white',
            borderWidth: 1,
            pointBorderColor: '#249EBF',
              //Data to be represented on y-axis
            data: this.userCount,
            }
          ]
        },
            userages: [],
            userColumn : [],
            userCount :[],
            options: {
          scales: {
            yAxes: [{
              ticks: {
                beginAtZero: true
              },
              gridLines: {
                display: true
              }
            }],
            xAxes: [ {
              gridLines: {
                display: false
              }
            }]
          },
          legend: {
            display: true
          },
          responsive: true,
          maintainAspectRatio: false
        }
        };
    },
    created(){
        
    },

    async mounted(){
    await http.get("vue/api/vueadmin/useremailcolumn").then(({ data }) => {
        this.userColumn = data;
        this.datacollection.labels = this.userColumn;
    });
    await    http.get("vue/api/vueadmin/useremailcount").then(({ data }) => {  
        this.userCount = data;
        this.datacollection.datasets[0].data = this.userCount;
    });
        
        this.renderChart(this.datacollection, this.options);
    },
};
</script>

<style lang="scss" scoped>

</style>