import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Notice from "../views/Notice.vue";
import QnA from "../views/QnA.vue";
import Join from "../views/Join.vue";
import Login from "../views/Login.vue";
import Modify from "../views/Modify.vue";
import Logout from "../views/Logout.vue";
import MemberAnalyze from "../views/MemberAnalyze.vue";
import AptMap from "../views/Map.vue";
import Member from "../views/Member.vue";
import MemberList from "../components/member/MemberList.vue";
import MemberDelete from "../components/member/MemberDelete.vue";
import MemberModify from "../components/member/MemberModify.vue";
import MemberView from "../components/member/MemberView.vue";
import MemberWrite from "../components/member/MemberWrite.vue";
import QnAList from "../components/QnA/QnAList.vue";
import QnADelete from "../components/QnA/QnADelete.vue";
import QnAModify from "../components/QnA/QnAModify.vue";
import QnAView from "../components/QnA/QnAView.vue";
import QnAWrite from "../components/QnA/QnAWrite.vue";
import NoticeList from "../components/notice/NoticeList.vue";
import NoticeDelete from "../components/notice/NoticeDelete.vue";
import NoticeModify from "../components/notice/NoticeModify.vue";
import NoticeView from "../components/notice/NoticeView.vue";
import NoticeWrite from "../components/notice/NoticeWrite.vue";
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/map",
    name: "Map",
    component: AptMap,
  },
  {
    path: "/notice",
    name: "Notice",
    component: Notice,
    redirect: "/notice/noticelist",
    children: [
      {
        path: "/noticelist",
        name: "NoticeList",
        component: NoticeList,
      },
      {
        path: "/noticeregister",
        name: "NoticeWrite",
        component: NoticeWrite,
      },
      {
        path: "/noticeview/:no",
        name: "NoticeView",
        component: NoticeView,
      },
      {
        path: "/noticeupdate/:no",
        name: "NoticeModify",
        component: NoticeModify,
      },
      {
        path: "/noticedelete/:no",
        name: "NoticeDelete",
        component: NoticeDelete,
      },
    ],
  },
  {
    path: "/qna",
    name: "QnA",
    component: QnA,
    redirect: "/qna/qnalist",
    children: [
      {
        path: "/qnalist",
        name: "QnAList",
        component: QnAList,
      },
      {
        path: "/qnaregister",
        name: "QnAWrite",
        component: QnAWrite,
      },
      {
        path: "/qnaview/:no",
        name: "QnAView",
        component: QnAView,
      },
      {
        path: "/qnaupdate/:no",
        name: "QnAModify",
        component: QnAModify,
      },
      {
        path: "/qnadelete/:no",
        name: "QnADelete",
        component: QnADelete,
      },
    ],
  },
  {
    path: "/join",
    name: "Join",
    component: Join,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/modify",
    name: "Modify",
    component: Modify,
  },
  {
    path: "/logout",
    name: "Logout",
    component: Logout,
  },
  {
    path: "/memberanalyze",
    name: "MemberAnalyze",
    component: MemberAnalyze,
  },
  {
    path: "/member",
    name: "Member",
    component: Member,
    redirect: "/member/memberlist",
    children: [
      {
        path: "/memberlist",
        name: "MemberList",
        component: MemberList,
      },
      {
        path: "/memberwrite",
        name: "MemberWrite",
        component: MemberWrite,
      },
      {
        path: "/memberview/:userid",
        name: "MemberView",
        component: MemberView,
      },
      {
        path: "/membermodify/:userid",
        name: "MemberModify",
        component: MemberModify,
      },
      {
        path: "/memberdelete/:userid",
        name: "MemberDelete",
        component: MemberDelete,
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  linkActiveClass: 'font-bold text-white-500',
  routes,
});

export default router;
