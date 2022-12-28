import styled from "styled-components";
import { Link } from "react-router-dom";
// import QuestionDetailPage from "../pages/QuestionDetailPage";

// import { useState } from "react";

const StyledQustionRow = styled.div`
  display: flex;
  padding: 16px;
  border-top: 1px solid #e3e6e8;
`;

const QustionStatArea = styled.div`
  margin-right: 16px;
  margin-left: 48px;
  display: flex;
  align-items: flex-end;
  flex-direction: column;
`;
const QustionListArea = styled.div`
  width: 100%;
`;
const TagArea = styled.div`
  display: flex;
`;

const QustionStat = styled.div`
  display: flex;
  padding: 3px 4px;
  border-radius: 4px;
  border: 1px solid #fff;
  margin-bottom: 8px;
  font-size: 0.6rem;
  line-height: 0.6rem;
  font-weight: 500;
  span {
    margin-left: 4px;
    font-weight: 400;
  }
  &:hover {
    border-radius: 4px;
    border: 1px solid;
  }
`;

const QustionLink = styled(Link)`
  text-decoration: none;
  font-size: 0.7rem;
  display: block;
  margin: 2px 0 0 0;
  color: #0074cc;
  /* active demo 입니다. */
  &:active {
    background-color: #0a95ff;
  }
`;
const QustionPreview = styled.p`
  margin: 8px 0;
  font-size: 0.6rem;
  line-height: 0.8rem;
`;

const Tag = styled.a`
  margin-right: 8px;
  padding: 0.4em 0.5em;
  font-size: 0.6rem;
  color: #39739d;
  background-color: #e1ecf4;
  border-radius: 3px;
`;

const LastUpdate = styled.div`
  display: flex;
  align-items: flex-end;
  justify-content: flex-end;
  color: #6a737c;
  font-size: 0.6rem;
`;

const UserLink = styled.div`
  margin-right: 8px;
  color: #0074cc;
`;

const QustionRow = ({ question }) => {
  const { numberOfAnswer, voteCount, viewCount, title, content, userName } =
    question;
  return (
    <StyledQustionRow>
      <QustionStatArea>
        <QustionStat>
          {voteCount}
          <span>votes</span>
        </QustionStat>
        <QustionStat>
          {numberOfAnswer}
          <span>answers</span>
        </QustionStat>
        <QustionStat>
          {viewCount}
          <span>views</span>
        </QustionStat>
      </QustionStatArea>
      <QustionListArea>
        <QustionLink>
          <Link to={`/questions/detail`}>{title}</Link>
        </QustionLink>
        <QustionPreview>{content}</QustionPreview>
        <TagArea>
          <Tag>java</Tag>
          <Tag>react.js</Tag>
          <Tag>components</Tag>
          <Tag>literals</Tag>
        </TagArea>
        <LastUpdate>
          <UserLink>{userName}</UserLink>1 asked 30mins ago
        </LastUpdate>
      </QustionListArea>
    </StyledQustionRow>
  );
};

export default QustionRow;
