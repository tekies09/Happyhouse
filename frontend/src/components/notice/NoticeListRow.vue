<template>
  <tr>
    <td>{{ no }}</td>
    <td>
      <router-link :to="{ name: 'NoticeView', params: { no: no } }">{{
        title
      }}</router-link>
    </td>
    <td>{{ writer }}</td>
    <td>{{ regtime }}</td>
  </tr>
</template>

<script>
export default {
  name: "NoticeListRow",
  props: {
    no: Number,
    title: String,
    writer: String,
    regtime: String,
  },
};
</script>

<style></style>
