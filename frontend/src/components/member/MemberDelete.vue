<template>
  <div>
    <h1>회원 삭제 처리중</h1>
    <div>삭제중...</div>
  </div>
</template>

<script>
import http from "@/util/http-common.js";

export default {
  created() {
    http.delete(`vue/api/vueuser/${this.$route.params.userId}`).then(({ data }) => {
      let msg = "삭제 처리시 문제가 발생했습니다.";
      if (data === "success") {
        msg = "삭제가 완료되었습니다.";
      }
      alert(msg);
      // 현재 route를 /list로 변경.
      this.$router.push({name: "MemberList"});
    });
  },
};
</script>