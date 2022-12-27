import styled from "styled-components";
import { Link } from "react-router-dom";
import { InfoSvg, StarSvg, EarthSvg } from "./images/HomeSvg";
import Footer from "./components/Footer";

const Container = styled.div`
  z-index: 6000;
  overflow-y: auto;
  position: sticky !important ;
  top: 54px;
  left: 0;
  /* padding-top: 54x; */
  width: 154px;
  height: 100vh;
  padding: 24px 16px;
  border-right: 1px solid #e3e6e8;
  background-color: none;
`;

const LlTitle = styled.ul`
  cursor: pointer;
  text-transform: uppercase !important;
  color: #525960;
  font-size: 11px;
  margin-left: 4px !important;
  margin-bottom: 4px !important;
  margin-top: 16px !important;
  a {
    margin-right: 8px;
    svg {
      /* fill: hsl(210, 8%, 45%); */
    }
  }
`;

const LeftSideBarLl = styled.li`
  position: relative !important;
  font-size: 13px;
  line-height: 30px;
  margin-left: 16px;
  a {
    display: block;
    padding: 4px;
    line-height: 2;
    &.sub {
      display: flex;
      padding: 8px 6px 8px 6px;
      color: hsl(210, 8%, 35%);
      svg {
        flex-shrink: 0;
        margin-top: -1px;
        margin-right: 4px;
        fill: hsl(210, 8%, 55%);
        vertical-align: bottom;
        &:hover {
          fill: #222;
        }
        &.orange {
          fill: hsl(27, 90%, 55%);
        }
      }
      span {
        line-height: 15px;
      }
      &.inSub {
        padding-left: 30px;
      }
    }
    &:hover {
      color: #222;
    }
  }
  &.active {
    border-right: 3px solid hsl(27deg 90% 55%);
  }
  &.active a {
    font-weight: bold;
    background-color: hsl(210, 8%, 95%);
    color: #222;
  }
`;

function Nav() {
  return (
    <Container>
      <ul>
        <Link to={"/"}>
          <LlTitle>Home</LlTitle>
        </Link>
      </ul>
      <ul>
        <LlTitle>Public</LlTitle>
        <Link to={"/"}>
          <LeftSideBarLl>Questions</LeftSideBarLl>
        </Link>
        <Link to={"/tags"}>
          <LeftSideBarLl>Tags</LeftSideBarLl>
        </Link>
        <Link to={"/users"}>
          <LeftSideBarLl>Users</LeftSideBarLl>
        </Link>
        {/* <Link to={"/"}></Link> */}
      </ul>
    </Container>
  );
}

export default Nav;
