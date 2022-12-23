// css 초기화
import { createGlobalStyle } from "styled-components";
import reset from "styled-reset";

const GlobalStyle = createGlobalStyle`
  ${reset}
  // 아래에 전역 스타일을 추가.
  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');
  * {
    box-sizing: border-box;
  }
  body{
    margin: 0;
    padding: 0;
    min-height: 100vh;
    background-color: #ffffff;
    color: #232629;
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
  ul {
    margin: 0;
    padding: 0;
  }
  ol, ul, li {
    list-style: none;
  }
  img {
    display: block;
    width: 100%;
    height: 100%;
  }
  button {
    padding: 0;
    background-color: transparent;
    font-size: 100%;
    border: none;
    cursor: pointer;
  }
`;

export default GlobalStyle;
