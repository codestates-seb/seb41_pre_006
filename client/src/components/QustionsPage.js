import styled from "styled-components";
import QustionRow from "./QustionRow";

const StyledHeader = styled.h1`
  font-size: 1.1rem;
  font-weight: 500;
`;

const HeaderRow = styled.div`
  display: grid;
  grid-template-columns: 1fr min-content;
  padding: 32px 28px;
`;

const AskButton = styled.button`
  background-color: #0a95ff;
  font-size: 16px;
  color: #fff;
  border: none;
  border-radius: 4px;
  padding: 8px 16px;
`;

function QustionsPage() {
  return (
    <main>
      <HeaderRow>
        <StyledHeader>Top Qustion</StyledHeader>
        <AskButton>Ask&nbsp;Qustion</AskButton>
        <QustionRow />
      </HeaderRow>
    </main>
  );
}

export default QustionsPage;
