import styled from "styled-components";

import HomeHeaderRow from "../components/HomeHeaderRow";

const Conteiner = styled.section`
  left: 154px;
  top: 54px;
  width: calc(100vw - 184px);
  padding: 32px 24px 32px 0;
`;

const QuestionDetailPage = () => {
  return (
    <Conteiner>
      <HomeHeaderRow />
      <h1>QuestionDetailPage</h1>
      <p>글상세 페이지 demo 입니다.</p>
    </Conteiner>
  );
};

export default QuestionDetailPage;
