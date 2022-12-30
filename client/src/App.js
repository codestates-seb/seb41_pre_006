import React, { useEffect } from "react";
import { Route, Routes } from "react-router-dom";
import { Reset } from "styled-reset";
import { useDispatch, useSelector } from "react-redux";
import jwt_decode from "jwt-decode";
import useFetch from "./hooks/useFetch";
// import { getLoginStatus } from "./redux/actions/userAction";
import GlobalStyle from "./styles/GlobalStyle";
import styled from "styled-components";
import Header from "./components/Header";
import Footer from "./components/Footer";

import QuestionsListPage from "./components/QuestionsList";

import Login from "./pages/Login";
// import LogOut from "./pages/LogOut";
import Signup from "./pages/Signup";
// import NotFound from "./components/NotFound";

import Home from "./pages/Home";
// import QustionsListPage from "./pages/QustionsListPage"; // 글리스트페이지
import QuestionDetailPage from "./pages/QuestionDetailPage"; // 글상세페이지";
import AskQuestion from "./pages/AskQuestion"; // 글쓰기페이지;
import QuestionEditPage from "./pages/QuestionEditPage"; // 글수정하기페이지";
// import EditAnswerPage from "./pages/EditAnswerPage"; // 답변수정하기페이지";
import ProfilePage from "./pages/ProfilePage"; // 유저프로필페이지
import TagsPage from "./pages/TagsPage"; // 태그페이지
import UsersPage from "./pages/UsersPage"; // 유저페이지
import { refreshToken } from "./hooks/refreshToken";
import { getLoginStatus, getmyInfo } from "./redux/actions/userAction";

const Main = styled.div`
  padding-top: 54px;
  height: auto;
  min-height: 100%;
`;

function App() {
  const dispatch = useDispatch();
  const isLogin = useSelector((state) => state.userReducer.isLogin);
  const UserLoad = async () => {
    const myInfo = await useFetch("GET", "/users");
    dispatch(getmyInfo(myInfo));
    console.log("myInfo res", myInfo);
  };

  useEffect(() => {
    if (isLogin) {
      UserLoad();
    }
    const token = localStorage.getItem("accessToken");
    if (token) {
      try {
        const { exp } = jwt_decode(token);
        // 토큰 만료
        if (Date.now() >= exp * 1000) {
          localStorage.removeItem("accessToken");
          localStorage.removeItem("refreshToken");
          dispatch(getLoginStatus({ isLogin: false }));
          window.reload();

          // 토큰 만료 전 로그인 연장 필요
        } else if (Date.now() >= exp * 1000 - 100000) {
          dispatch(getLoginStatus({ isLogin: true }));
          refreshToken();
          // 토큰 유효
        } else {
          dispatch(getLoginStatus({ isLogin: true }));
        }
      } catch (e) {
        console.log(e);
      }
    }
  }, [isLogin, UserLoad, dispatch]);

  return (
    <div className="App">
      <Reset />
      <GlobalStyle />
      <Header />
      <Main>
        <Routes>
          <Route path="/users/login" element={<Login />} />
          {/* <Route path="/users/logout" element={<LogOut />} /> */}
          <Route path="/users/signup" element={<Signup />} />
          {/* <Route path="/users/signup/success" element={<SignupSuccess />} /> */}
          {/* <Route path="/users/signup/recovery" element={<SignupRecovery />} /> */}
          <Route path="/" element={<Home />} />
          <Route path="/questions/" element={<QuestionsListPage />} />
          <Route path="/questions/ask" element={<AskQuestion />} />
          <Route path="/questions/edit" element={<QuestionEditPage />} />
          {/* <Route path="/questions/edit/" element={<EditAnswerPage />} /> */}
          <Route
            exact
            path="/questions/detail/:num"
            element={<QuestionDetailPage />}
          />
          <Route path="/profile" element={<ProfilePage />} />
          <Route path="/tags" element={<TagsPage />} />
          <Route path="/users" element={<UsersPage />} />
        </Routes>
      </Main>
      {/*
       */}
      {/* 주석 샘플 나중에 날릴게요🥹 */}
      <Footer />
    </div>
  );
}

export default App;
