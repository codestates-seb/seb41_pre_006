import styled from "styled-components";

import Nav from "../components/Nav";
import Sidebar from "../components/Sidebar";
import HomeHeaderRow from "../components/HomeHeaderRow";
import QustionRow from "../components/QustionRow";

const Container = styled.section`
  display: flex;
  flex-direction: row;
  background-color: beige;
  /* position: relative; */
  /* padding-top: 54px; */
  width: 100%;
  background: none;
  margin: 0 auto;
`;

const Wrapper = styled.div`
  display: flex;
  justify-content: space-between;
  width: 100%;
  /* padding: 32px 32px 0 0; */
  margin: 32px 32px 32px 0;
`;

const Inner = styled.div`
  width: 100%;
  margin-right: 24px;
  /* background-color: beige; */
`;

const Home = () => {
  return (
    <Container>
      <Nav page="/" />
      <Wrapper>
        <Inner>
          <HomeHeaderRow />
          <QustionRow />
          <QustionRow />
          <QustionRow />
          <QustionRow />
          <QustionRow />
          <QustionRow />
        </Inner>
        <Sidebar />
      </Wrapper>
    </Container>
  );
};

export default Home;
