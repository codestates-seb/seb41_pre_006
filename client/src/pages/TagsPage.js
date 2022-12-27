import styled from "styled-components";
import Nav from "../components/Nav";

import { TagsSection } from "../components/Tags/TagsSection";
import { TagsTab } from "../components/Tags/TagsTab";
// import { TagsPagination } from "../components/Tags/TagsPagination";

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
  /* background-color: beige; // 영역 확인 후 삭제 */
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
    /* background-color: bisque; // 영역 확인 후 삭제 */
  }
  div {
    /* background-color: #d3d3d3; // 영역 확인 후 삭제 */
  }
`;

const TagsPage = () => {
  return (
    <Container>
      <Nav />
      <Wrapper>
        <StyledHeader>Tags</StyledHeader>
        <Inner>
          <p>
            A tag is a keyword or label that categorizes your question with
            other, similar questions. <br />
            Using the right tags makes it easier for others to find and answer
            your question.
          </p>
          <>
            <TagsTab />
            <TagsSection />
            {/* <TagsPagination /> */}
          </>
        </Inner>
      </Wrapper>
    </Container>
  );
};

export default TagsPage;
