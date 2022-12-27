import styled from "styled-components";

import Nav from "../components/Nav";
import Sidebar from "../components/Sidebar";
import AskButton from "../components/AskButton";

const Container = styled.section`
  display: flex;
  /* padding-top: 54px; */
  width: 100%;
  background: none;
  margin: 0 auto;
`;

const Wrapper = styled.div`
  width: 100%;
  margin: 24px;
`;

const InnerH = styled.div`
  display: flex;
  justify-content: space-between;
  border-bottom: 1px solid #e3e6e8;
`;

const InnerW = styled.div`
  display: flex;
  margin-top: 24px;
`;

const StyledHeader = styled.h1`
  margin-bottom: 32px;
  font-size: 1.2rem;
  font-weight: 500;
`;

const Inner = styled.div`
  width: 100%;
  margin: 0 16px;
  background-color: #f3f4f5; // 영역 확인 후 삭제
  p {
    margin-bottom: 20px;
    width: 100%;
    font-size: 16px;
    line-height: 24px;
  }
`;

// demo components 레이아웃용 데모 스타일 입니다.
const Votes = styled.div`
  width: 32px;
  height: 100px;
  color: #6a737c;
  text-align: center;
  a {
    display: block;
    font-size: 32px;
  }
  p {
    margin: 8px 0;
    font-size: 24px;
  }
`;

const QuestionDetailPage = () => {
  return (
    <Container>
      <Nav />
      <Wrapper>
        <InnerH>
          <StyledHeader>All Questions</StyledHeader>
          <AskButton />
        </InnerH>
        <InnerW>
          <Votes>
            <a href="/">▲</a>
            <p>1</p>
            <a href="/">▼</a>
          </Votes>
          <Inner>데모 페이지입니다. 🥹 넣어주세요.</Inner>
          <Sidebar />
        </InnerW>
      </Wrapper>
    </Container>
  );
};

export default QuestionDetailPage;
