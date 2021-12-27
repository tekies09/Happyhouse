<template>
<div class="container">
    <div class="input-form-backgroud row">
        <div class="input-form col-md-12 mx-auto" style="padding:50px">
            <h4 class="mb-3">로그인</h4>
            <form class="validation-form" novalidate>

                    <div class="mb-3">
                        <label for="userid">아이디</label> <input type="text" class="form-control" id="userid" placeholder="" value="" required  v-model="userid" ref="userid">
                    </div>
                    <div class="mb-3">
                        <label for="userpassword">비밀번호</label> <input type="password" class="form-control" id="userpassword" placeholder="" required v-model="userpassword" ref="userpassword">
                    </div>
                    <br>
                    <div class="mb-4"><button class="btn btn-primary btn-lg btn-block" @click="checkValue" type="button">로그인</button></div>

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
    if (!err) alert(msg);
      // 만약, 내용이 다 입력되어 있다면 registBook 호출
    else this.loginUser();
    },
    loginUser(){
    console.log("user id : " + this.userid + " user pw : " + this.userpassword );
    http
        .post("vue/api/vueuser/login", {
            userId: this.userid,
            userPassword: this.userpassword,
        })
        .then(({ data }) => {
          // 서버에서 정상적인 값이 넘어 왔을경우 실행.
        let msg = "로그인실패.";
        if (!(data === "")) {
            msg = "로그인성공.";
            this.user= data;
            sessionStorage.setItem("userId", data.userId);
            alert(msg);
            this.$router.push({name: "Home"});
            this.$router.go("/");
        }
        else {

        alert(msg);
        }

        console.log(data.userName);
            });
        },
    },
};
</script>

<style lang="scss" scoped>

</style>