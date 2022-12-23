import React from "react";
import { Reset } from "styled-reset";
import GlobalStyle from "./styles/GlobalStyle";

import Header from "./components/Header";
import Footer from "./components/Footer";
import QustionsPage from "./components/QustionsPage";

function App() {
  return (
    <section className="App">
      <Reset />
      <GlobalStyle />
      <Header />
      <QustionsPage /> {/* 임시 레이아웃 */}
      <Footer />
      {/* 주석 샘플 나중에 날릴게요🥹 */}
    </section>
  );
}

export default App;
