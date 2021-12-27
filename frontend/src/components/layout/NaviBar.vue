<template>
  <div id="menu">
    <b-navbar toggleable="lg" type="dark" variant="dark">
      <b-navbar-brand href="#">
        <router-link to="/">
          <img
            src="@/assets/happyhouselogo.png"
            class="d-inline-block align-middle"
            width="150px"
            alt="Kitten"
          /> </router-link
      ></b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav> </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-item href="#"  v-if="sessionuserid">
            {{ sessionuserid }}님
            환영합니다.
            </b-nav-item>
          <b-nav-item href="#">
            <router-link :to="{ name: 'Home' }"> HOME </router-link>
              </b-nav-item>
          <b-nav-item href="#">
            <router-link :to="{ name: 'Map' }" class="link">아파트</router-link>
          </b-nav-item>
        <b-nav-item href="#"><router-link :to="{ name: 'NoticeList' }" class="link">공지사항</router-link>
        </b-nav-item>
        <b-nav-item href="#"><router-link :to="{ name: 'QnAList' }" class="link">자유게시판</router-link>
        </b-nav-item>
        <b-nav-item href="#" v-if="!sessionuserid"><router-link :to="{ name: 'Join' }" class="link">회원가입</router-link>
        </b-nav-item>
        <b-nav-item href="#" v-if="!sessionuserid"><router-link :to="{ name: 'Login' }" class="link">로그인</router-link>
        </b-nav-item>
        <b-nav-item href="#" v-if="sessionuserid"><router-link :to="{ name: 'Modify' }" class="link">내정보수정</router-link>
        </b-nav-item>
        <b-nav-item href="#" @click.prevent="onClickLogout" v-if="sessionuserid">
          로그아웃
        </b-nav-item>
        <b-nav-item-dropdown right v-if="sessionuserid ==='admin'">
          <!-- Using 'button-content' slot -->
          <template #button-content>
            관리자
          </template>
          <b-dropdown-item href="#" id ="dp">
              <router-link :to="{ name: 'MemberAnalyze' }" class="link">회원통계</router-link>
              </b-dropdown-item>
          <b-dropdown-item href="#" id ="dp">
              <router-link :to="{ name: 'MemberList' }" class="link">회원관리</router-link>
          </b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</div>
</template>

<script>
export default {
  data(){
    return {
      userid: sessionStorage.getItem("userId"),
    };
  },
  name: "NaviBar",
  computed:{
    sessionuserid: function(){
      return sessionStorage.getItem("userId");
    },
  },
  methods:{
  onClickLogout(){
          sessionStorage.removeItem("userId");
          this.$router.push({name: "Home"});
          this.$router.go("/");
    },
  },
};
</script>

<style>
#dp a {
  color: gray;
}
#dp a.router-link-exact-active {
  color: black;
}
</style>