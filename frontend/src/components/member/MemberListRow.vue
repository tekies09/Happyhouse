<template>
<tr>
<td class="text-center" style="width: 25%">아이디 : {{userId}}</td>
<td class="text-center" style="width: 25%">이름 : {{userName}}</td>
<td class="text-center" style="width: 40%">가입일 : {{joinTime}}</td>
<td class="text-center" style="width: 10%"><router-link :to="{ name: 'MemberView', params: { userId: userId } }">
        자세히
      </router-link></td>
</tr>
</template>

<script>
export default {
  name: "MemberListRow",
  props: {
    userId: String,
    userName: String,
    joinTime: String,
  },
};
</script>

<style></style>
