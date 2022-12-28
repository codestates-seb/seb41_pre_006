import styled from "styled-components";

import Nav from "../components/Nav";
import Sidebar from "../components/Sidebar";
import QuestionsList from "../components/QuestionsList";

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

const Home = () => {
  return (
    <Container>
      <Nav page="/" />
      <Wrapper>
        <QuestionsList />
        <Sidebar />
      </Wrapper>
    </Container>
  );
};

export default Home;
