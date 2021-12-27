<template>
<div class="container">
    <div class="input-form-backgroud row">
        <div class="input-form col-md-12 mx-auto">
            <h4 class="mb-3">정보보기</h4>
            <form class="validation-form" novalidate>
                <div class="row"> 
                    <div class="col-md-6 mb-3">
                    <label for="userid">아이디</label> <input type="text" class="form-control" id="userid" placeholder="" value="" required  v-model="userid" ref="userid" readonly>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="userpassword">비밀번호</label> <input type="text" class="form-control" id="userpassword" placeholder="" value="" required  v-model="userpassword" ref="userpassword" readonly>
                    </div>
                </div>
                    <div class="mb-3">
                        <label for="username">이름</label> <input type="text" class="form-control" id="username" placeholder="" value="" required  v-model="username" ref="username" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="useremail">이메일</label> <input type="email" class="form-control" id="useremail" placeholder="you@example.com" required v-model="useremail" ref="useremail" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="jointime">가입일</label> <input type="text" class="form-control" id="jointime" placeholder="" required v-model="jointime" ref="jointime" readonly>
                    </div>
                    <div class="row"> 
                    <div class="col-md-6 mb-3">
                        <label for="usersex">성별</label>
                        <div class = "row">
                            <div class="col-md-6 mb-3">
                            <input type="radio" id="usersexw" value="W" v-model="usersex" disabled>
                            <label for="one">W</label>
                            </div>
                            <div class="col-md-6 mb-3">
                            <input type="radio" id="usersexm" value="M" v-model="usersex" disabled>
                            <label for="two">M</label>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="userage">나이</label><input type="text" class="form-control" id="userage" placeholder="" value="" required v-model="userage" ref="userage" readonly>
                    </div>
                </div>
                    <div class="mb-4"></div>

                    <div class="row" style="text-align: center"> 
                    <div style="width: 30%; margin: 0 auto"><router-link :to="{ name: 'MemberModify' ,params: { userId: userid }}" class="link"><button class="btn btn-primary btn-lg btn-block" type="button">수정하기</button></router-link></div>
                    <div style="width: 30%; margin: 0 auto"><router-link :to="{ name: 'MemberDelete' ,params: { userId: userid }}" class="link"><button class="btn btn-primary btn-lg btn-block" type="button">삭제하기</button></router-link></div>
                    <div style="width: 30%; margin: 0 auto"><router-link :to="{ name: 'MemberList' }" class="link"><button class="btn btn-primary btn-lg btn-block" type="button">목록으로</button></router-link></div>
                    </div>
            </form>
        </div>
    </div>
</div>
</template>

<script>
import http from "@/util/http-common.js";

export default {
  data: function () {
    return {
    user: {},
    jointime: '',
    userid: '',
    userpassword: '',
    username: '',
    useremail: '',
    userage: '',
    usersex: '',
    };
  },
  created() {
    http.get(`vue/api/vueuser/${this.$route.params.userId}`).then(({ data }) => {
    this.user = data;
    this.userid= this.user.userId;
    this.userpassword= this.user.userPassword;
    this.username= this.user.userName;
    this.useremail= this.user.userEmail;
    this.userage= this.user.userAge;
    this.usersex= this.user.userSex;
    this.jointime= this.user.joinTime;
    });
  },
  methods: {},
};
</script>

<style></style>
