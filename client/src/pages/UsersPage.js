import styled from "styled-components";
import Nav from "../components/Nav";

const title = "Users";

const Container = styled.section`
  display: flex;
  flex-direction: row;
  background-color: beige;
  /* position: relative; */
  padding-top: 54px;
  width: 100%;
  background: none;
  margin: 0 auto;
`;

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  margin: 32px;
  background-color: beige; // 영역 확인 후 삭제
`;

const StyledHeader = styled.h1`
  margin-bottom: 20px;
  font-size: 1.2rem;
  font-weight: 500;
`;

const Inner = styled.div`
  width: 100%;
  p {
    margin-bottom: 20px;
    width: 100%;
    font-size: 16px;
    line-height: 24px;
    background-color: bisque; // 영역 확인 후 삭제
  }
  div {
    background-color: #d3d3d3; // 영역 확인 후 삭제
  }
`;

const UsersPage = () => {
  return (
    <Container>
      <Nav />
      <Wrapper>
        <StyledHeader>{title}</StyledHeader>
        <Inner>
          <div>데모 페이지입니다. 🥹 컴포넌트를 넣어주세요.</div>
        </Inner>
      </Wrapper>
    </Container>
  );
};

export default UsersPage;
