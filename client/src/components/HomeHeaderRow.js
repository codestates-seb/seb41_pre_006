import styled from "styled-components";
import AskButton from "./AskButton";

const Conteiner = styled.div`
  display: flex;
  justify-content: space-between;
  margin: 0 16px 32px 32px;
`;

const StyledHeader = styled.h1`
  margin-bottom: 16px;
  font-size: 1.2rem;
  font-weight: 500;
`;

const HomeHeaderRow = () => {
  return (
    <Conteiner>
      <StyledHeader>All Questions</StyledHeader>
      <AskButton />
    </Conteiner>
  );
};

export default HomeHeaderRow;
