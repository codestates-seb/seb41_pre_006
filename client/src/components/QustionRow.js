import styled from "styled-components";

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

const QustionLink = styled.a`
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

function QustionRow() {
  return (
    <StyledQustionRow>
      <QustionStatArea>
        <QustionStat>
          0<span>votes</span>
        </QustionStat>
        <QustionStat>
          3<span>answers</span>
        </QustionStat>
        <QustionStat>
          8<span>views</span>
        </QustionStat>
      </QustionStatArea>
      <QustionListArea>
        <QustionLink>질문 타이틀 입니다.</QustionLink>
        <QustionPreview>
          질문 컨텐츠 입니다. 어쩌구.. 저쩌구.....
          <br />
          하여튼 안돼요... 그냥 안돼요.....
        </QustionPreview>
        <TagArea>
          <Tag>java</Tag>
          <Tag>react.js</Tag>
          <Tag>components</Tag>
          <Tag>literals</Tag>
        </TagArea>
        <LastUpdate>
          <UserLink>kim coding</UserLink>1 asked 30mins ago
        </LastUpdate>
      </QustionListArea>
    </StyledQustionRow>
  );
}

export default QustionRow;
