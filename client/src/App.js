import React from "react";
import { Route, Routes } from "react-router-dom";
import { Reset } from "styled-reset";
import GlobalStyle from "./styles/GlobalStyle";

import Header from "./components/Header";
import Footer from "./components/Footer";

import QustionsListPage from "./pages/QustionsListPage";

import Login from "./pages/Login";
// import LogOut from "./pages/LogOut";
// import SignUp from "./pages/SignUp";
// import NotFound from "./components/NotFound";

import Home from "./pages/Home";
// import QustionsListPage from "./pages/QustionsListPage"; // 글리스트페이지
import QuestionDetailPage from "./pages/QuestionDetailPage"; // 글상세페이지";
import AskQuestion from "./pages/AskQuestion"; // 글쓰기페이지;
import QuestionEditPage from "./pages/QuestionEditPage"; // 글수정하기페이지";
import EditAnswerPage from "./pages/EditAnswerPage"; // 답변수정하기페이지";
import ProfilePage from "./pages/ProfilePage"; // 유저프로필페이지
import TagsPage from "./pages/TagsPage"; // 태그페이지
import UsersPage from "./pages/UsersPage"; // 유저페이지

function App() {
  return (
    <div className="App">
      <GlobalStyle />
      <Reset />
      <Header />
      <main>
        <Routes>
          <Route path="/users/login" element={<Login />} />
          {/* <Route path="/users/logout" element={<LogOut />} /> */}
          {/* <Route path="/users/signup" element={<SignUp />} /> */}
          {/* <Route path="/users/signup/success" element={<SignupSuccess />} /> */}
          {/* <Route path="/users/signup/recovery" element={<SignupRecovery />} /> */}
          <Route path="/" element={<Home />} />
          <Route path="/qustions/" element={<QustionsListPage />} />
          <Route path="/questions/ask" element={<AskQuestion />} />
          <Route path="/questions/edit" element={<QuestionEditPage />} />
          <Route path="/questions/edit/" element={<EditAnswerPage />} />
          <Route path="/questions/detail" element={<QuestionDetailPage />} />
          <Route path="/pofile" element={<ProfilePage />} />
          <Route path="/tags" element={<TagsPage />} />
          <Route path="/users" element={<UsersPage />} />
        </Routes>
      </main>
      {/*
       */}
      {/* 주석 샘플 나중에 날릴게요🥹 */}
      <Footer />
    </div>
  );
}

export default App;
