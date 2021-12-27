<template>
    <div>
        <br/>
        <h2>회원분석</h2>
        <br/>
        <section class="container">
    <div class="columns">
      <div class="column">
        <h3>사용 이메일 도메인별 통계</h3>
        <line-chart></line-chart>
      </div>
      <div class="column">
        <h3>나이대별 유저 통계</h3>
        <bar-chart></bar-chart>
      </div>
    </div>
    <div class="columns">
      <div class="column">
        <h3>유저 성별 통계</h3>
        <bubble-chart></bubble-chart>
      </div>
      <div class="column">
        <h3>2021년 월별 가입 통계</h3>
        <reactive></reactive>
      </div>
    
    </div>
  </section>
    </div>

</template>

<script>
 import LineChart from '@/components/chart/UserEmailChart'
  import BarChart from '@/components/chart/UserAgeChart'
  import BubbleChart from '@/components/chart/UserSexChart'
  import Reactive from '@/components/chart/UserJointimeChart'
export default {
     name: 'VueChartJS',
      components: {
      LineChart,
      BarChart,
      BubbleChart,
      Reactive
    },
};
</script>

<style >

</style>