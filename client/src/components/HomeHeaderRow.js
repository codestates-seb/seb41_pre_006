import { useEffect } from "react";
import styled from "styled-components";
import AskButton from "./AskButton";
// import { Wrapper } from "./Home/Sidebar/Sidebar_style";

const Conteiner = styled.div`
  margin: 0 16px 32px 32px;
  .sort {
    display: flex;
    justify-content: space-between;
    font-size: 0.7rem;
  }
  .question-sort {
    border: 1px solid;
    border-radius: 4px;
    button {
      background-color: #e3e6e8;
      font-size: 0.7rem;
      font-weight: 300;
    }
  }
  > div {
    > span {
      font-size: 2em;
    }
  }
`;

const WrapperH = styled.div`
  display: flex;
  justify-content: space-between;
`;

const StyledHeader = styled.h1`
  margin-bottom: 32px;
  font-size: 1.7rem;
  font-weight: 500;
`;

const HomeHeaderRow = () => {
  return (
    <Conteiner>
      <WrapperH>
        <StyledHeader>All Questions</StyledHeader>
        <AskButton />
      </WrapperH>
      <div className="sort">
        <span>0 questions</span>
        <div className="question-sort">
          <button className={""} value={"newest"}>
            Newest
          </button>
          <button className={""} value={"votes"}>
            Votes
          </button>
        </div>
      </div>
    </Conteiner>
  );
};

export default HomeHeaderRow;
