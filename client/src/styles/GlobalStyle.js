// css 초기화
import reset from "styled-reset";
import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`
  ${reset}
  @import url('https://fonts.googleapis.com/css2family=Roboto:wght@300;400;700&display=swap'); 
  
  * {
    box-sizing: border-box;
    
  }

  html, body{
    margin: 0;
    padding: 0;
    font-family: "Roboto",system-ui,BlinkMacSystemFont,"Segoe UI","Helvetica Neue",Arial,sans-serif; 
  }
  a {
    text-decoration: none;
    outline: none;
    font-size: 100%;
    color: inherit;
  }
  input, button {
    background-color: transparent;
    border: none;
    outline: none;
  }
  h1, h2, h3, h4, h5, h6{
    font-weight: normal;
    margin: 0;
    font-size: 100%;
  }
  ol, ul, li {
    margin: 0;
    padding: 0;
    list-style: none;
  }
  img {
    display: block;
    width: 100%;
    height: 100%;
  }
  // button {
  //   cursor: pointer;
  //   box-sizing: border-box;
  //   padding: 0;
  //   background-color: transparent;
  //   font-size: 100%;
  //   border: none;
  // }
  //임시: main tag를 Conteiner용으로 사용중입니다.
  main {
    z-index: 6000;
    overflow-y: auto;
    position: relative !important ;
    left: 0;
    // top: 54px;
    width: 100vw;
    // padding: 32px 24px 32px 0;
    // background-color: #d3d3d3;
  };
`;
export default GlobalStyle;
