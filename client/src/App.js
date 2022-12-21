import { Reset } from "styled-reset";
import { createGlobalStyle } from "styled-components";

import Header from "./components/Header";
import QustionsPage from "./components/QustionsPage";
import Footer from "./components/Footer";
// import GlobalStyles from "./GlobalStyles";

const GlobalStyles = createGlobalStyle`
  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');
  body {
      font-family: 'Roboto', sans-serif;
  }
`;

function App() {
  return (
    <section className="App">
      <Reset />
      <GlobalStyles />
      <Header />
      <QustionsPage /> {/* 임시 레이아웃 */}
      <Footer />
      {/**/}
    </section>
  );
}

export default App;
