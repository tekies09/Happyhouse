<template>
<div class="container">
    <div class="input-form-backgroud row">
        <div class="input-form col-md-12 mx-auto">
            <h4 class="mb-3">회원가입</h4>
            <form class="validation-form" novalidate>
                <div class="row"> 
                    <div class="col-md-6 mb-3">
                    <label for="userid">아이디</label> <input type="text" class="form-control" id="userid" placeholder="" value="" required  v-model="userid" ref="userid">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="userpassword">비밀번호</label> <input type="text" class="form-control" id="userpassword" placeholder="" value="" required  v-model="userpassword" ref="userpassword">
                    </div>
                </div>
                    <div class="mb-3">
                        <label for="username">이름</label> <input type="text" class="form-control" id="username" placeholder="" value="" required  v-model="username" ref="username">
                    </div>
                    <div class="mb-3">
                        <label for="useremail">이메일</label> <input type="email" class="form-control" id="useremail" placeholder="you@example.com" required v-model="useremail" ref="useremail">
                    </div>
                    <div class="row"> 
                    <div class="col-md-6 mb-3">
                        <label for="usersex">성별</label>
                        <div class = "row">
                            <div class="col-md-6 mb-3">
                            <input type="radio" id="usersexw" value="W" v-model="usersex">
                            <label for="one">W</label>
                            </div>
                            <div class="col-md-6 mb-3">
                            <input type="radio" id="usersexm" value="M" v-model="usersex">
                            <label for="two">M</label>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="userage">나이</label><input type="text" class="form-control" id="userage" placeholder="" value="" required v-model="userage" ref="userage">
                    </div>
                </div>
                    <div class="mb-4"></div>
                    <button class="btn btn-primary btn-lg btn-block" @click="checkValue" type="button">가입 완료</button>
            </form>
        </div>
    </div>
</div>
</template>

<script>
import http from "@/util/http-common.js";
    export default {
        data(){
            return{
                userid: '',
                userpassword: '',
                username: '',
                useremail: '',
                userage: '',
                usersex: '',
            };
    },
    methods: {
        checkValue() {
      // 사용자 입력값 체크하기
      // isbn, 제목, 저자, 가격, 설명이 없을 경우 각 항목에 맞는 메세지를 출력
    let err = true;
    let msg = "";
    !this.userid &&
        ((msg = "아이디를 입력해주세요" ),
        (err = false),
        this.$refs.userid.focus());
    err &&
        !this.userpassword &&
        ((msg = "비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.userpassword.focus());
    err &&
        !this.username &&
        ((msg = "이름을 입력해주세요"), 
        (err = false), this.$refs.username.focus());
    err &&
        !this.useremail &&
        ((msg = "이메일을 입력해주세요"),
        (err = false),
        this.$refs.useremail.focus());
    err &&
        !this.userage &&
        ((msg = "나이를 입력해주세요"), (err = false), this.$refs.userage.focus());
    err &&
        !this.usersex &&
        ((msg = "성별을 선택해주세요"), (err = false));
    if (!err) alert(msg);
      // 만약, 내용이 다 입력되어 있다면 registBook 호출
    else this.joinUser();
    },
    joinUser(){
    console.log("user id : " + this.userid + " user pw : " + this.userpassword + "\n user name : " + this.username + " useremail : " + this.useremail + "\n user age: " + this.userage + " usersex : " + this.usersex);
    http
        .post("vue/api/vueuser/join", {
            userId: this.userid,
            userPassword: this.userpassword,
            userName: this.username,
            userEmail: this.useremail,
            userAge : this.userage,
            userSex : this.usersex,
        })
        .then(({ data }) => {
          // 서버에서 정상적인 값이 넘어 왔을경우 실행.
        let msg = "등록 처리시 문제가 발생했습니다.";
        if (data === "success") {
            msg = "등록이 완료되었습니다.";
        }
        alert(msg);
        this.$router.push("/");
            });
        },
    },
};
</script>

<style>
.input-form {
    max-width: 680px; 
    margin-top: 80px;
    padding: 32px; background: #fff;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
        border-radius: 10px;
        -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
        -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
            box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
            }

</style>