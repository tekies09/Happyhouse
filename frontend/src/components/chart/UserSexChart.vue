

<script>
import { Pie } from "vue-chartjs"
import http from "@/util/http-common.js";
export default {
    name: 'FontendUseragechart',
    extends: Pie,
    data() {
        return {
        userColumn : [],
        userCount :[],
        datacollection: {
          //Data to be represented on x-axis
        labels: [], 
        datasets: [
            {
            label: 'Data One',
            backgroundColor: ['#87CEFA','#f87979'],
            pointBackgroundColor: 'white',
            borderWidth: 1,
            pointBorderColor: '#249EBF',
              //Data to be represented on y-axis
            data: [1,2]
            }
            ]
        },
        options: {
        scales: {
        yAxes: [{
        ticks: {
                beginAtZero: true
            },
            gridLines: {
                display: false
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

    created() {
    
    },

    async mounted(){
    await http.get("vue/api/vueadmin/usersexcolumn").then(({ data }) => {
        this.userColumn = data;
        this.datacollection.labels = this.userColumn;
    });
    await    http.get("vue/api/vueadmin/usersexcount").then(({ data }) => {  
        this.userCount = data;
        this.datacollection.datasets[0].data = this.userCount;
    });
        
        this.renderChart(this.datacollection, this.options);
    },
};
</script>

<style lang="scss" scoped>

</style>